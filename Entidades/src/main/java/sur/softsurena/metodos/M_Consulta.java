package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.Control_Consulta;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Consulta {

    /**
     * Metodo que permite agregar las consulta de los paciente al sistema.
     *
     * @param consulta
     * @return
     */
    public static synchronized Resultado insert(Consulta consulta) {
        final String sql
                = "SELECT O_ID FROM SP_I_CONSULTA(?, ?, ?, ?);";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, consulta.getPaciente().getPersona().getId_persona());
            ps.setInt(2, consulta.getControlConsulta().getId());
            ps.setInt(3, consulta.getLinea());
            ps.setDate(4, consulta.getFecha());

            ResultSet rs = ps.executeQuery();
            rs.next();

            return Resultado
                    .builder()
                    .id(rs.getInt("O_ID"))
                    .mensaje(CONSULTA_AGREGADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_CONSULTA,
                    ex
            );
            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL_INSERTAR_CONSULTA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_INSERTAR_CONSULTA
            = "Error al insertar consulta";
    public static final String CONSULTA_AGREGADA_CORRECTAMENTE
            = "Consulta agregada correctamente";

    /**
     * Consulta al sistema sobre las consultas registradas.
     *
     * @param consulta
     * @return
     */
    public synchronized static List<Consulta> select(Consulta consulta) {
        List<Consulta> consultaList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(consulta),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                consultaList.add(
                        Consulta
                                .builder()
                                .id(rs.getInt("ID"))
                                .paciente(
                                        Paciente
                                                .builder()
                                                .persona(
                                                        Persona
                                                                .builder()
                                                                .id_persona(
                                                                        rs.getInt("ID_PACIENTE")
                                                                )
                                                                .build()
                                                )
                                                .build()
                                )
                                .controlConsulta(
                                        Control_Consulta
                                                .builder()
                                                .id(rs.getInt("ID_CONTROL_CONSULTA"))
                                                .build()
                                )
                                .fecha(rs.getDate("FECHA"))
                                .linea(rs.getInt("LINEA"))
                                .estado(rs.getBoolean("ESTADO"))
                                .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return consultaList;
    }

    protected static String sqlSelect(Consulta consulta) {
        Boolean id = Objects.isNull(consulta.getId());
        Boolean id_controlConsulta = Objects.isNull(consulta.getControlConsulta());
        Boolean id_Paciente = Objects.isNull(consulta.getPaciente());
        
        Boolean where = !id || !id_controlConsulta || !id_Paciente;
        
        return  """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE, 
                    ESTADO
                FROM CONSULTAS
                %s%s%s%s
                """.formatted(
                        where ? "WHERE ":"",
                        id ? "":"ID = %d ".formatted(consulta.getId()),
                        id_controlConsulta ? "":"ID_CONTROL_CONSULTA = %d ".formatted(
                                consulta.getControlConsulta().getId()
                        ),
                        id_Paciente ? "":"ID_PACIENTE = %d ".formatted(consulta.getPaciente().getPersona().getId_persona())
                ).trim().strip();
    }
    /**
     *
     * @param idConsulta
     * @return
     */
    public static synchronized Resultado delete(Integer idConsulta) {
        final String sql = """
                           EXECUTE PROCEDURE SP_D_CONSULTA (?);
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idConsulta);

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(CONSULTA_ELIMINADA_CORRECTAMENTE_DEL_SIST)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String CONSULTA_ELIMINADA_CORRECTAMENTE_DEL_SIST
            = "Consulta eliminada correctamente del sistema.";
    public static final String ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA
            = "Error al eliminar la consulta del sistema.";

}
