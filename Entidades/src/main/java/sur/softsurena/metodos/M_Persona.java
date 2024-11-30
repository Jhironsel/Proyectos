package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.Cleanup;
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * 
 * @author jhironsel
 */
public class M_Persona {

    /**
     * Nos permite agregar una persona al sistema y dovolver el identificador 
     * asignado.
     * 
     * @param persona objeto persona que tiene una caracteristica de la persona 
     * que va hacer registrado en el sistema.
     * 
     * @return nos devolver un objeto Resultado que contiene el 
     * identificador asignado.
     */
    public static Resultado agregarEntidad(Persona persona) {
        final String sql = """
                           SELECT ID_PERSONA
                           FROM SP_I_PERSONA(?,?,?,?,?,?,?);
                           """;

        int idPersona = -1;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setString(1, persona.getPersona().toString());
            ps.setString(2, persona.getPnombre());
            ps.setString(3, persona.getSnombre());
            ps.setString(4, persona.getApellidos());
            ps.setString(5, persona.getSexo().toString());
            ps.setDate(6, persona.getFecha_nacimiento());
            ps.setBoolean(7, persona.getEstado());

            @Cleanup
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                idPersona = rs.getInt("ID_PERSONA");

                return Resultado
                        .builder()
                        .id(idPersona)
                        .mensaje(REGISTRO_DE_PERSONA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_REGISTRAR_PERSONA_AL_SISTEMA.formatted(idPersona),
                    ex
            );
        }

        return Resultado
                .builder()
                .id(-1)
                .mensaje(ERROR_AL_REGISTRAR_PERSONA_AL_SISTEMA.formatted(idPersona))
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    
    public static final String REGISTRO_DE_PERSONA_CORRECTAMENTE
            = "Registro de persona correctamente.";
    public static final String ERROR_AL_REGISTRAR_PERSONA_AL_SISTEMA
            = "Error al registrar persona al sistema. [CODIGO: %s]";

