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
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.EntradaProducto;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Entrada_Producto {

    /**
     * Metodo que retorna una cadena de texto con la consulta SQL que se
     * ejecutara para obtener las entradas de productos.
     *
     * @note Este metodo es utilizado por el metodo select para obtener las
     * entradas de productos.
     *
     * @param entradaProducto
     *
     * @return Una cadena de SQl con la consulta y los filtros necesario.
     */
    public static String sqlSelect(EntradaProducto entradaProducto) {
        Boolean id = Objects.isNull(entradaProducto.getId());
        Boolean idProveedor = Objects.isNull(entradaProducto.getIdProveedor());
        Boolean idAlmacen = Objects.isNull(entradaProducto.getIdAlmacen());

        Boolean where = id && idProveedor && idAlmacen;

        String sql = """
                     SELECT ID, ID_PROVEEDOR, ID_ALMACEN, COD_FACTURA, FECHA_ENTRADA
                     FROM V_M_ENTRADA_PRODUCTOS
                     %s%s%s%s
                     """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(entradaProducto.getId()),
                idProveedor ? "" : "ID_PROVEEDOR = %d ".formatted(entradaProducto.getIdProveedor()),
                idAlmacen ? "" : "ID_ALMACEN = %d ".formatted(entradaProducto.getIdAlmacen())
        );
        return sql.strip();
    }

    /**
     * Metodo que retorna una lista maestra de las entradas de productos en el
     * sistema.
     *
     * @param entradaProducto
     * @return
     */
    public synchronized static List<EntradaProducto> select(
            EntradaProducto entradaProducto
    ) {
        List<EntradaProducto> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(entradaProducto),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        EntradaProducto
                                .builder()
                                .id(rs.getInt("ID"))
                                .idProveedor(rs.getInt("ID_PROVEEDOR"))
                                .idAlmacen(rs.getInt("ID_PROVEEDOR"))
                                .cod_factura(rs.getString("COD_FACTURA"))
                                .fechaEntrada(rs.getDate("FECHA_ENTRADA"))
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
     * Agregar entrada de producto a la base de datos en la tabla de entrada de
     * productos.
     *
     * @param eProducto Contiene los atriibutos que .
     *
     * @return Devuelve ub objecto de la clase Resultado.
     */
    public static Resultado insert(EntradaProducto eProducto) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_M_ENTRADA_PRODUCTO(?,?,?,?);
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, eProducto.getIdProveedor());
            ps.setInt(2, eProducto.getIdAlmacen());
            ps.setString(3, eProducto.getCod_factura());
            ps.setString(4, eProducto.getEstado().toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje(PRODUCTO_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    EL_PRODUCTO_NO_FUE_AGREGADO,
                    ex
            );
        }

        return Resultado
                .builder()
                .id(-1)
                .mensaje(EL_PRODUCTO_NO_FUE_AGREGADO)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String PRODUCTO_AGREGADO_CORRECTAMENTE
            = "Producto agregado correctamente.";
    public static final String EL_PRODUCTO_NO_FUE_AGREGADO
            = "El header de entrada de producto NO FUE agregado.";

    /**
     * Agregar entrada de producto a la base de datos en la tabla de entrada de
     * productos.
     *
     * @param eProducto Contiene los atriibutos que .
     *
     * @return Devuelve ub objecto de la clase Resultado.
     */
    public static Resultado update(EntradaProducto eProducto) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_M_ENTRADA_PRODUCTO(?,?,?,?,?)
                           """;

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, eProducto.getId());
            ps.setInt(2, eProducto.getIdProveedor());
            ps.setInt(3, eProducto.getIdAlmacen());
            ps.setString(4, eProducto.getCod_factura());
            ps.setString(5, eProducto.getEstado().toString());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(ENTRADA_REGISTRADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ERROR_AL_REGISTRAR_LA_ENTRADA_EN_EL_SISTE,
                    ex
            );
        }

        return Resultado
                .builder()
                .mensaje(ERROR_AL_REGISTRAR_LA_ENTRADA_EN_EL_SISTE)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_REGISTRAR_LA_ENTRADA_EN_EL_SISTE
            = "Error al registrar la entrada en el sistema";
    public static final String ENTRADA_REGISTRADA_CORRECTAMENTE
            = "Entrada registrada correctamente.";

    /**
     * Elimina el registro identificado por su id.
     *
     * @param eProducto Contiene los atriibutos que .
     *
     * @return Devuelve ub objecto de la clase Resultado.
     */
    public static Resultado delete(EntradaProducto eProducto) {
        final String sql = """
                           EXECUTE PROCEDURE SP_D_M_ENTRADA_PRODUCTO(?)
                           """;

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, eProducto.getId());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(ENTRADA_ELIMINADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INTENTAR_ELIMINAR_EL_REGISTRO,
                    ex
            );
        }

        return Resultado
                .builder()
                .mensaje(ERROR_AL_INTENTAR_ELIMINAR_EL_REGISTRO)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_INTENTAR_ELIMINAR_EL_REGISTRO 
            = "Error al intentar eliminar el registro.";
    public static final String ENTRADA_ELIMINADA_CORRECTAMENTE 
            = "Entrada eliminada correctamente.";

}
