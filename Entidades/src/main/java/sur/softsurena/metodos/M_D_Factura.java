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
import sur.softsurena.entidades.Producto;
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
     * @param idFactura
     * @param detalleFactura
     * @return Ahora devuelve un resultado que indica el estado de la 
     * operaciones de registros.
     */
    public static synchronized Resultado agregarDetalleFactura(
            Integer idFactura,
            List<D_Factura> detalleFactura
    ){
        final String sql
                = """
                  EXECUTE PROCEDURE SP_I_D_FACTURAS (?, ?, ?, ?, ?);
                  """;

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            for (D_Factura factura : detalleFactura) {
                ps.setInt(1, idFactura);
                ps.setInt(2, factura.getIdLinea());
                ps.setInt(3, factura.getProducto().getId());
                ps.setBigDecimal(4, factura.getPrecio());
                ps.setBigDecimal(5, factura.getCantidad());

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

    /**
     * Metodo que permite obtener la factura registradas en temporal del 
     * sistema.
     * 
     * Metodo utilizado para obtener las lista en temporal.
     * @param idFactura
     * @return
     */
    public synchronized static List<D_Factura> getBuscarTemporal(Integer idFactura) {
        
        final String sql = """
                SELECT  ID_LINEA, ID_PRODUCTO, ID_PRECIO, DESCRIPCION, CANTIDAD 
                FROM GET_D_FACTURAS 
                WHERE ID_FACTURA = ? 
                ORDER BY 1;
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
                                .idLinea(rs.getInt("ID_LINEA"))
                                .producto(
                                        Producto
                                                .builder()
                                                .id(rs.getInt("ID_PRODUCTO"))
                                                .descripcion(rs.getString("DESCRIPCION"))
                                                .build()
                                )
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
}