    //--------------------------------------------------------------------------
    /**
     * Metodo que modifica a una persona en el sistema.
     * 
     * @param persona persona que sera modificada en el sistema.
     * 
     * @return Devuelve un resultado indicando el resultado de la operacion. 
     */
    public static Resultado modificarEntidad(Persona persona) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_PERSONA (?, ?, ?, ?, ?, ?, ?, ?);
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, persona.getId_persona());
            ps.setString(2, persona.getPersona().toString());
            ps.setString(3, persona.getPnombre());
            ps.setString(4, persona.getSnombre());
            ps.setString(5, persona.getApellidos());
            ps.setString(6, persona.getSexo().toString());
            ps.setDate(7, persona.getFecha_nacimiento());
            ps.setBoolean(8, persona.getEstado());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(PERSONA_ACTUALIZADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_ACTUALIZAR_PERSONA_EN_EL_SISTEMA,
                    ex
            );

            return Resultado
                    .builder()
                    .mensaje(ERROR_ACTUALIZAR_PERSONA_EN_EL_SISTEMA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }

    }
    public static final String ERROR_ACTUALIZAR_PERSONA_EN_EL_SISTEMA
            = "Error actualizar persona en el sistema.";
    public static final String PERSONA_ACTUALIZADA_CORRECTAMENTE
            = "Persona actualizada correctamente.";

    //--------------------------------------------------------------------------
    
    /**
     * Retorna una lista la lista completa del sistema de las personas 
     * registrada.
     * 
     * @return devuelve una lista de persona en el sistema completa.
     * 
     * TODO 19/11/2024 esta lista debe de limitarse a 10 o 20 o 30.
     */
    public static List<Persona> getListEntidad() {
        final String sql = """
                            SELECT 
                                ID, 
                                PERSONA, 
                                PNOMBRE, 
                                SNOMBRE, 
                                APELLIDOS, 
                                SEXO, 
                                FECHA_NACIMIENTO, 
                                FECHA_INGRESO,
                                FECHA_HORA_ULTIMO_UPDATE, 
                                ESTADO, 
                                USER_NAME, 
                                ROL_USUARIO
                            FROM V_PERSONAS
                           """;
        List<Persona> personaList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                personaList.add(
                        Persona
                                .builder()
                                .id_persona(rs.getInt("ID"))
                                .persona(rs.getString("PERSONA").charAt(0))
                                .pnombre(rs.getString("PNOMBRE"))
                                .snombre(rs.getString("SNOMBRE"))
                                .apellidos(rs.getString("APELLIDOS"))
                                .sexo(rs.getString("SEXO").charAt(0))
                                .fecha_nacimiento(rs.getDate("FECHA_NACIMIENTO"))
                                .fecha_ingreso(rs.getDate("FECHA_INGRESO"))
                                .fecha_hora_ultima_update(rs.getDate("FECHA_HORA_ULTIMO_UPDATE"))
                                .estado(rs.getBoolean("ESTADO"))
                                .user_name(rs.getString("USER_NAME"))
                                .rol(rs.getString("ROL_USUARIO"))
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ERROR_AL_CONSULTAR_LA_VISTA_V_PERSONAS_DE,
                    ex
            );
        }
        return personaList;
    }
    public static final String ERROR_AL_CONSULTAR_LA_VISTA_V_PERSONAS_DE
            = "Error al consultar la vista V_PERSONAS del sistema.";

    //--------------------------------------------------------------------------
    
    /**
     * Obtiene las propiedades de una persona en el sistema por su identificador.
     * 
     * @param id identificador de la persona.
     * 
     * @return retorna un objeto de la clase Persona.
     */
    public static Persona getEntidad(Integer id) {
        final String sql = """
                           SELECT 
                                ID, 
                                PERSONA, 
                                PNOMBRE, 
                                SNOMBRE, 
                                APELLIDOS, 
                                SEXO, 
                                FECHA_NACIMIENTO, 
                                FECHA_INGRESO,
                                FECHA_HORA_ULTIMO_UPDATE, 
                                ESTADO, 
                                USER_NAME, 
                                ROL_USUARIO
                           FROM V_PERSONAS
                           WHERE ID = ?
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT,
                ResultSet.CONCUR_READ_ONLY
        )) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Persona
                            .builder()
                            .id_persona(rs.getInt("ID"))
                            .persona(rs.getString("PERSONA").charAt(0))
                            .pnombre(rs.getString("PNOMBRE"))
                            .snombre(rs.getString("SNOMBRE"))
                            .apellidos(rs.getString("APELLIDOS"))
                            .sexo(rs.getString("SEXO").charAt(0))
                            .fecha_nacimiento(rs.getDate("FECHA_NACIMIENTO"))
                            .fecha_ingreso(rs.getDate("FECHA_INGRESO"))
                            .fecha_hora_ultima_update(rs.getDate("FECHA_HORA_ULTIMO_UPDATE"))
                            .estado(rs.getBoolean("ESTADO"))
                            .user_name(rs.getString("USER_NAME"))
                            .rol(rs.getString("ROL_USUARIO"))
                            .build();
                }
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_LA_VISTA_V_PERSONAS_DE,
                    ex
            );
        }
        return Persona.builder().build();
    }

    //--------------------------------------------------------------------------
    /**
     * Metodo que elimina a una persona del sistema por su identificador.
     * 
     * @param id identificador de la persona.
     * 
     * @return Objeto resultado de la persona.
     */
    public static Resultado eliminarEntidad(int id) {
        final String sql = """
                           EXECUTE PROCEDURE SP_D_PERSONA(?)
                           """;

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            cs.setInt(1, id);

            cs.execute();

            return Resultado
                    .builder()
                    .mensaje(REGISTRO_DE_PERSONA_ELIMINADO_CORRECTAMEN)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_REGISTROS_CODIGO_S.formatted(id),
                    ex
            );
        }

        return Resultado
                .builder()
                .mensaje(ERROR_AL_ELIMINAR_REGISTROS_CODIGO_S.formatted(id))
                .icono(JOptionPane.INFORMATION_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }

    public static final String REGISTRO_DE_PERSONA_ELIMINADO_CORRECTAMEN
            = "Registro de persona eliminado correctamente.";

    public static final String ERROR_AL_ELIMINAR_REGISTROS_CODIGO_S
            = "Error al eliminar registros. \n[CODIGO: %d ]";

}
