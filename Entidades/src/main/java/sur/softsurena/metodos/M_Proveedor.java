package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Proveedor;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Proveedor {

    /**
     * Consulta a la base de datos sobre los proveedores del sistema.
     *
     * @param proveedor
     * @return
     */
    public synchronized static List<Proveedor> select(Proveedor proveedor) {

        List<Proveedor> lista = new ArrayList<>();
        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(proveedor),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(
                        Proveedor
                                .builder()
                                .id(rs.getInt("ID"))
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

    public static String sqlSelect(Proveedor proveedor) {
        Boolean id = Objects.isNull(proveedor.getId());
        Boolean codigo = Objects.isNull(proveedor.getCodigoProveedor());

        Boolean where = id && codigo;
        
        Boolean pagina = Objects.isNull(proveedor.getPagina());

        String sql = """
                     SELECT ID
                     FROM V_PERSONAS_PROVEEDORES
                     %s%s
                     """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(proveedor.getId()),
                codigo ? "" : "CODIGO STARTING WITH '%s'".formatted(proveedor.getCodigoProveedor())
        );
        return sql.concat("%s").formatted(
                        pagina ? "" : "\nROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                        .formatted(
                                                proveedor.getPagina().getNPaginaNro(),
                                                proveedor.getPagina().getNCantidadFilas(),
                                                proveedor.getPagina().getNPaginaNro(),
                                                proveedor.getPagina().getNCantidadFilas()
                                        )
                );
    }

    public synchronized static List<Proveedor> selectATR(Proveedor proveedor) {

        List<Proveedor> lista = new ArrayList<>();
        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlProveedor(proveedor),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(
                        Proveedor
                                .builder()
                                .id(rs.getInt("ID"))
                                .codigoProveedor(rs.getString("CODIGO"))
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

    public static String sqlProveedor(Proveedor proveedor) {
        boolean id = Objects.isNull(proveedor.getId());
        boolean codigo = Objects.isNull(proveedor.getCodigoProveedor());
        boolean where = id && codigo;

        Boolean pagina = Objects.isNull(proveedor.getPagina());

        final String sql = """
                           SELECT ID, CODIGO
                           FROM V_PERSONAS_PROVEEDORES_ATR
                           %s%s%s
                           """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(proveedor.getId()),
                codigo ? "" : "CODIGO STARTING WITH '%s' ".formatted(proveedor.getCodigoProveedor())
        );
        return sql.strip().concat("%s").formatted(
                pagina ? "" : "\nROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                .formatted(
                                        proveedor.getPagina().getNPaginaNro(),
                                        proveedor.getPagina().getNCantidadFilas(),
                                        proveedor.getPagina().getNPaginaNro(),
                                        proveedor.getPagina().getNCantidadFilas()
                                )
        ).strip();
    }
//------------------------------------------------------------------------------

    /**
     * Inserta un registro completo de un proveedor en el sistema.
     *
     * @param proveedor
     *
     * @return
     */
    public synchronized static Resultado insert(Proveedor proveedor) {

        final String sql
                = """
                  EXECUTE PROCEDURE SP_I_PERSONA_PROVEEDOR(?)
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, proveedor.getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(PROVEEDOR_AGREGADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE,
                    ERROR_AL_INSERTAR__PROVEEDOR,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_INSERTAR__PROVEEDOR)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    private static final String ERROR_AL_INSERTAR__PROVEEDOR
            = "⛔ Error al insertar Proveedor...";
    private static final String PROVEEDOR_AGREGADO_CORRECTAMENTE
            = "🆗 Proveedor agregado correctamente.";

//------------------------------------------------------------------------------
    /**
     * Metodo que permite la actualizacion de los proveedores del sistema de
     * factura.
     *
     * @param proveedor
     *
     * @return
     */
    public synchronized static Resultado update(Proveedor proveedor) {

        final String sql = """
                           EXECUTE PROCEDURE SP_U_PERSONA_PROVEEDOR(?,?)
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, proveedor.getId());
            ps.setString(2, proveedor.getCodigoProveedor());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(CONSULTA_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_MODIFICAR_CONSULTA,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_MODIFICAR_CONSULTA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_MODIFICAR_CONSULTA
            = "⛔ Error al modificar proveedor...";
    public static final String CONSULTA_MODIFICADO_CORRECTAMENTE
            = "🆗 Proveedor modificado correctamente";

//------------------------------------------------------------------------------
    /**
     * Metodo que permite la actualizacion de los proveedores del sistema de
     * factura.
     *
     * @param proveedor
     *
     * @return
     */
    public synchronized static Resultado delete(Proveedor proveedor) {

        final String sql = """
                           EXECUTE PROCEDURE SP_D_PERSONA_PROOVEDOR(?)
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, proveedor.getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(CONSULTA_ELIMINADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_ELIMINAR_CONSULTA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_ELIMINAR_CONSULTA
            = "⛔ Error al eliminar proveedor...";
    public static final String CONSULTA_ELIMINADO_CORRECTAMENTE
            = "🆗 Proveedor eliminado correctamente";
}
