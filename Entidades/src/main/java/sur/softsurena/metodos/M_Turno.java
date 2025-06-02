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
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Turno {

    /**
     * Metodo que permite consultar los turnos en el sistema.
     *
     * @param turno
     *
     * @return
     */
    public static List<Turno> select(
            @NonNull Turno turno
    ) {
        List<Turno> turnosList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(turno),
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
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return turnosList;
    }

    protected static String sqlSelect(Turno turno) {
        Boolean f_criterio = Objects.isNull(turno.getTurno_usuario());
        Boolean estado = Objects.isNull(turno.getEstado());
        Boolean where = f_criterio && estado;
        return """
               SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, 
               ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO 
               FROM V_TURNOS 
               %s%s%s
               """.formatted(
                where ? "" : "WHERE ",
                (estado ? "" : (turno.getEstado() ? "ESTADO " : "ESTADO IS FALSE ")),
                f_criterio
                        ? ""
                        : "AND UPPER(TRIM(TURNO_USUARIO)) LIKE UPPER(TRIM('%s'));"
                                .formatted(turno.getTurno_usuario())
        ).strip();
    }

    //--------------------------------------------------------------------------
    /**
     * Metodo que nos permite habilitar a los cajeros al modulo de facturacion.
     *
     * @param idUsuario
     * @return
     */
    public synchronized static Resultado insert(String idUsuario) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_TURNO(?);
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            rs.next();

            return Resultado
                    .builder()
                    .id(rs.getInt("ID"))
                    .estado(Boolean.TRUE)
                    .mensaje(TURNO_HABILITADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .id(-1)
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

    //--------------------------------------------------------------------------
    /**
     * Metodo que nos permite cerrar los turno de los cajeros habiertos en el
     * sistema.
     *
     * @param idTurno
     * @return
     */
    public synchronized static Resultado update(Integer idTurno) {
        final String sql = "EXECUTE PROCEDURE SP_U_TURNO(?)";
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            cs.setInt(1, idTurno);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(TURNO_CERRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_CERRAR_EL__TURNO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_CERRAR_EL__TURNO
            = "Error al cerrar el Turno.!!!";
    public static final String TURNO_CERRADO_CORRECTAMENTE
            = "Turno cerrado correctamente.!!!";

    //--------------------------------------------------------------------------
    /**
     * Metodo que elimina fisicamente el registro de turno.
     *
     * @param idTurno
     * @return
     */
    public synchronized static Resultado delete(Integer idTurno) {
        final String sql = "EXECUTE PROCEDURE SP_D_TURNO(?)";

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            cs.setInt(1, idTurno);

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(TURNO_ELIMINADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_TURNO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_ELIMINAR_TURNO
            = "Error al eliminar turno.";
    public static final String TURNO_ELIMINADO_CORRECTAMENTE
            = "Turno eliminado correctamente.";
}
