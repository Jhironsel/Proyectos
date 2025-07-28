package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.Cleanup;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Empleado;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Empleado {

    /**
     * Metodo que permite obtener los cliente del sistema.
     *
     * @param empleado contiene los elemento de la consulta.
     *
     * @return
     */
    public static List<Empleado> select(
            @NonNull Empleado empleado
    ) {
        List<Empleado> lista = new ArrayList<>();

        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            @Cleanup
            ResultSet rs = ps.executeQuery(sqlSelect(empleado));

            while (rs.next()) {
                lista.add(
                        Empleado
                                .builder()
                                .id(rs.getInt("ID"))
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTA_LISTA_EMPLEADO,
                    ex
            );
        }
        return lista;
    }
    public static final String ERROR_AL_CONSULTA_LISTA_EMPLEADO
            = "Error al consulta la vista V_PERSONAS_CLIENTES";

    public static String sqlSelect(Empleado empleado) {
        Boolean id = Objects.isNull(empleado.getId());

        Boolean pagina = Objects.isNull(empleado.getPagina());

        Boolean where = id;
        return """
               SELECT ID
               FROM V_PERSONAS_EMPLEADOS
               %s%s
               """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d".formatted(empleado.getId())
        ).strip().concat("%s").formatted(
                pagina ? "" : "\nROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                .formatted(
                                        empleado.getPagina().getNPaginaNro(),
                                        empleado.getPagina().getNCantidadFilas(),
                                        empleado.getPagina().getNPaginaNro(),
                                        empleado.getPagina().getNCantidadFilas()
                                )
        );
    }
    //--------------------------------------------------------------------------

    /**
     *
     * @param empleado
     * @return
     */
    public static Resultado insert(
            Empleado empleado
    ) {
        final String sql = "EXECUTE PROCEDURE SP_I_PERSONA_EMPLEADO (?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, empleado.getId());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(EMPLEADO_INSERTADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_EL_EMPLEADO_AL_SISTEMA,
                    ex
            );
        }

        return Resultado
                .builder()
                .mensaje(ERROR_AL_INSERTAR_EL_EMPLEADO_AL_SISTEMA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }

    /**
     *
     * @param empleado
     * @return
     */
    public static Resultado insertATR(
            Empleado empleado
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SP_I_PERSONA_EMPLEADO_ATR (?,?,?,?)
                           """;

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, empleado.getId());
            ps.setInt(2, empleado.getIdDepartamento());
            ps.setInt(3, empleado.getIdCargo());
            ps.setBigDecimal(4, empleado.getSueldoBruto());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(EMPLEADO_INSERTADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_EL_EMPLEADO_AL_SISTEMA,
                    ex
            );
        }

        return Resultado
                .builder()
                .mensaje(ERROR_AL_INSERTAR_EL_EMPLEADO_AL_SISTEMA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }

    public static final String EMPLEADO_INSERTADO_CORRECTAMENTE
            = "Empleado insertado correctamente.";
    public static final String ERROR_AL_INSERTAR_EL_EMPLEADO_AL_SISTEMA
            = "Error al insertar el empleado al sistema.";

    /**
     *
     * @param empleado
     * @return
     */
    public static Resultado delete(Empleado empleado) {
        final String sql = "EXECUTE PROCEDURE SP_D_PERSONA_EMPLEADO(?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, empleado.getId());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(EMPLEADO_BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_EMPLEADO_DEL_SISTEMA,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_BORRAR_EMPLEADO_DEL_SISTEMA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_BORRAR_EMPLEADO_DEL_SISTEMA
            = "Error al borrar empleado del sistema.";
    public static final String EMPLEADO_BORRADO_CORRECTAMENTE
            = "Empleado borrado correctamente.";
}
