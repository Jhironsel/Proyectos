package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Role;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Role {

    /**
     * Metodo que devuelve los roles que tiene los usuarios en el sistema
     * asignados.
     *
     * @param userName
     * @param disponible
     *
     * @return Devuelve una lista de roles del sistema que tiene un usuario en
     * el sistema.
     */
    public synchronized static List<Role> selectDisponibles(
            String userName, 
            boolean disponible
    ) {
        String sql = "";
        if(disponible){
            sql = """
                  SELECT 
                       TRIM(b.RDB$ROLE_NAME) ROL, 
                       TRIM(COALESCE(b.RDB$DESCRIPTION, '')) DESCRIPCION,
                       a.RDB$GRANT_OPTION ADMINISTRACION
                  FROM RDB$USER_PRIVILEGES a
                  INNER JOIN RDB$ROLES b ON a.RDB$RELATION_NAME = b.RDB$ROLE_NAME AND 
                                           TRIM(a.RDB$PRIVILEGE) = 'M' AND 
                                           a.RDB$USER = ? AND 
                                           b.RDB$ROLE_NAME NOT STARTING WITH 'RRR_' AND 
                                           a.RDB$GRANTOR IS NOT NULL
                  """;
        }else{
            sql = """
                  SELECT 
                        TRIM(b.RDB$ROLE_NAME) ROL,
                        TRIM(COALESCE(b.RDB$DESCRIPTION, '')) DESCRIPCION,
                        a.RDB$GRANT_OPTION ADMINISTRACION
                   FROM RDB$USER_PRIVILEGES a
                   RIGHT JOIN RDB$ROLES b ON a.RDB$RELATION_NAME = b.RDB$ROLE_NAME AND 
                                            TRIM(a.RDB$PRIVILEGE) = 'M' AND 
                                            a.RDB$USER = ? AND 
                                            a.RDB$GRANTOR IS NOT NULL
                   WHERE a.RDB$RELATION_NAME IS NULL  AND b.RDB$ROLE_NAME NOT STARTING WITH 'RRR_'
                  """;
        }

        List<Role> roles = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setString(1, userName.strip().toUpperCase());

            try (ResultSet rs = ps.executeQuery()) {

                String aux, descripcion;

                while (rs.next()) {
                    aux = rs.getString("ROL").strip();

                    descripcion = rs.getString("DESCRIPCION");

                    roles.add(
                            Role
                                    .builder()
                                    .roleName(aux.strip())
                                    .descripcion(
                                            Objects.isNull(descripcion)
                                            ? "" : descripcion.strip()
                                    )
                                    .opcionPermiso(rs.getInt("ADMINISTRACION"))
                                    .build()
                    );
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_LOS_ROLES_DEL_SISTEMA,
                    ex
            );
        }
        return roles;
    }
    public static final String ERROR_AL_CONSULTAR_LOS_ROLES_DEL_SISTEMA
            = "Error al consultar GET_ROLES los roles del sistema.";

    /**
     * Es el metodo que nos devuelve los Roles del sistema, los cuales son asig-
     * nados a los usuarios.
     *
     * @return
     */
    public synchronized static List<Role> getRoles() {
        final String sql = """
                           SELECT ROL, PROPIETARIO, DESCRIPCION 
                           FROM GET_ROLES
                           """;

        List<Role> rolesList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    String rol, descripcion, propietario;

                    rol = rs.getString("Rol");
                    descripcion = rs.getString("Descripcion");
                    propietario = rs.getString("PROPIETARIO");

                    rolesList.add(
                            Role
                                    .builder()
                                    .roleName(Objects.isNull(rol) ? "" : rol.strip())
                                    .descripcion(Objects.isNull(descripcion) ? "" : descripcion.strip())
                                    .propietario(Objects.isNull(propietario) ? "" : propietario.strip())
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
        return rolesList;
    }

    /**
     * Este metodo nos permite establecer el rol que el usuario usará en el
     * sistema, puede ser ejecutado una vez que el usuario haya iniciado
     * session.
     *
     * Es un procedimiento de uso publico, ya que todos van a cambiar su rol en
     * el sistema.
     *
     * @param i_role Nombre del rol que va a establecerse al usuario que ejecute
     * el metodo.
     * @return
     */
    public synchronized static Resultado setRole(
            String i_role
    ) {
        String sql = "EXECUTE PROCEDURE ADMIN_SET_ROLE(?)";
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            cs.setString(1, i_role);

            cs.execute();

            return Resultado
                    .builder()
                    .mensaje(ROL_ESTABLECIDO)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ESTABLECER_ROL,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ESTABLECER_ROL)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ROL_ESTABLECIDO
            = "Rol establecido.";
    public static final String ERROR_AL_ESTABLECER_ROL
            = "Error al establecer rol.";

    /**
     * Este metodo nos permite establecer el rol que el usuario usará en el
     * sistema, puede ser ejecutado una vez que el usuario haya iniciado
     * session.
     *
     * Es un procedimiento de uso publico, ya que todos van a cambiar su rol en
     * el sistema.
     *
     * @param i_role Nombre del rol que va a establecerse al usuario que ejecute
     * el metodo.
     * @return
     */
    public synchronized static Resultado dropRole(
            String i_role
    ) {
        String sql = "EXECUTE PROCEDURE ADMIN_BORRAR_ROLE(?)";

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {

            cs.setString(1, i_role);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(ROLE_ELIMINADO)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(true)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_ROL)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR_ROL = "Error al borrar rol";
    public static final String ROLE_ELIMINADO = "Role eliminado";

    /**
     * Este metodo permite ejecutar procedimientos que otorgan permisos a los
     * roles.
     *
     * @param procedimiento Es el procedimiento que se ejecuta en la BD. Debe de
     * tener las iniciales de PERM_ para ejecutarse.
     *
     * @param rol es el rol a la cual se le va a dar los permisos necesarios
     * para ejecutar el procedimiento.
     *
     * @param admin Es la bandera que indica si el permiso tendrá derecho de
     * administrarlo o de cedelo a otros usuario.
     *
     * @param otorgar Permite determinar si el usuario va a recibir el permiso
     * en el caso de que sea true, en caso contrario se le quita los permisos
     * false.
     *
     * @return Devuelve un objecto de la clase resultados que indica si la
     * operacion fue un exito si o no.
     */
    public synchronized static Resultado asignarRol(
            String procedimiento,
            String rol,
            boolean admin,
            boolean otorgar
    ) {
        if (!procedimiento.startsWith("PERM_")) {
            return Resultado
                    .builder()
                    .mensaje(PROCEDIMIENTO_INCORRECTO_A_LA_BASE_DE_DAT)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }

        String sql = "EXECUTE PROCEDURE ".concat(procedimiento).concat(" (?,?,?)");

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            //Parametros
            cs.setString(1, rol);
            cs.setBoolean(2, admin);
            cs.setBoolean(3, otorgar);

            //Ejecucion del procedimiento.
            cs.executeUpdate();

            //Devolucion de los resultados.
            return Resultado
                    .builder()
                    .mensaje(PERMISO__ACTUALIZADO)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(true)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ESTABLECER_ROL1)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(false)
                    .build();
        }
    }
    public static final String PERMISO__ACTUALIZADO
            = "Permiso Actualizado.";
    public static final String ERROR_AL_ESTABLECER_ROL1
            = "Error al establecer rol";
    public static final String PROCEDIMIENTO_INCORRECTO_A_LA_BASE_DE_DAT
            = "Procedimiento incorrecto a la base de datos.";

    /**
     * Metodo encargado de dar los coles a los usuarios.
     *
     * @param usuario
     * @param rol
     * @param admin
     * @return
     */
    public synchronized static Resultado asignarRolUsuario(
            String rol,
            String usuario,
            boolean admin
    ) {
        String sql = "EXECUTE PROCEDURE ADMIN_DAR_ROL_USUARIO(?,?,?)";

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            cs.setString(1, rol);
            cs.setString(2, usuario);
            cs.setBoolean(3, admin);

            cs.execute();

            return Resultado
                    .builder()
                    .mensaje(ROL_ASIGNADO_A_USUARIO)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ASIGNAR_ROL,
                    ex
            );

            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ASIGNAR_ROL)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_ASIGNAR_ROL
            = "Error al asignar rol";
    public static final String ROL_ASIGNADO_A_USUARIO
            = "Rol asignado a usuario";

    /**
     * Este metodo quita un rol en especifico a un usuario. 
     * 
     * @param usuario Nombre ddel usuario.
     * @param rol nombre del rol a quitar.
     * 
     * @return Devuelve un resultado de la operacion. 
     */
    public synchronized static Resultado quitarRolUsuario(
            String rol, String usuario
    ) {
        String sql = "EXECUTE PROCEDURE ADMIN_QUITAR_ROL_USUARIO(?,?)";
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT)) {

            cs.setString(1, rol);
            cs.setString(2, usuario);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(ROL_BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);

            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR__ROL)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR__ROL
            = "Error al borrar Rol";
    public static final String ROL_BORRADO_CORRECTAMENTE
            = "Rol borrado correctamente.";
    
    /**
     * Este metodo quita un rol en especifico a un usuario. 
     * 
     * @param usuario Nombre ddel usuario.
     * 
     * @return Devuelve un resultado de la operacion. 
     */
    public synchronized static Resultado quitarRolesUsuario(
            String usuario
    ) {
        String sql = "EXECUTE PROCEDURE ADMIN_QUITAR_ROLES_USUARIO(?)";
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT)) {

            cs.setString(1, usuario);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(ROL_BORRADO_CORRECTAMENTE2)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);

            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR__ROL2)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR__ROL2
            = "Error al borrar los roles del usuario.";
    public static final String ROL_BORRADO_CORRECTAMENTE2
            = "Roles borrado correctamente.";

    /**
     * Metodo utilizado para crear los roles de los usuarios del sistema.
     *
     * @param rolee Es el role a crear por el usuario.
     * @return
     */
    public synchronized static Resultado createRole(
            String rolee
    ) {
        final String sql = "EXECUTE PROCEDURE ADMIN_CREATE_ROLE(?);";

        try (PreparedStatement cs = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            cs.setString(1, rolee);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(ROL_CREADO_EXITOSAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(true)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_CREAR_ROLE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(false)
                    .build();
        }
    }
    public static final String ERROR_AL_CREAR_ROLE = "Error al crear role.";
    public static final String ROL_CREADO_EXITOSAMENTE = "Rol creado exitosamente.";

    /**
     * SP que permite a los administradores modificar los nombres de los roles y
     * pasar los permisos y asignaciones de los roles al nuevo rol creado.
     *
     * @param actual recibe el nombre de un rol existente.
     * @param nuevo recibe el nuevo nombre del rol a crear.
     *
     * @return devuelve un objecto Resultados para obtener informacion de la op.
     */
    public synchronized static Resultado modificarRol(
            String actual, String nuevo
    ) {
        final String sql = "EXECUTE PROCEDURE ADMIN_ALTER_ROLE(?, ?);";

        try (PreparedStatement cs = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT)) {

            cs.setString(1, actual);
            cs.setString(2, nuevo);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(ROL_MODIFICADO_EXITOSAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(true)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_ROLE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(false)
                    .build();
        }
    }
    public static final String ERROR_AL_MODIFICAR_ROLE
            = "Error al modificar role.";
    public static final String ROL_MODIFICADO_EXITOSAMENTE
            = "Rol modificado exitosamente.";
}
