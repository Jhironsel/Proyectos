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
import sur.softsurena.entidades.Precio;
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
     * TEST Realizar o verificar test.
     *
     * @param factura
     * @return Ahora devuelve un resultado que indica el estado de la 
     * operaciones de registros.
     */
    public static synchronized Resultado agregarDetalleFactura(
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
                ps.setInt(2, d_factura.getM_factura().getId());
                ps.setInt(3, d_factura.getProducto().getId());
                ps.setInt(4, d_factura.getPrecio().getId());
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
    public synchronized static List<D_Factura> getBuscarTemporal(Integer idFactura) {
        
        final String sql = """
                           SELECT ID, LINEA, ID_PRODUCTO, ID_PRECIO, 
                                    DESCRIPCION, CANTIDAD
                           FROM GET_D_FACTURAS
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
                                .producto(
                                        Producto
                                                .builder()
                                                .id(rs.getInt("ID_PRODUCTO"))
                                                .descripcion(rs.getString("DESCRIPCION"))
                                                .build()
                                )
                                .precio(
                                        Precio
                                                .builder()
                                                .id(rs.getInt("ID_PRECIO"))
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
