package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            cs.setString(1, usuario.getPersona().getUser_name());
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
                            usuario.getPersona().getUser_name(),
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
            cs.setString(1, usuario.getPersona().getUser_name());
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
                            usuario.getPersona().getUser_name(),
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

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name(rs.getString("USUARIO"))
                                        .rol(rs.getString("ROLE"))
                                        .build()
                        )
                        .build();
            }
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
     * Metodo para llamar a los usuarios del sistema, este ejecuta un \n
     * procedimiento almacenado que realizar el SELECT complejo en la BD.
     *
     * Actualizado 09 Julio 2022, se agregar el campo estatico de la clase
     * Usuario el cual contiene el SQL de la consulta de este metodo.
     *
     * Consulta que nos permite tener el nombre de usuario, primer nombre,
     * segundo nombre, apellidos, estado del usuario, si es administrador y una
     * breve descripcion del usuario que se haya registrado.
     *
     * @param userName Es el identificador que utiliza el usuario para iniciar
     * session en el sistema, este campo tambien puede recibir un string con el
     * valor all para obtener todos los usuarios del sistema.
     *
     * @return retorna un conjunto de valores dependiendo del valor pasado por
     * parametro, si se le pasa all recibi un conjunto de datos de todos los
     * usuarios del sistema.
     */
    public synchronized static Usuario getUsuario(String userName) {
        final String sql
                = "SELECT PNOMBRE, SNOMBRE, APELLIDOS, ESTADO, ADMINISTRADOR, "
                + "         DESCRIPCION "
                + "FROM VS_USUARIOS "
                + "WHERE TRIM(UPPER(USERNAME)) STARTING WITH UPPER(TRIM(?));";

        Usuario usuario = Usuario
                            .builder()
                            .persona(
                                    Persona
                                            .builder()
                                            .pnombre("Usuario")
                                            .snombre("NO")
                                            .apellidos("encontrado")
                                            .estado(false)
                                            .user_name(userName)
                                            .build()
                            )
                            .administrador(false)
                            .descripcion("Usuario no se encuentra en el sistema.")
                            .build();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {

            ps.setString(1, userName);

            try (ResultSet rs = ps.executeQuery();) {
                if (rs.absolute(1)) {
                    usuario = Usuario
                            .builder()
                            .persona(
                                    Persona
                                            .builder()
                                            .pnombre(rs.getString("PNOMBRE"))
                                            .snombre(rs.getString("SNOMBRE"))
                                            .apellidos(rs.getString("APELLIDOS"))
                                            .estado(rs.getBoolean("ESTADO"))
                                            .user_name(userName)
                                            .build()
                            )
                            .administrador(rs.getBoolean("ADMINISTRADOR"))
                            .descripcion(rs.getString("DESCRIPCION"))
                            .build();
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return usuario;
    }

    /**
     * Se esta utilizando para llenar la tabla de usuarios.
     *
     * Este Query es utilizado para obtener Inf. de los usuarios del sistema.
     * Actualizado: 15 Sep 2022.
     *
     * @return
     */
    public synchronized static List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        final String sql
                = "SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO, "
                + "     ADMINISTRADOR, DESCRIPCION "
                + "FROM VS_USUARIOS;";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {

            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    usuarios.add(Usuario
                            .builder()
                            .persona(
                                    Persona
                                            .builder()
                                            .pnombre(rs.getString("PNOMBRE"))
                                            .snombre(rs.getString("SNOMBRE"))
                                            .apellidos(rs.getString("APELLIDOS"))
                                            .estado(rs.getBoolean("ESTADO"))
                                            .user_name(rs.getString("USERNAME"))
                                            .build()
                            )
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
}
