package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    /**
     * Metodo que consulta al sistema sobre los almacenes registrados en el
     * sistema.
     *
     * @param almacen Contiene los elementos a filtrar en la consulta.
     *
     * @return Una lista de los resultados del sistema.
     */
    public synchronized static List<Almacen> select(
            @NonNull Almacen almacen
    ) {
        final String sql
                = """
                    SELECT 
                        ID, 
                        NOMBRE, 
                        UBICACION, 
                        ESTADO 
                    FROM V_ALMACENES 
                    WHERE 
                        ID = ? OR 
                        UPPER(NOMBRE) STARTING WITH UPPER(?) OR
                        UPPER(NOMBRE) CONTAINING UPPER(?);
                """;

        List<Almacen> almacenList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, almacen.getId());
            ps.setString(2, almacen.getNombre());
            ps.setString(3, almacen.getNombre());

            try (ResultSet rs = ps.executeQuery();) {
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
    public synchronized static Resultado insert(
            @NonNull Almacen almacen
    ) {
        final String sql
                = "SELECT O_ID FROM SP_I_ALMACEN(?,?,?,?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            if(Objects.isNull(almacen.getId())){
                ps.setNull(1, Types.INTEGER);
            }else{
                int valor = almacen.getId();
                ps.setInt(1, valor);
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
            = "Error al registrar almacen al sistema.";
    public static final String ALMACEN_AGREGADO_CORRECTAMENTE
            = "Almacen agregado correctamente";

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
    public synchronized static Resultado delete(
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

    //--------------------------------------------------------------------------
    /**
     * Metodo utilizado para actualizar los registros del sistema de los
     * almacenes registrados.
     *
     * @param almacen
     *
     * @return
     */
    public synchronized static Resultado update(
            @NonNull Almacen almacen
    ) {
        try (PreparedStatement cs = getCnn().prepareStatement(
                """
                EXECUTE PROCEDURE SP_U_ALMACEN(?,?,?,?)
                """,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, almacen.getId());
            cs.setString(2, almacen.getNombre());
            cs.setString(3, almacen.getUbicacion());
            cs.setBoolean(4, almacen.getEstado());

            cs.execute();

            return Resultado
                    .builder()
                    .mensaje(ALMACEN_ACTUALIZADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_ALMACEN,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_ACTUALIZAR_EL_REGISTRO_DEL_ALMAC)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_ACTUALIZAR_EL_REGISTRO_DEL_ALMAC
            = "Error al actualizar el registro del almacen.";
    public static final String ALMACEN_ACTUALIZADO_CORRECTAMENTE
            = "Almacen actualizado correctamente.";
}
