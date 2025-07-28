package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.D_Factura;
import sur.softsurena.entidades.Factura;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */

public class M_D_Factura {

    /**
     * Metodo utilizado para agregar los datos de los detalle de la factura del
     * sistema.
     * 
     * TEST Realizar o verificar test.
     *
     * @param factura
     * @return Ahora devuelve un resultado que indica el estado de la 
     * operaciones de registros.
     */
    public static synchronized Resultado insert(
            Factura factura
    ){
        final String sql
                = """
                  EXECUTE PROCEDURE SP_I_D_FACTURAS(?,?,?,?,?)
                  """;

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            for (D_Factura d_factura : factura.getD_factura()) {
                ps.setInt(1, d_factura.getLinea());
                ps.setInt(2, d_factura.getIdFactura());
                ps.setInt(3, d_factura.getIdProducto());
                ps.setInt(4, d_factura.getIdPrecio());
                ps.setBigDecimal(5, d_factura.getCantidad());
                ps.addBatch();
            }
            ps.executeBatch();
            return Resultado
                    .builder()
                    .mensaje(DETALLE_DE_LA_FACTURA_AGREGADO_CORRECTAME)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_AGREGAR_DETALLE_DE_LA_FACTURA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_AGREGAR_DETALLE_DE_LA_FACTURA 
            = "Error al agregar detalle de la factura.";
    public static final String DETALLE_DE_LA_FACTURA_AGREGADO_CORRECTAME 
            = "Detalle de la factura agregado correctamente.";
//------------------------------------------------------------------------------
    
    /**
     * Metodo que permite obtener la factura registradas en temporal del 
     * sistema.
     * 
     * Metodo utilizado para obtener las lista en temporal.
     * @param idFactura
     * @return
     */
    public synchronized static List<D_Factura> select(Integer idFactura) {
        
        final String sql = """
                           SELECT ID, LINEA, ID_PRODUCTO, ID_PRECIO, CANTIDAD
                           FROM V_D_FACTURAS
                           WHERE ID_FACTURA = ?
                           ORDER BY LINEA;
                           """;

        List<D_Factura> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idFactura);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        D_Factura
                                .builder()
                                .id(rs.getInt("ID"))
                                .linea(rs.getInt("LINEA"))
                                .idProducto(rs.getInt("ID_PRODUCTO"))
                                .idPrecio(rs.getInt("ID_PRECIO"))
                                .cantidad(rs.getBigDecimal("CANTIDAD"))
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

        return lista;
    }
    
    //--------------------------------------------------------------------------
    /**
     * Metodo que elimina fisicamente un registro del detalle de una factura.
     *
     * @param id
     * @return
     */
    public synchronized static Resultado delete(Integer id) {
        final String sql = "EXECUTE PROCEDURE SP_D_D_FACTURA(?)";

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            cs.setInt(1, id);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(REGISTRO_DE_DETALLE_DE_LA_FACTURA_ELIMINA)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_EL_DETALLE_DE_LA_FACTUR)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String REGISTRO_DE_DETALLE_DE_LA_FACTURA_ELIMINA 
            = "Registro de detalle de la factura eliminado.";
    public static final String ERROR_AL_ELIMINAR_EL_DETALLE_DE_LA_FACTUR 
            = "Error al eliminar el detalle de la factura.";
    
    /**
     * Metodo que elimina fisicamente un registro del detalle de una factura.
     *
     * @param idFactura
     * @return
     */
    public synchronized static Resultado deleteByIdFactura(Integer idFactura) {
        final String sql = "EXECUTE PROCEDURE SP_D_D_FACTURA_ID_FACTURA(?);";

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            cs.setInt(1, idFactura);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(REGISTROS_DEL_DETALLE_DE_LA_FACTURA_ELIMI)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_LOS_REGISTROS_DEL_DETAL)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_ELIMINAR_LOS_REGISTROS_DEL_DETAL
            = "Error al eliminar los registros del detalle de la factura.";
    public static final String REGISTROS_DEL_DETALLE_DE_LA_FACTURA_ELIMI 
            = "Registros del detalle de la factura eliminado.!!!";
}
