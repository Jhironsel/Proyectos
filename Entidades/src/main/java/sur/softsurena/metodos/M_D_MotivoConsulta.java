package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.D_Motivo_Consulta;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_D_MotivoConsulta {

    /**
     * Metodo que elimina un detalle de la consulta de los paciente, por x o y
     * razones.
     *
     * @param dmc
     *
     * @return
     */
    public static Resultado borrarDetalleMotivoConsulta(D_Motivo_Consulta dmc) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_D_MOTIVO_CONSULTA (?, ?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, dmc.getId_consulta());
            ps.setInt(2, dmc.getId_motivo_consulta());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(MOTIVO_ELIMINADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_DETALLE_DE_MOTIVO_DE_LA,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_DETALLE_DE_MOTIVO_DE_LA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }

    public static final String ERROR_AL_ELIMINAR_DETALLE_DE_MOTIVO_DE_LA
            = "Error al eliminar detalle de motivo de la consulta.";

    public static final String MOTIVO_ELIMINADO_CORRECTAMENTE
            = "Motivo eliminado correctamente.";

    /**
     * Permite relacionar las consultas con los motivo que provocaron la
     * consulta.
     *
     * @param dmc
     *
     * @return
     */
    public synchronized static Resultado agregarDetallleConsulta(D_Motivo_Consulta dmc) {
        final String sql
                = "EXECUTE PROCEDURE SP_I_D_MOTIVO_CONSULTA (?,?);";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT)) {
            ps.setInt(1, dmc.getId_consulta());
            ps.setInt(2, dmc.getId_motivo_consulta());

            ps.executeUpdate();
            return Resultado
                    .builder()
                    .mensaje(DETALLES_AGREGADOS_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR__DETALLE__CONSULTA,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_INSERTAR__DETALLE__CONSULTA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_INSERTAR__DETALLE__CONSULTA
            = "Error al insertar Detalle Consulta...";
    public static final String DETALLES_AGREGADOS_CORRECTAMENTE
            = "Detalles agregados correctamente";

    /**
     * Una lista de los motivos que generaron la consulta del paciente. 
     *
     * @param idConsulta identificador de la consulta que desea obtener los 
     * motivo de la consulta.
     * 
     * @return returna una lista de motivos de la consulta del paciente por su
     * numero de consulta. 
     * 
     */
    public synchronized static List<D_Motivo_Consulta> getDetalleMotivo(
            int idConsulta
    ) {
        final String sql
                = """                  
                  SELECT ID, ID_MOTIVO_CONSULTA
                  FROM V_D_MOTIVO_CONSULTA 
                  WHERE ID_CONSULTA = ?
                  """;
        
        List<D_Motivo_Consulta> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idConsulta);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(
                        D_Motivo_Consulta
                                .builder()
                                .id(rs.getInt("ID"))
                                .id_motivo_consulta(rs.getInt("ID_MOTIVO_CONSULTA"))
                                .build()
                );
            }
            
            
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ERROR_AL_CONSULTAR_LA_VISTA_V_DETALLEMOTI,
                    ex
            );
        }
        
        return lista;
    }
    public static final String ERROR_AL_CONSULTAR_LA_VISTA_V_DETALLEMOTI 
            = "Error al consultar la vista V_DETALLEMOTIVOCONSULTA del sistema.";
}
