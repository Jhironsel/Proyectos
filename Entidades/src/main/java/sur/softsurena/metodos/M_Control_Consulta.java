package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Control_Consulta;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Control_Consulta {

    /**
     * Permite agregar un control de consulta al sistema.
     *
     * @param controlConsulta
     * @return
     */
    public synchronized static Resultado agregarControlConsulta(Control_Consulta controlConsulta) {
        final String sql
                = """
                  SELECT O_ID
                  FROM SP_I_CONTROL_CONSULTA (?, ?, ?, ?, ?, ?);
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setString(1, controlConsulta.getUser_name());
            ps.setInt(2, controlConsulta.getCantidad());
            ps.setString(3, controlConsulta.getDia());
            ps.setTime(4, controlConsulta.getInicial());
            ps.setTime(5, controlConsulta.getFinall());
            ps.setBoolean(6, controlConsulta.getEstado());

            ResultSet rs = ps.executeQuery();
            rs.next();

            return Resultado
                    .builder()
                    .id(rs.getInt(1))
                    .mensaje(CONTROL_CONSULTA_AGREGADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_AGREGAR__CONTROL__CONSULTA_AL_SIST,
                    ex
            );
            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL_AGREGAR__CONTROL__CONSULTA_AL_SIST)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_AGREGAR__CONTROL__CONSULTA_AL_SIST
            = "Error al agregar Control Consulta al sistema.";
    public static final String CONTROL_CONSULTA_AGREGADO_CORRECTAMENTE
            = "Control consulta agregado correctamente.";

    /**
     * Metodo que modificas los controles de consultas en el sistema.
     *
     * @param controlConsulta
     * @return
     */
    public static synchronized Resultado modificarControlConsulta(
            Control_Consulta controlConsulta
    ) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_U_CONTROL_CONSULTA (?,?,?,?,?,?,?);
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, controlConsulta.getId());
            ps.setString(2, controlConsulta.getUser_name());
            ps.setInt(3, controlConsulta.getCantidad());
            ps.setString(4, controlConsulta.getDia());
            ps.setTime(5, controlConsulta.getInicial());
            ps.setTime(6, controlConsulta.getFinall());
            ps.setBoolean(7, controlConsulta.getEstado());

            ps.execute();
            
            return Resultado
                    .builder()
                    .mensaje(CONSULTA_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_CONSULTA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String CONSULTA_MODIFICADO_CORRECTAMENTE 
            = "Control Consulta modificado correctamente.";
    public static final String ERROR_AL_MODIFICAR_CONSULTA 
            = "Error al modificar control consulta del sistema.";

    /**
     * Metodos que consultas las fechas y horas de los doctores en el sistema.
     * 
     * @param dia es el dia que el doctor realiza consultas medicas.
     * 
     * @return returna una lista de consultas disponibles en el sistema.
     */
    public synchronized static List<Control_Consulta> getFechaDoctores(String dia) {
        final String sql
                = """
                  SELECT ID, USER_NAME, CANTIDAD_PACIENTE, DIA, INICIAL, FINAL, ESTADO
                  FROM V_CONTROL_CONSULTA
                  WHERE DIA STARTING WITH ?;
                  """;
        
        List<Control_Consulta> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, dia);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(
                        Control_Consulta
                                .builder()
                                .id(rs.getInt("ID"))
                                .user_name(rs.getString("USER_NAME"))
                                .cantidad(rs.getInt("CANTIDAD_PACIENTE"))
                                .dia(rs.getString("DIA"))
                                .inicial(rs.getTime("INICIAL"))
                                .finall(rs.getTime("FINAL"))
                                .estado(rs.getBoolean("ESTADO"))
                                .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        return lista;
    }

    /**
     * Lista de controles de las consultas del sistema.
     * @param idUsuario
     * @return
     */
    public synchronized static List<Control_Consulta> getHorario(String idUsuario) {
        final String sql = """
                           SELECT ID, CANTIDAD_PACIENTE, DIA, INICIAL, FINAL 
                           FROM V_CONTROL_CONSULTA 
                           WHERE USER_NAME = ? ;
                           """;
        
        List<Control_Consulta> lista = new ArrayList<>();
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, idUsuario);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(
                    Control_Consulta
                            .builder()
                            .id(rs.getInt("ID"))
                            .cantidad(rs.getInt("CANTIDAD_PACIENTE"))
                            .dia(rs.getString("DIA"))
                            .inicial(rs.getTime("INICIAL"))
                            .finall(rs.getTime("FINAL"))
                            .estado(rs.getBoolean("ESTADO"))
                            .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lista;
    }
    
    /**
     * Metodo utilizado para eliminar los controles de consultas programadas
     * previamente.
     *
     * @param idControlConsulta
     *
     * @return
     */
    public synchronized static Resultado borrarControlConsulta(int idControlConsulta) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_CONTROL_CONSULTA (?);";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, idControlConsulta);
            
            ps.execute();
            
            return Resultado
                    .builder()
                    .mensaje(CONTROL__CONSULTA_BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_CONTROL_DE_LA_CONSULTA,
                    ex
            );
            
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_CONTROL_DE_LA_CONSULTA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR_CONTROL_DE_LA_CONSULTA
            = "Error al borrar control de la consulta";
    public static final String CONTROL__CONSULTA_BORRADO_CORRECTAMENTE
            = "Control Consulta borrado correctamente";
}
