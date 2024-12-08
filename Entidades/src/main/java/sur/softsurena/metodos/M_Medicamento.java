package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Medicamento;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Medicamento {

    /**
     * TODO 06/12/2024 este metodo esta pensando en modificar los medicamentos 
     * registrados en el sistema. 
     *
     * @param medicamento 
     * 
     * @return
     */
    public synchronized static Resultado modificarMedicamento(
            @NonNull Medicamento medicamento
    ) {
        final String sql = "";

        try (PreparedStatement ps = getCnn().prepareStatement(
                    sql,
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.CLOSE_CURSORS_AT_COMMIT
            )){
            
            ps.setInt(1, medicamento.getId_proveedor());
            ps.setString(2, medicamento.getDescripcion());
            ps.setString(3, Utilidades.imagenEncode64(medicamento.getPathImagen()));
            ps.setBoolean(4, medicamento.isEstado());
            ps.setInt(5, medicamento.getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(MEDICAMENTO_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR__MEDICAMENTO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
    }
    public static final String ERROR_AL_MODIFICAR__MEDICAMENTO = "Error al modificar Medicamento...";
    public static final String MEDICAMENTO_MODIFICADO_CORRECTAMENTE = "Medicamento modificado correctamente";
//------------------------------------------------------------------------------

    /**
     * Metodo que devuelve una lista de medicamento registrado en el sistema.
     * 
     * @return 
     */
    public synchronized static List<Medicamento> getMedicamentoActivo() {
        final String sql = "SELECT ID, DESCRIPCION "
                + "FROM V_PRODUCTOS "
                + "WHERE estado "
                + "ORDER BY 2";

        List<Medicamento> medicamentoList = null;

        try (PreparedStatement ps = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    medicamentoList.add(Medicamento.builder().
                            id(rs.getInt("ID")).
                            descripcion(rs.getString("DESCRIPCION")).
                            build());

                }
            }
            return medicamentoList;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

//------------------------------------------------------------------------------
    /**
     * 
     * @param idMedicamento
     * @return
     */
    public synchronized static ResultSet getMedicamentoFoto(String idMedicamento) {

        final String sql 
                = "SELECT FOTO "
                + "FROM V_MEDICAMENTOS "
                + "WHERE idMedicamento = ?";
        try (PreparedStatement ps = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            ps.setString(1, idMedicamento);
            return ps.executeQuery();

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

//------------------------------------------------------------------------------
    /**
     *
     * @param estado
     * @return
     */
    public synchronized static ResultSet getMedicamento(boolean estado) {
        final String sql = "SELECT CODIGO_PROVEEDOR, IDMEDICAMENTO, "
                + "          NOMBREMEDICAMENTO, ESTADO "
                + "   FROM GET_MEDICAMENTO"
                + "   WHERE ESTADO IS ? ORDER BY 1, 3";
        try (PreparedStatement ps = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {

            ps.setBoolean(1, estado);

            return ps.executeQuery();

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }
}
