package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Asegurado;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Asegurado {

    /**
     * Metodo que consulta los registros de la personas registrada y que 
     * contiene un seguro.
     * 
     * @param asegurado
     * 
     * @return 
     */
    public static List<Asegurado> select(Asegurado asegurado) {
        final String sql = """
                           SELECT ID, ID_PERSONA, ID_ARS, NO_NSS, ESTADO
                           FROM V_ASEGURADOS
                           WHERE ID_PERSONA = %d
                           """.formatted(asegurado.getIdPersona());
        List<Asegurado> list = new ArrayList<>();
        
        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        ); ResultSet rs = ps.executeQuery(sql);) {
            while(rs.next()){
                list.add(
                        Asegurado
                                .builder()
                                .id(rs.getInt("ID"))
                                .idPersona(rs.getInt("ID_PERSONA"))
                                .idArs(rs.getInt("ID_ARS"))
                                .no_nss(rs.getString("NO_NSS"))
                                .estado(rs.getBoolean("ESTADO"))
                                .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error en la consulta de Asegurodado con ID_PERSONA = %s"
                            .formatted(
                                    asegurado.getIdPersona()
                            ),
                    ex
            );
        }
        return list;
    }
    
//------------------------------------------------------------------------------
    /**
     * Metodo que permite registrar los registros de los seguro medicos de los
     * pacientes del sistema.
     *
     * @param asegurado
     * @return
     */
    public static Resultado insert(Asegurado asegurado) {
        final String sql = """
                           EXECUTE PROCEDURE SP_I_ASEGURADO(?,?,?,?)
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, asegurado.getIdPersona());
            ps.setInt(2, asegurado.getIdArs());
            ps.setString(3, asegurado.getNo_nss());
            ps.setBoolean(4, asegurado.getEstado());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(REGISTRO_DE_ASEGURADO_CORRECTAMENTE___CODI)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_REGISTRAR_ASEGURADO_EN_EL_SISTEM
                            .formatted(
                                    asegurado.getIdPersona()
                            ),
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(
                        ERROR_AL_REGISTRAR_ASEGURADO_EN_EL_SISTEM
                                .formatted(
                                        asegurado.getIdPersona()
                                )
                )
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_REGISTRAR_ASEGURADO_EN_EL_SISTEM
            = "Error al registrar asegurado en el sistema. \n Codigo=[%s]";
    public static final String REGISTRO_DE_ASEGURADO_CORRECTAMENTE___CODI
            = "Registro de asegurado correctamente.";
    
//------------------------------------------------------------------------------    
    public static Resultado update(Asegurado asegurado) {
        return Resultado.builder().build();
    }
    
//------------------------------------------------------------------------------    
    public static Resultado delete(Asegurado asegurado) {
        return Resultado.builder().build();
    }
}
