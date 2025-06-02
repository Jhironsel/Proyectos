package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Almacen {

    public static String sqlSelect(Almacen almacen) {
        Boolean id = Objects.isNull(almacen.getId());
        Boolean nombre = Objects.isNull(almacen.getNombre());
        Boolean estado = Objects.isNull(almacen.getEstado());
        Boolean where = id && nombre && estado;
        return """
               SELECT ID, NOMBRE, UBICACION, ESTADO 
               FROM V_ALMACENES 
               %s%s%s%s
               """.formatted(
                       where ? "":"WHERE ",
                       id ? "":"ID = %d ".formatted(almacen.getId()),
                       nombre ? "":"NOMBRE STARTING WITH '%s'".formatted(almacen.getNombre()),
                       estado ? "":"ESTADO IS %b ".formatted(almacen.getEstado())
               ).strip();
    }

    /**
     * Metodo que consulta al sistema sobre los almacenes registrados en el
     * sistema.
     *
     * @param almacen Contiene los elementos a filtrar en la consulta.
     *
     * @return Una lista de los resultados del sistema.
     */
    public static List<Almacen> select(
            @NonNull Almacen almacen
    ) {
        List < Almacen > almacenList = new ArrayList<>();

        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        ); ResultSet rs = ps.executeQuery(sqlSelect(almacen));) {

            while (rs.next()) {
                almacenList.add(
                        Almacen
                                .builder()
                                .id(rs.getInt("ID"))
                                .nombre(rs.getString("NOMBRE"))
                                .ubicacion(rs.getString("UBICACION"))
                                .estado(rs.getBoolean("ESTADO"))
                                .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar la vista V_ALMACENES del sistema.",
                    ex
            );
        }
        return almacenList;
    }

    /**
     * Metodo utilizado para agregar almacenes fisico o virtuales de las
     * mercancias.
     *
     * @param almacen
     * @return
     */
    public static Resultado updateOrInsert(
            @NonNull Almacen almacen
    ) {
        final String sql = """
                           SELECT O_ID
                           FROM SP_UI_ALMACEN(?,?,?,?);
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            if (Objects.isNull(almacen.getId())) {
                ps.setNull(1, Types.INTEGER);
            } else {
                ps.setInt(1, almacen.getId());
            }
            ps.setString(2, almacen.getNombre());
            ps.setString(3, almacen.getUbicacion());
            ps.setBoolean(4, almacen.getEstado());

            try (ResultSet rs = ps.executeQuery();) {

                rs.next();

                return Resultado
                        .builder()
                        .id(rs.getInt("O_ID"))
                        .mensaje(ALMACEN_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL_INSERTAR__ALMACEN)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_INSERTAR__ALMACEN
            = "Error al registrar/actualizar almacen al sistema.!!!";
    public static final String ALMACEN_AGREGADO_CORRECTAMENTE
            = "Almacen agregado/actualizado correctamente.!!!";

    /**
     * Elimina los registro de almacenes en el sistema.
     *
     * Para poder eliminar un almacen este no debe contener productos registrado
     * o relacionado.
     *
     *
     * @param id identificador del registros del sistema.
     * @return
     */
    public static Resultado delete(
            int id
    ) {
        try (PreparedStatement ps = getCnn().prepareStatement(
                """
                EXECUTE PROCEDURE SP_D_ALMACEN(?);
                """,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, id);

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(ALMACEN_ELIMINADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_ALMACEN,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_ALMACEN)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ALMACEN_ELIMINADO_CORRECTAMENTE
            = "Almacen eliminado correctamente.";
    public static final String ERROR_AL_ELIMINAR_ALMACEN
            = "Error al eliminar almacen.";
}
