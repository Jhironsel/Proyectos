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
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Padre;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Padre {

    /**
     * Metodo que nos devuelve los padres registrados en el sistemas.
     *
     * @param padre
     *
     * @return
     */
    public synchronized static List<Padre> select(
            @NonNull Padre padre
    ) {

        List<Padre> listaPadre = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(padre),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaPadre.add(
                        Padre
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
        return listaPadre;
    }

    /**
     * 
     * @param padre
     * @return
     */
    protected static String sqlSelect(Padre padre) {
        Boolean id = Objects.isNull(padre.getId());
        Boolean pagina = Objects.isNull(padre.getPagina());
        return """
               SELECT ID
               FROM PERSONAS_PADRES
               %s
               """.formatted(
                id ? "" : "WHERE ID = %d ".formatted(padre.getId())
        ).trim().strip().concat("%s").formatted(
                pagina ? "" : "\nROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                .formatted(
                                        padre.getPagina().getNPaginaNro(),
                                        padre.getPagina().getNCantidadFilas(),
                                        padre.getPagina().getNPaginaNro(),
                                        padre.getPagina().getNCantidadFilas()
                                )
        ).trim().strip();
    }
//------------------------------------------------------------------------------

    /**
     * Metodo que permite agregar los padres al sistema pediatrico.
     *
     * @param padre
     * @return
     */
    public static Resultado insert(Padre padre) {
        final String sql
                = "EXECUTE PROCEDURE SP_I_PERSONA_PADRE(?)";
        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, padre.getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(PADRE__AGREGADO__EXITOSAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_AGREGAR_PADRE_AL_SISTEMA,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_AGREGAR_PADRE_AL_SISTEMA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }

    }
    public static final String ERROR_AL_AGREGAR_PADRE_AL_SISTEMA
            = "Error al agregar padre al sistema";
    public static final String PADRE__AGREGADO__EXITOSAMENTE
            = "Padre Agregado Exitosamente!";

    /**
     * Metodo que elimina el registro del identificador de la tabla
     * PERSONAS_PADRES.
     *
     * @param padre
     *
     * @return
     */
    public synchronized static Resultado delete(Padre padre) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_PERSONA_PADRE(?)";

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, padre.getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(BORRADO_DE_REGISTRO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_PADRE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_PADRE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR_PADRE
            = "Error al borrar Registro.!!!";
    public static final String BORRADO_DE_REGISTRO_CORRECTAMENTE
            = "Borrado de registro correctamente.!!!";
}
