package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.D_GuiaVigilancia;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_D_GuiaVigilancia {

    /**
     * Permite agregar guias de vigilancias de los pacientes en el sistema.
     *
     * @param detalle
     *
     * @return
     */
    public synchronized static Resultado insert(D_GuiaVigilancia detalle) {

        String sql = """
                     SELECT ID
                     FROM SP_I_D_GUIA_VIGILANCIA_DESARROLLO(?,?);
                     """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, detalle.getIdGuiaVigilanciaDesarrollo());
            ps.setInt(2, detalle.getIdPaciente());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje(GUIA_DE__DESARROLLO_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .mensaje(ERROR_AL_INSERTAR__GUIA_DE__VIGILANCIA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_INSERTAR__GUIA_DE__VIGILANCIA
            = "Error al insertar Guia de Vigilancia...";
    public static final String GUIA_DE__DESARROLLO_AGREGADA_CORRECTAMENTE
            = "Guia de Desarrollo agregada correctamente.!!!";

    /**
     * Permite actualizar la guias de vigilancias de los pacientes en el
     * sistema.
     *
     * @param detalle
     *
     * @return
     */
    public synchronized static Resultado update(D_GuiaVigilancia detalle) {

        try (CallableStatement ps = getCnn().prepareCall(
                "EXECUTE PROCEDURE SP_U_D_GUIA_VIGILANCIA_DESARROLLO(?,?,?)",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, detalle.getId());
            ps.setInt(2, detalle.getIdGuiaVigilanciaDesarrollo());
            ps.setInt(3, detalle.getIdPaciente());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(GUIA_DE__DESARROLLO_ACTUALIZADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ACTUALIZAR__GUIA_DE__VIGILANCIA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_ACTUALIZAR__GUIA_DE__VIGILANCIA
            = "Error al actualizar Guia de Vigilancia...";
    public static final String GUIA_DE__DESARROLLO_ACTUALIZADA_CORRECTAMENTE
            = "Guia de Desarrollo actualizada correctamente.!!!";
    
    /**
     * Permite actualizar la guias de vigilancias de los pacientes en el
     * sistema.
     *
     * @param detalle
     *
     * @return
     */
    public synchronized static Resultado delete(
            @NonNull D_GuiaVigilancia detalle
    ){
        try (CallableStatement ps = getCnn().prepareCall(
                "EXECUTE PROCEDURE SP_D_D_GUIA_VIGILANCIA_DESARROLLO(?)",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, detalle.getId());
            
            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(GUIA_DE_DESARROLLO_ELIMINADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_GUIA_DE_VIGILANCIA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_ELIMINAR_GUIA_DE_VIGILANCIA
            = "Error al eliminar Guia de Vigilancia...";
    public static final String GUIA_DE_DESARROLLO_ELIMINADA_CORRECTAMENTE
            = "Guia de Desarrollo eliminada correctamente.!!!";
    
    
}
