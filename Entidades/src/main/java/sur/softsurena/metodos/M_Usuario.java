package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.metodos.M_Role.asignarRolUsuario;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Usuario {

    /**
     * Metodo que permite el cambio de contraseña de un usuario en el sistema.
     *
     * Este metodo evita que un usuario le cambie la contraseña a otro usuario.
     *
     * Metodo revisado el 24 de abril 2022. Metodo actualizado el 19 05 2022,
     * Nota, se cambia la posicion del parametro, primero usuario y luego la
     * clave.
     *
     * @param usuario
     * @param clave Es la clave del usuario actual que permite la actualizacion
     * de su clave.
     * @return
     */
    public synchronized static boolean cambioClave(String usuario, String clave) {
        final String sql
                = "EXECUTE PROCEDURE ADMIN_CAMBIAR_CLAVE_USUARIO_ACTUAL(?, ?);";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, usuario);
            ps.setString(2, clave);

            ps.execute();

            return true;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
//------------------------------------------------------------------------------

    /**
     * Metodo utilizado para modificar los usuarios del sistema con el rol
     * doctor, el cual permite agregar al registro su Exequatur y
     * Especialidad.Metodo actualizado el 19 05 2022.
     *
     *
     * @param usuario Un objeto de la clase Usuario.
     * @return Devuelve un mensaje que indica si la actualizacion fue exitosa.
     */
    public static synchronized Resultado insert(Usuario usuario) {
        final String sql
                = "EXECUTE PROCEDURE SP_I_USUARIO(?,?,?,?,?,?,?,?,?)";

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setString(1, usuario.getUserName());
            cs.setString(2, usuario.getClave());
            cs.setString(3, usuario.getPersona().getPnombre());
            cs.setString(4, usuario.getPersona().getSnombre());
            cs.setString(5, usuario.getPersona().getApellidos());
            cs.setBoolean(6, usuario.getPersona().getEstado());
            cs.setBoolean(7, usuario.getAdministrador());
            cs.setString(8, usuario.getDescripcion());
            cs.setString(9, usuario.getTags());

            cs.executeUpdate();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_AGREGAR__USUARIO,
                    ex
            );

            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_AGREGAR__USUARIO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
        usuario.getRoles().stream().forEach(
                role -> {
                    asignarRolUsuario(
                            role.getRoleName(),
                            usuario.getUserName(),
                            role.isConAdmin()
                    );
                }
        );

        return Resultado
                .builder()
                .mensaje(USUARIO_AGREGADO_CORRECTAMENTE)
                .icono(JOptionPane.INFORMATION_MESSAGE)
                .estado(Boolean.TRUE)
                .build();
    }
    public static final String USUARIO_AGREGADO_CORRECTAMENTE
            = "Usuario agregado correctamente.";
    public static final String ERROR_AL_AGREGAR__USUARIO
            = "Error al agregar Usuario...";
