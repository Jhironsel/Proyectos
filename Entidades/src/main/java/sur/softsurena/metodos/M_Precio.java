package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Precio;
import sur.softsurena.entidades.Producto;
import sur.softsurena.entidades.TipoImpuesto;
import sur.softsurena.entidades.TipoPrecio;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 *
 * @author jhironsel
 */
public class M_Precio {

    /**
     *
     * @param filtro
     * @return
     */
    public static Precio getEntity(FiltroBusqueda filtro) {
        final String sql = """
                           SELECT ID, ID_PRODUCTO, ID_TIPO_PRECIO, 
                                ID_TIPO_IMPUESTO, PRECIO, MONEDA, FECHA_INICIO, 
                                FECHA_FIN, DESCUENTO, COSTO_ENVIO
                           FROM V_PRECIOS
                           WHERE ID = ?
                           """;

        try (PreparedStatement ps = Conexion.getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, filtro.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Precio
                        .builder()
                        .id(rs.getInt("ID"))
                        .Producto(
                                Producto
                                        .builder()
                                        .id(rs.getInt("ID_PRODUCTO"))
                                        .build()
                        )
                        .tipoPrecio(
                                TipoPrecio
                                        .builder()
                                        .id(rs.getInt("ID_TIPO_PRECIO"))
                                        .build()
                        )
                        .tipoImpusto(
                                TipoImpuesto
                                        .builder()
                                        .id(rs.getInt("ID_TIPO_IMPUESTO"))
                                        .build()
                        )
                        .precio(rs.getBigDecimal("PRECIO"))
                        .moneda(rs.getString("MONEDA"))
                        .fechaInicio(rs.getDate("FECHA_INICIO"))
                        .fechaFin(rs.getDate("FECHA_FIN"))
                        .descuento(rs.getBigDecimal("DESCUENTO"))
                        .costoEnvio(rs.getBigDecimal("COSTO_ENVIO"))
                        .build();
            }

        } catch (SQLException ex) {
            Utilidades.LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return null;
    }

    /**
     * Metodo encargado de recuperar una lista de entidades de precio de un 
     * producto determinado.
     * @param filtro
     * @return
     */
    public static List<Precio> getEntities(FiltroBusqueda filtro) {
        final String sql = """
                           SELECT ID, ID_PRODUCTO, ID_TIPO_PRECIO, 
                                ID_TIPO_IMPUESTO, PRECIO, MONEDA, FECHA_INICIO, 
                                FECHA_FIN, DESCUENTO, COSTO_ENVIO
                           FROM V_PRECIOS
                           WHERE ID_PRODUCTO = ? ;
                           """;

        List<Precio> lista = new ArrayList<>();

        try (PreparedStatement ps = Conexion.getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, filtro.getId());
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        Precio
                                .builder()
                                .id(rs.getInt("ID"))
                                .Producto(
                                        Producto
                                                .builder()
                                                .id(rs.getInt("ID_PRODUCTO"))
                                                .build()
                                )
                                .tipoPrecio(
                                        TipoPrecio
                                                .builder()
                                                .id(rs.getInt("ID_TIPO_PRECIO"))
                                                .build()
                                )
                                .tipoImpusto(
                                        TipoImpuesto
                                                .builder()
                                                .id(rs.getInt("ID_TIPO_IMPUESTO"))
                                                .build()
                                )
                                .precio(rs.getBigDecimal("PRECIO"))
                                .moneda(rs.getString("MONEDA"))
                                .fechaInicio(rs.getDate("FECHA_INICIO"))
                                .fechaFin(rs.getDate("FECHA_FIN"))
                                .descuento(rs.getBigDecimal("DESCUENTO"))
                                .costoEnvio(rs.getBigDecimal("COSTO_ENVIO"))
                                .build()
                );
            }

        } catch (SQLException ex) {
            Utilidades.LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }

        return lista;
    }

    /**
     *
     * @param precio
     * @return
     */
    public static Resultado setEntity(Precio precio) {
        final String sql = """
                           EXECUTE PROCEDURE SP_I_PRECIOS (?,?,?,?,?,?,?,?,?,?);
                           """;

        try (PreparedStatement ps = Conexion.getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, precio.getId());
            ps.setInt(2, precio.getProducto().getId());
            ps.setInt(3, precio.getTipoPrecio().getId());
            ps.setInt(4, precio.getTipoImpusto().getId());
            ps.setBigDecimal(5, precio.getPrecio());
            ps.setString(6, precio.getMoneda());
            ps.setDate(7, precio.getFechaInicio());
            ps.setDate(8, precio.getFechaFin());
            ps.setBigDecimal(9, precio.getDescuento());
            ps.setBigDecimal(10, precio.getCostoEnvio());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(PRECIO_ESTABLECIDO_CON_EXITO)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            Utilidades.LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_ESTABLECER_PRECIO_EN_EL_SISTEMA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_ESTABLECER_PRECIO_EN_EL_SISTEMA
            = "Error establecer precio en el sistema.";
    public static final String PRECIO_ESTABLECIDO_CON_EXITO
            = "Precio establecido con exito.";

    /**
     * TODO Falta crear el metodo que actualiza los precios.
     *
     * @param object
     * @return
     */
    public static Resultado putEntity(Precio object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * TODO Falta crear el metodo que elimina un precio.
     *
     * @param id
     * @return
     */
    public static Resultado delEntity(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
