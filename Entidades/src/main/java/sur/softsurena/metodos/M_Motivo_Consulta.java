package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.MotivoConsulta;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Motivo_Consulta {

    /**
     * Metodo que devuelve los motivo por la cual una consulta se ha generado.
     *
     * TODO Trabajando en este metodo.
     *
     * @return Que devuelva una lista.
     */
    public synchronized static List<MotivoConsulta> select() {
        final String sql = """
                           SELECT ID, DESCRIPCION
                           FROM V_T_MOTIVO_CONSULTA
                           """;
        
        final List<MotivoConsulta> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        MotivoConsulta
                                .builder()
                                .id(rs.getInt("ID"))
                                .descripcion(rs.getString("DESCRIPCION"))
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
        return lista;
    }

    /**
     * Metodo que permite eliminar un motivo de consultas a las consultas.
     *
     *
     * TODO Crear SP.
     *
     * @param mc
     * @return
     */
    public synchronized static String delete(MotivoConsulta mc) {
        final String sql
                = "DELETE FROM V_Motivos_Consulta WHERE ID = ?";
        try (PreparedStatement ps = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {

            ps.setInt(1, mc.getId());

            ps.executeUpdate();

            return MOTIVO_DE_CONSULTA_BORRADO_CORRECTAMENTE;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return ERROR_AL_BORRAR_MOTIVO_DE_LA_CONSULTA;
        }
    }

    public static final String ERROR_AL_BORRAR_MOTIVO_DE_LA_CONSULTA
            = "Error al borrar motivo de la consulta.";
    public static final String MOTIVO_DE_CONSULTA_BORRADO_CORRECTAMENTE
            = "Motivo de consulta borrado correctamente.";

    /**
     * TODO Crear SP.
     *
     * @param m
     * @return
     */
    public synchronized static boolean insert(String m) {
        final String sql
                = "INSERT INTO V_MOTIVOS_CONSULTA (DESCRIPCION) values (?)";
        try (PreparedStatement ps = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            ps.setString(1, m);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }
}
