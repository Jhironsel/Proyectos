package sur.softsurena.metodos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.AlturaPeso;
import sur.softsurena.entidades.Dato_Nacimiento;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Dato_Nacimiento {
    /**
     * 
     * @param id_paciente
     * @return
     */
    public synchronized static Dato_Nacimiento getDatosNacimiento(int id_paciente) {
        final String sql = """
                           SELECT FECHANACIMIENTO, PESONACIMIENTOKG, ALTURA, MC, 
                                    CESAREA, TIEMPOGESTACION, PC 
                           FROM V_DATOSNACIMIENTO 
                           WHERE idPaciente = ?
                           """;
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, id_paciente);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();

            return Dato_Nacimiento.builder().build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
            return Dato_Nacimiento.builder().build();
        }
    }

    /**
     * Metodo para consultar la altura y el peso de un paciente.
     * @param idPaciente
     * @return 
     */
    public synchronized static List<AlturaPeso> getAlturaPeso(int idPaciente) {
        final String sql = """
                           SELECT PESOKG, ESTATURAMETRO
                           FROM GET_METRICAS
                           WHERE ID_PACIENTE = ?
                           """;

        List<AlturaPeso> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql
        )) {
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                    lista.add(
                            AlturaPeso
                                    .builder()
                                    .pesoKG(rs.getFloat("PESOKG"))
                                    .estaturaMetro(rs.getFloat("ESTATURAMETRO"))
                                    .build()
                    );
                }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
        }
        
        return lista;
    }

    /**
     * TODO 12/04/2025 Estos metodo aqui no van. 
     * 
     * Dicha consulta debe traer la edad en meses y la medida del craneo en CM.
     * 
     * @param idPaciente
     * @return 
     */
    public synchronized static ResultSet getPCefalico(int idPaciente) {
        Date fecha_nacimiento = M_Persona.select(
                Persona
                        .builder()
                        .idPersona(idPaciente)
                        .build()
        ).getFirst().getFecha_nacimiento();
        
        final String sql = """
                           
                           """;
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            ps.setInt(1, idPaciente);
            
            return ps.executeQuery();
            
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    "Error al consultar la vista de TODO Crear Vista.>", 
                    ex
            );
            return null;
        }
    }

    /**
     * TODO Devolver una lista.
     * @param idPaciente
     * @return 
     */
    public synchronized static ResultSet getPesoKG(int idPaciente) {
        final String sql = """
                           SELECT OUT_FECHANACIMIENTO, OUT_FECHACONSULTA, 
                                  OUT_DEFERENCIAFECHA, OUT_PC 
                           FROM PRO_PESO_EDAD(?)
                           """;
        
//        List<
        
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            ps.setInt(1, idPaciente);
            
            return ps.executeQuery();
            
        } catch (SQLException ex) {
            
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(),
                    ex
            );
            
            return null;
        }
    }

    /**
     * TODO Devolver una lista.
     * @param idPaciente
     * @return 
     */
    public synchronized static ResultSet getLongitudOEstatura(int idPaciente) {
        final String sql 
                = "SELECT "
                + "     OUT_FECHANACIMIENTO, "
                + "     OUT_FECHACONSULTA, "
                + "     OUT_DEFERENCIAFECHA, "
                + "     OUT_LONGITUD, "
                + "     OUT_ESTATURA "
                + "FROM PRO_LONGITUD_ALTURA_EDAD(?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idPaciente);
            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
            return null;
        }
    }

    /**
     * TODO Devolver una lista.
     * @param idPaciente
     * @return 
     */
    public synchronized static ResultSet getLongitudPeso(int idPaciente) {
        final String sql 
                = "SELECT "
                + "     OUT_FECHANACIMIENTO, "
                + "     OUT_FECHACONSULTA, "
                + "     OUT_DEFERENCIAFECHA, "
                + "     OUT_LONGITUD, "
                + "     OUT_ESTATURA "
                + "FROM PRO_PESO_LONGITUD(?)";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idPaciente);
            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ex.getMessage(), 
                    ex
            );
            return null;
        }
    }
}
