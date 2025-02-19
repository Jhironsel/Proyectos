package sur.softsurena.metodos;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_E_S_SYS {

    /**
     * Metodo que permite agregar una imagen en la pantalla principal del
     * sistema, es llamado logo de la aplicacion.
     *
     * @param file recibe una ruta de la imagen selecciona la cual es convertida
     * a base64 para luego ser almacenada.
     *
     * @return Devuelve un valor booleano que indica si la operacion tuvo exito
     * o no.
     */
    public synchronized static Resultado insertLogo(File file) {
        final String sql
                = """
                    EXECUTE PROCEDURE SP_I_T_E_S_SYS(?,?)
                  """;
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setString(1, Utilidades.imagenEncode64(file));
            cs.setString(2, file.toString());

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(REGISTRO_EXITOSO)
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
                .mensaje(ERROR_EN_LA_OPERACION)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_EN_LA_OPERACION
            = "Error en la operacion.!!!";
    public static final String REGISTRO_EXITOSO
            = "Registro exitoso.!!!";

    /**
     * Metodo encargado de obtener el logo del sistema registrado.
     *
     * @return
     */
    public synchronized static String getLogo() {
        final String sql
                = """
                  SELECT LOGO 
                  FROM V_T_E_S_SYS 
                  WHERE ID = 1; 
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            return rs.getString(1);
            
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
        }
        return "";
    }
}
