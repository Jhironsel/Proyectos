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
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Huella;
import static sur.softsurena.metodos.M_Producto.ERROR_AL__MODIFICAR__PRODUCTO;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */

/**
 * Model class for handling fingerprints. 
 * Provides functionality to select and insert fingerprint data into the database.
 * 
 * @version 1.0
 */
public class M_Huella {

    /**
     * Metodo que consulta las huellas del sistema. Este puede entregar todas 
     * las huellas registradas o las huellas de una persona. 
     * @param huella
     * @return
     */
    public static List<Huella> select(
            @NonNull Huella huella
    ) {
        List<Huella> lista = new ArrayList<>();

        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            try (ResultSet rs = ps.executeQuery(sqlSelect(huella));) {
                while (rs.next()) {
                    lista.add(
                            Huella
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .idPersona(rs.getInt("ID_PERSONA"))
                                    .tipoDedo(rs.getString("TIPO_DEDO"))
                                    .huella(rs.getBytes("HUELLA"))
                                    .build()
                    );
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar las huellas en el sistema.",
                    ex
            );
        }

        return lista;
    }

    protected static String sqlSelect(Huella huella) {
        Boolean id = Objects.isNull(huella.getId());
        Boolean idPersona = Objects.isNull(huella.getIdPersona());
        Boolean where = id && idPersona;

        return """
               SELECT ID, ID_PERSONA, TIPO_DEDO, HUELLA
               FROM V_HUELLAS
               %s%s%s
               """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(huella.getId()),
                idPersona ? "" : "ID_PERSONA = %d ".formatted(huella.getIdPersona())
        ).strip();
    }
//------------------------------------------------------------------------------

    /**
     * Metod que permite insertar una huella de una persona en el sistema. 
     * @param huella
     * @return
     */
    public static Resultado insert(
            @NonNull Huella huella
    ) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_HUELLA (?,?,?);
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, huella.getIdPersona());
            ps.setString(2, huella.getTipoDedo());
            ps.setBytes(4, huella.getHuella());

            ResultSet rs = ps.executeQuery();

            rs.next();

            return Resultado
                    .builder()
                    .id(rs.getInt("ID"))
                    .mensaje(HUELLA_REGISTRADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ERROR_AL_INSERTAR_LA_HUELLA_EN_EL_SISTEMA,
                    ex
            );

            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL_INSERTAR_LA_HUELLA_EN_EL_SISTEMA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String HUELLA_REGISTRADA_CORRECTAMENTE 
            = "Huella registrada correctamente.!!!";
    public static final String ERROR_AL_INSERTAR_LA_HUELLA_EN_EL_SISTEMA
            = "Error al insertar la huella en el sistema.";
//------------------------------------------------------------------------------
    
    /**
     * Metodo que actualiza una huella de una personas en el sistema.
     * @param huella
     * @return
     */
    public static Resultado update(
            @NonNull Huella huella
    ){
        final String sql = """
                           EXECUTE PROCEDURE SP_U_HUELLA(?,?,?);
                           """;
        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, huella.getId());
            ps.setString(2, huella.getTipoDedo());
            ps.setBytes(3, huella.getHuella());
            
            ps.executeUpdate();
            
            return Resultado
                    .builder()
                    .mensaje(HUELLA_ACTUALIZADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        }  catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL__MODIFICAR__PRODUCTO,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_ACTUALIZAR_LA_HUELLA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_ACTUALIZAR_LA_HUELLA 
            = "Error al actualizar la huella.!!!";
    public static final String HUELLA_ACTUALIZADA_CORRECTAMENTE 
            = "Huella actualizada correctamente.!!!";
//------------------------------------------------------------------------------
    
    /**
     * Metodo que elimina un registro de una huella en el sistema.
     * 
     * @param huella
     * @return
     */
    public synchronized static Resultado delete(
            @NonNull Huella huella
    ){
        final String sql = """
                           EXECUTE PROCEDURE SP_D_HUELLA (?);
                           """;
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            
            cs.setInt(1, huella.getId());
            
            cs.executeUpdate();
            
            return Resultado
                    .builder()
                    .mensaje(HUELLA_ELIMINADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ERROR_AL_ELIMINAR_LA_HUELLA_DEL_SISTEMA,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_LA_HUELLA_DEL_SISTEMA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
//------------------------------------------------------------------------------

    /**
     * Metodo que elimina las huellas de una persona en el sistema.
     * @param huella
     * @return
     */
    public synchronized static Resultado deleteByIDPersona(
            @NonNull Huella huella
    ){
        final String sql = """
                           EXECUTE PROCEDURE SP_D_HUELLA_ID_PERSONA (?);
                           """;
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            
            cs.setInt(1, huella.getIdPersona());
            
            cs.executeUpdate();
            
            return Resultado
                    .builder()
                    .mensaje(HUELLA_ELIMINADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ERROR_AL_ELIMINAR_LA_HUELLA_DEL_SISTEMA,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_LA_HUELLA_DEL_SISTEMA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_ELIMINAR_LA_HUELLA_DEL_SISTEMA = 
            "Error al eliminar la huella del sistema.!!!";
    public static final String HUELLA_ELIMINADA_CORRECTAMENTE = 
            "Huella eliminada correctamente.!!!";
    
}