//------------------------------------------------------------------------------

    /**
     * Metodo para modificar a los usuarios en el sistema.
     *
     * @param usuario
     * @return
     */
    public static synchronized Resultado update(Usuario usuario) {
        final String sql
                = "EXECUTE PROCEDURE SP_U_USUARIO (?,?,?,?,?,?,?,?,?";
        try (CallableStatement cs = getCnn().prepareCall(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            cs.setString(1, usuario.getUserName());
            cs.setString(2, usuario.getClave());
            cs.setString(3, usuario.getPersona().getPnombre());
            cs.setString(4, usuario.getPersona().getSnombre());
            cs.setString(5, usuario.getPersona().getApellidos());
            cs.setBoolean(6, usuario.getPersona().getEstado());
            cs.setBoolean(7, usuario.getAdministrador());
            cs.setString(8, usuario.getDescripcion());
            cs.setString(9, usuario.getTags());
            cs.executeUpdate();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_USUARIO)
                    .estado(Boolean.FALSE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .build();
        }
        usuario.getRoles().forEach(
                role -> {
                    asignarRolUsuario(
                            role.getRoleName(),
                            usuario.getUserName(),
                            role.isConAdmin()
                    );
                }
        );

        return Resultado
                .builder()
                .mensaje(USUARIO_MODIFICADO_CORRECTAMENTE)
                .estado(Boolean.TRUE)
                .icono(JOptionPane.INFORMATION_MESSAGE)
                .build();
    }
    public static final String ERROR_AL_MODIFICAR_USUARIO
            = "Error al modificar usuario...";
    public static final String USUARIO_MODIFICADO_CORRECTAMENTE
            = "Usuario modificado correctamente.";

    /**
     * Para matener la mejor integridad de los datos los usuario se desactivan
     * del sistema.
     *
     * Metodo revisado 24 abril 2022.
     *
     * @param loginName
     * @return
     */
    public synchronized static Resultado delete(String loginName) {

        final String sql = "EXECUTE PROCEDURE SP_D_USUARIO(?);";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, loginName);
            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(USUARIO_BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_USUARIO,
                    ex
            );
            if (ex.getMessage().contains("E_CAJERO_TURNO_ACTIVO")) {
                return Resultado
                        .builder()
                        .mensaje(CAJERO_CUENTA_CON_UN_TURNO_ACTIVO)
                        .icono(JOptionPane.WARNING_MESSAGE)
                        .estado(Boolean.FALSE)
                        .build();
            }

            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_USUARIO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String CAJERO_CUENTA_CON_UN_TURNO_ACTIVO
            = "Cajero cuenta con un turno activo.";
    public static final String USUARIO_BORRADO_CORRECTAMENTE
            = "Usuario borrado correctamente.";
    public static final String ERROR_AL_BORRAR_USUARIO
            = "Error al borrar usuario.";

    /**
     * Metodo para consultar cual es el usuario actual del sistema.<br>
     *
     * Una vez iniciada la session del usuario en el sistema, hacemos una
     * consulta a la base de datos, que nos devuelve el usuario y el rol de
     * este.<br>
     *
     * @return Un objecto de la clase usuario con los datos del usuario del
     * sistema que ha iniciado sessión actualmente.<br>
     */
    public synchronized static Usuario getUsuarioActual() {
        final String sql = """
                           SELECT 
                                TRIM(CURRENT_USER) USUARIO, 
                                IIF(TRIM(CURRENT_ROLE) = 'RDB$ADMIN', 'ADMINISTRADOR', TRIM(CURRENT_ROLE)) ROLE 
                           FROM RDB$DATABASE
                           """;

        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery(sql);
            rs.next();
            return Usuario
                    .builder()
                    .persona(
                            Persona
                                    .builder()
                                    .rol(rs.getString("ROLE"))
                                    .build()
                    )
                    .userName(rs.getString("USUARIO"))
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return null;
        }
    }

    /**
     *
     * @param usuario
     * @return
     */
    public synchronized static List<Usuario> select(Usuario usuario) {
        List<Usuario> usuarios = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(usuario),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    usuarios.add(
                            Usuario
                                    .builder()
                                    .persona(
                                            Persona
                                                    .builder()
                                                    .pnombre(rs.getString("PNOMBRE"))
                                                    .snombre(rs.getString("SNOMBRE"))
                                                    .apellidos(rs.getString("APELLIDOS"))
                                                    .estado(rs.getBoolean("ESTADO"))
                                                    .build()
                                    )
                                    .userName(rs.getString("USERNAME"))
                                    .administrador(rs.getBoolean("ADMINISTRADOR"))
                                    .descripcion(rs.getString("DESCRIPCION"))
                                    .build()
                    );
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return usuarios;
    }

    public static String sqlSelect(Usuario usuario) {
        Boolean userName = Objects.isNull(usuario.getUserName());
        Boolean nombresApellidos
                = Objects.isNull(usuario.getPersona().getPnombre())
                && Objects.isNull(usuario.getPersona().getSnombre())
                && Objects.isNull(usuario.getPersona().getApellidos());
        Boolean estado = Objects.isNull(usuario.getPersona().getEstado());
        Boolean administradores = Objects.isNull(usuario.getAdministrador());

        Boolean where = userName && nombresApellidos && estado && administradores;

        final String sql
                = """
                  SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO,
                        ADMINISTRADOR, DESCRIPCION 
                  FROM VS_USUARIOS
                  %s%s%s%s
                  """.strip().formatted(
                        where ? "" : "WHERE ",
                        nombresApellidos ? "" : "USERNAME STARTING WITH '%s' OR PNOMBRE STARTING WITH '%s' OR SNOMBRE STARTING WITH '%s' OR APELLIDOS STARTING WITH '%s' ".formatted(
                                        usuario.getUserName(),
                                        usuario.getPersona().getPnombre(),
                                        usuario.getPersona().getSnombre(),
                                        usuario.getPersona().getApellidos()
                                ),
                        estado ? "" : "ESTADO IS %B ".formatted(usuario.getPersona().getEstado()),
                        administradores ? "" : "ADMINISTRADOR IS %B ".formatted(usuario.getAdministrador())
                ).strip();

        return sql;
    }
}
