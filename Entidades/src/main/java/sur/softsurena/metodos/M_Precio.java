package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Precio;
import sur.softsurena.entidades.Producto;
import sur.softsurena.entidades.TipoImpuesto;
import sur.softsurena.entidades.TipoPrecio;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 *
 * @author jhironsel
 */
public class M_Precio {

    /**
     * Metodo encargado de recuperar una lista de entidades de precio de un
     * producto determinado.
     *
     * @param precio
     * @return
     */
    public static List<Precio> select(Precio precio) {
        final String sql = """
                           SELECT ID, ID_PRODUCTO, ID_TIPO_PRECIO, 
                                ID_TIPO_IMPUESTO, PRECIO, MONEDA, FECHA_INICIO, 
                                FECHA_FIN, DESCUENTO, COSTO_ENVIO
                           FROM V_PRECIOS
                           %s
                           """.formatted(Objects.isNull(precio)
                ? ""
                : "WHERE ID_PRODUCTO = %d;".formatted(precio.getProducto().getId())
        );

        List<Precio> lista = new ArrayList<>();

        try (PreparedStatement ps = Conexion.getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPrecio = rs.getInt("ID_TIPO_PRECIO");
                lista.add(
                        Precio
                                .builder()
                                .id(rs.getInt("ID"))
                                .producto(
                                        Producto
                                                .builder()
                                                .id(rs.getInt("ID_PRODUCTO"))
                                                .build()
                                )
                                .tipoPrecio(
                                        M_TipoPrecio.getTipoPrecios().stream().filter(
                                                precioID -> precioID.getId() == idPrecio
                                        ).findFirst().get()
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
    public static Resultado insert(Precio precio) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_PRECIOS (?,?,?,?,?,?,?,?,?)
                           """;

        try (CallableStatement ps = Conexion.getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(2, precio.getProducto().getId());
            ps.setInt(3, precio.getTipoPrecio().getId());
            ps.setInt(4, precio.getTipoImpusto().getId());
            ps.setBigDecimal(5, precio.getPrecio());
            ps.setString(6, precio.getMoneda());
            ps.setDate(7, precio.getFechaInicio());
            ps.setDate(8, precio.getFechaFin());
            ps.setBigDecimal(9, precio.getDescuento());
            ps.setBigDecimal(10, precio.getCostoEnvio());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje(PRECIO_ESTABLECIDO_CON_EXITO)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }
        } catch (SQLException ex) {
            Utilidades.LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
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
     * Actualiza el registro de un precio registrado en el sistema.
     *
     * @param precio
     * @return
     */
    public static Resultado update(Precio precio) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_PRECIO (?,?,?,?,?,?,?,?,?,?)
                           """;

        try (CallableStatement ps = Conexion.getCnn().prepareCall(
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

    /**
     * Metodo que elimina el registro de un precio.
     *
     * @param precio
     *
     * @return
     */
    public static Resultado delete(@NonNull Precio precio) {
        final String sql = "EXECUTE PROCEDURE SP_D_PRECIO (?)";

        try (CallableStatement ps = Conexion.getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, precio.getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje("Precio eliminado correctamente.!!!")
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
                .mensaje("Error precio no puede ser eliminado del sistema.!!!")
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
}
