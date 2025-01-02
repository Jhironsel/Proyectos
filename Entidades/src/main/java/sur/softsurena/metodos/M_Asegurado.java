package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.ARS;
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
    public synchronized static List<Asegurado> select(Asegurado asegurado) {
        final String sql = """
                           SELECT ID, ID_PERSONA, ID_ARS, NO_NSS, ESTADO
                           FROM V_ASEGURADOS
                           WHERE ID_PERSONA = ?
                           """;
        List<Asegurado> list = new ArrayList<>();
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            ps.setInt(1, asegurado.getPersona().getId_persona());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(
                        Asegurado
                                .builder()
                                .id(rs.getInt("ID"))
                                .persona(
                                        M_Persona.select(
                                                Persona
                                                        .builder()
                                                        .id_persona(rs.getInt("ID_PERSONA"))
                                                        .build()
                                        ).getFirst()
                                )
                                .ars(
                                        M_ARS.select(
                                                ARS
                                                        .builder()
                                                        .id(rs.getInt("ID_ARS"))
                                                        .build()
                                        ).getFirst()
                                )
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
                                    asegurado.getPersona().getId_persona()
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
    public synchronized static Resultado insert(Asegurado asegurado) {
        final String sql = """
                           EXECUTE PROCEDURE SP_I_ASEGURADO(?,?,?,?)
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, asegurado.getPersona().getId_persona());
            ps.setInt(2, asegurado.getArs().getId());
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
                                    asegurado.getPersona().getId_persona()
                            ),
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(
                        ERROR_AL_REGISTRAR_ASEGURADO_EN_EL_SISTEM
                                .formatted(
                                        asegurado.getPersona().getId_persona()
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
    public synchronized static Resultado update(Asegurado asegurado) {
        return Resultado.builder().build();
    }
    
//------------------------------------------------------------------------------    
    public synchronized static Resultado delete(Asegurado asegurado) {
        return Resultado.builder().build();
    }
}
