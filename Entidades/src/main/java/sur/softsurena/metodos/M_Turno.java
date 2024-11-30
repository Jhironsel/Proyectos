package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Turno;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Turno {
    /**
     * TODO 24/11/2024 Trata de agregar NonNull al parametro del metodo.
     * @param filtro
     * @return
     */
    public static List<Turno> getTurnos(@NonNull FiltroBusqueda filtro) {
        List<Turno> turnosList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlGetTurnos(filtro),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    turnosList.add(
                            Turno
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .turno_usuario(rs.getString("TURNO_USUARIO"))
                                    .fecha_hora_inicio(rs.getTimestamp("FECHA_HORA_INICIO"))
                                    .fecha_hora_final(rs.getTimestamp("FECHA_HORA_FINAL"))
                                    .estado(rs.getBoolean("ESTADO"))
                                    .monto_facturado(rs.getBigDecimal("MONTO_FACTURADO"))
                                    .monto_devuelto(rs.getBigDecimal("MONTO_DEVUELTO"))
                                    .monto_efectivo(rs.getBigDecimal("MONTO_EFECTIVO"))
                                    .monto_credito(rs.getBigDecimal("MONTO_CREDITO"))
                                    .build()
                    );
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
        }
        return turnosList;
    }
    
    protected static String sqlGetTurnos(FiltroBusqueda filtro){
        Boolean f_criterio = Objects.isNull(filtro.getCriterioBusqueda());
        
        return """
               SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, 
               ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO 
               FROM V_TURNOS 
               WHERE %s%s
               """.formatted(
                       (filtro.getEstado() ? "ESTADO ":"ESTADO IS FALSE "),
                       f_criterio ? 
                                "" : 
                                "AND UPPER(TRIM(TURNO_USUARIO)) LIKE UPPER(TRIM('%s'));"
                                        .formatted(filtro.getCriterioBusqueda())
               );
    }
    
//------------------------------------------------------------------------------
    
    /**
     * Metodo que nos permite habilitar a los cajeros al modulo de facturacion.
     * 
     * @param idUsuario
     * @return
     */
    public synchronized static Resultado habilitarTurno(String idUsuario) {
        final String sql = "EXECUTE PROCEDURE ADMIN_HABILITAR_TURNO(?)";
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            cs.setString(1, idUsuario);

            cs.execute();

            return Resultado
                    .builder()
                    .estado(Boolean.TRUE)
                    .mensaje(TURNO_HABILITADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .estado(Boolean.FALSE)
                    .mensaje(ERROR_AL_HABILITAR_EL_TURNO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .build();
        }
    }
    public static final String ERROR_AL_HABILITAR_EL_TURNO 
            = "Error al habilitar el turno";
    public static final String TURNO_HABILITADO_CORRECTAMENTE 
            = "Turno habilitado correctamente.";

    /**
     * Metodo que nos permite cerrar los turno de los cajeros habiertos en el
     * sistema.
     *
     * @param idTurno
     * @return
     */
    public synchronized static boolean cerrarTurno(Integer idTurno) {
        final String sql = "EXECUTE PROCEDURE ADMIN_CERRAR_TURNO(?)";
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            cs.setInt(1, idTurno);
            return cs.execute();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }
}
