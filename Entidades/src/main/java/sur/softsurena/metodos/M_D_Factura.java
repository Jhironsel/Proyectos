package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.D_Factura;
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
                ps.setInt(3, factura.getIdProducto());
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
     * TODO este metodo le falta obtener el precio del producto.
     *
     * Metodo utilizado para obtener las lista en temporal.
     * @param idFactura
     * @return
     */
    public synchronized static List<D_Factura> getBuscarTemporal(Integer idFactura) {
        
        final String sql = """
                SELECT  ID_LINEA, ID_PRODUCTO, DESCRIPCION, CANTIDAD 
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
                                .idProducto(rs.getInt("ID_PRODUCTO"))
                                .descripcion(rs.getString("DESCRIPCION"))
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

    /**
     * TODO CREAR VISTA. Devolver Lista
     *
     * @param idFactura
     * @return
     */
    public synchronized static ResultSet getFacturasDetalladas(int idFactura) {
        final String sql =
                """
                    SELECT factura.idFactura, factura.idCliente, nombres||' '||apellidos AS nombreFull, 
                          fecha, idLinea, (SELECT p.Descripcion 
                                              FROM TABLA_PRODUCTOS p 
                                              WHERE p.idProducto = DETALLEFACTURA.IDPRODUCTO ) as Descripcion, 
                          idProducto, precio, cantidad, precio * cantidad AS Valor 
                    FROM TABLA_FACTURAS 
                    INNER JOIN TABLA_CLIENTES ON factura.idCliente = cliente.idCliente 
                    INNER JOIN TABLA_DETALLEFACTURA ON factura.idFactura = detalleFactura.idFactura 
                    WHERE factura.idFactura = ?
                """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idFactura);
            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * TODO CREAR VISTA. devolver una lista.
     *
     * @param idCliente
     * @return
     */
    public synchronized static ResultSet getFacturasDetalladaPorCliente(String idCliente) {
        final String sql
                = "SELECT f.idFactura, f.estado , f.fecha, f.USUARIO, "
                + "COALESCE(SUM(d.precio * d.cantidad), 0.00) AS Valor "
                + "FROM TABLA_FACTURAS f "
                + "LEFT JOIN TABLA_CLIENTES c ON f.idCliente = c.idCliente "
                + "LEFT JOIN TABLA_DETALLEFACTURA d ON f.idFactura = d.idFactura "
                + "WHERE f.idCliente = ? "
                + "GROUP BY f.idFactura, f.estado , f.fecha, f.USUARIO "
                + "order by 1";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, idCliente);
            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * TODO CREAR VISTA. Devolver Lista.
     *
     * @param idCliente
     * @param idFactura
     * @return
     */
    public synchronized static ResultSet getFacturasDetalladaPorCliente(
            String idCliente, int idFactura) {
        final String sql
                = """
                  SELECT f.idFactura, f.estado , f.fecha, f.USUARIO, COALESCE(SUM(d.precio * d.cantidad), 0.00) AS Valor 
                  FROM TABLA_FACTURAS f 
                  LEFT JOIN TABLA_CLIENTES c ON f.idCliente = c.idCliente 
                  LEFT JOIN TABLA_DETALLEFACTURA d ON f.idFactura = d.idFactura 
                  WHERE f.idCliente = ? and f.idFactura = ? 
                  GROUP BY f.idFactura, f.estado , f.fecha, f.USUARIO 
                  ORDER BY 1
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, idCliente);
            ps.setInt(2, idFactura);
            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
    }
}
