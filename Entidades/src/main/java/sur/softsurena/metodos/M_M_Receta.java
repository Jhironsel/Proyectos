package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.M_Receta;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_M_Receta {
    /**
     * Metodo que permite registrar las header de la receta en el sistema. 
     * 
     * @param receta
     * 
     * @return
     */
    public synchronized static Resultado insert(
            @NonNull M_Receta receta
    ) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_M_RECETA (?)
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, receta.getConsulta().getId());

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje(REGISTRO_DE_RECETA_CORRECTAMENTE)
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
                        .mensaje(ERROR_EN_EL_REGISTRO_DE_RECETA)
                        .icono(JOptionPane.ERROR_MESSAGE)
                        .estado(Boolean.FALSE)
                        .build();
    }
    public static final String ERROR_EN_EL_REGISTRO_DE_RECETA 
            = "Error en el registro de receta.!!!";
    public static final String REGISTRO_DE_RECETA_CORRECTAMENTE 
            = "Registro de receta correctamente.!!!";
    
    /**
     * TODO 26/12/2024 Crear Procedimiento
     * @param receta
     * @return 
     */
    public synchronized static Resultado select(
            @NonNull M_Receta receta
    ){
        return Resultado.builder().build();
    }
    
    /**
     * TODO 26/12/2024 Crear Procedimiento
     * @param receta
     * @return 
     */
    public synchronized static Resultado update(
            @NonNull M_Receta receta
    ){
        return Resultado.builder().build();
    }
    
    /**
     * TODO 26/12/2024 Crear Procedimiento
     * @param receta
     * @return 
     */
    public synchronized static Resultado delete(
            @NonNull M_Receta receta
    ){
        return Resultado.builder().build();
    }
}
