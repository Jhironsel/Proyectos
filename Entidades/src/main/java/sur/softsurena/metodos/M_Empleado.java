package sur.softsurena.metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import lombok.Cleanup;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Empleado;
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
    public synchronized static List<Empleado> select(
            @NonNull Empleado empleado
    ) {
        List<Empleado> lista = new ArrayList<>();
        //TODO 19.04.2025 Agregar la paginacion de consulta.
        final String sql = """
                           SELECT ID
                           FROM V_PERSONAS_EMPLEADOS
                           """;
        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            @Cleanup
            ResultSet rs = ps.executeQuery(sql);

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

//------------------------------------------------------------------------------
}
