package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Paciente {

    //--------------------------------------------------------------------------
    /**
     * Consulta que permite obtener los atributos de los paciente en el sitema.
     *
     * @param paciente
     * @return
     */
    public static List<Paciente> select(
            @NonNull Paciente paciente
    ) {
        List<Paciente> pacienteList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(paciente),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pacienteList.add(
                        Paciente
                                .builder()
                                .idPersona(rs.getInt("ID"))
                                .persona(rs.getString("PERSONA").charAt(0))
                                .pnombre(rs.getString("PNOMBRE"))
                                .snombre(rs.getString("SNOMBRE"))
                                .apellidos(rs.getString("APELLIDOS"))
                                .sexo(rs.getString("SEXO").charAt(0))
                                .fecha_nacimiento(rs.getDate("FECHA_NACIMIENTO"))
                                .fecha_ingreso(rs.getDate("FECHA_INGRESO"))
                                .fecha_hora_ultima_update(
                                        rs.getTimestamp("FECHA_HORA_ULTIMO_UPDATE")
                                )
                                .estado(rs.getBoolean("ESTADO"))
                                .generales(
                                        Generales
                                                .builder()
                                                .idTipoSangre(rs.getInt("ID_TIPO_SANGRE"))
                                                .cedula(rs.getString("CEDULA"))
                                                .estado_civil(rs.getString("ESTADO_CIVIL").charAt(0))
                                                .build()
                                )
                                .cesarea(rs.getBoolean("CESAREA"))
                                .tiempoGestacion(rs.getInt("TIEMPO_GESTACION"))
                                .fumador(rs.getBoolean("FUMADOR"))
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_LA_VISTA_GET_PACIENTES,
                    ex
            );
        }
        return pacienteList;
    }
    public static final String ERROR_AL_CONSULTAR_LA_VISTA_GET_PACIENTES
            = "Error al consultar la vista V_PERSONAS_PACIENTES_GEN del sistema.";

    protected static String sqlSelect(Paciente paciente) {
        boolean id = Objects.isNull(paciente.getIdPersona());
        boolean where = id;
        boolean pagina = Objects.isNull(paciente.getPagina());

        return """
               SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                    FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                    ESTADO, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL, CESAREA, 
                    TIEMPO_GESTACION, FUMADOR
               FROM V_PERSONAS_PACIENTES_GEN
               %s%s
               """.strip().formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(paciente.getIdPersona())
        ).strip().concat("%s").formatted(
                pagina ? "" : "\nROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                .formatted(
                                        paciente.getPagina().getNPaginaNro(),
                                        paciente.getPagina().getNCantidadFilas(),
                                        paciente.getPagina().getNPaginaNro(),
                                        paciente.getPagina().getNCantidadFilas()
                                )
        );
    }

    //--------------------------------------------------------------------------
    /**
     * Metodo que permite agregar un paciente al sisteme.
     *
     * @param paciente objecto de la clase Paciente, con los campos requerido
     * para agregar un paciente.
     *
     * @return Retorna un objecto de la clase Resultados el cual indica si la
     * operacion fue exito o no.
     */
    public static Resultado insert(Paciente paciente) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_I_PERSONA_PACIENTE (?);
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, paciente.getIdPersona());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(PACIENTE_AGREGADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_PACIENTE,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_INSERTAR_PACIENTE)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_INSERTAR_PACIENTE
            = "Error al insertar paciente.";
    public static final String PACIENTE_AGREGADO_CORRECTAMENTE
            = "Paciente agregado correctamente.";

//------------------------------------------------------------------------------
    /**
     * Metodo que te permite modificar los paciente del sistema.
     *
     * @param paciente
     * @return
     */
    public static Resultado update(Paciente paciente) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_U_PERSONA_PACIENTE (?,?,?,?);
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, paciente.getIdPersona());
            ps.setBoolean(2, paciente.getCesarea());
            ps.setInt(3, paciente.getTiempoGestacion());
            ps.setBoolean(4, paciente.getFumador());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(PACIENTE_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_MODIFICAR_PACIENTE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_PACIENTE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String PACIENTE_MODIFICADO_CORRECTAMENTE
            = "Paciente modificado correctamente";
    public static final String ERROR_AL_MODIFICAR_PACIENTE
            = "Error al modificar cliente...";

//------------------------------------------------------------------------------
    /**
     * Metodos que permiten borrar registros de la base de datos.
     *
     * @param paciente
     * @return
     */
    public static Resultado delete(Paciente paciente) {
        final String sql = """
                           EXECUTE PROCEDURE SP_D_PERSONA_PACIENTE(?)
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, paciente.getIdPersona());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(PACIENTE_BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_PACIENTE.formatted(
                            paciente.getIdPersona()
                    ),
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_BORRAR_PACIENTE.formatted(
                        paciente.getIdPersona())
                )
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_BORRAR_PACIENTE
            = "Error al borrar paciente. \n[Codigo = %s]";
    public static final String PACIENTE_BORRADO_CORRECTAMENTE
            = "Paciente borrado correctamente.";
}
