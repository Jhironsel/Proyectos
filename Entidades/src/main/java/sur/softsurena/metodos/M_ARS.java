package sur.softsurena.metodos;

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
import sur.softsurena.entidades.ARS;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_ARS {

    /**
     * Metodo que nos permite obtener una lista de Seguros Sociales del sistema.
     *
     * @param ars
     * @return retorna una lista completa de los seguros sociales del sistema.
     */
    public synchronized static List<ARS> select(
            @NonNull ARS ars
    ) {
        List<ARS> arsList = new ArrayList<>();

        try (
                Statement ps = getCnn().createStatement(
                        ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_READ_ONLY,
                        ResultSet.HOLD_CURSORS_OVER_COMMIT
                ); ResultSet rs = ps.executeQuery(sqlARS(ars))) {
                    while (rs.next()) {
                        arsList.add(
                                ARS
                                        .builder()
                                        .id(rs.getInt("ID"))
                                        .descripcion(rs.getString("DESCRIPCION"))
                                        .covertura(rs.getBigDecimal("COVERTURA_CONSULTA_PORCIENTO"))
                                        .estado(rs.getBoolean("ESTADO"))
                                        .cantidadRegistro(rs.getInt("CANTIDAD_REGISTRO"))
                                        .build()
                        );
                    }
                } catch (SQLException ex) {
                    LOG.log(
                            Level.SEVERE,
                            ERROR_AL_CONSULTAR_LA_VISTA_V_ARS_DEL,
                            ex
                    );
                }
                return arsList;
    }
    public static final String ERROR_AL_CONSULTAR_LA_VISTA_V_ARS_DEL
            = "Error al consultar la vista V_ARS del sistema.";

    protected static String sqlARS(ARS ars) {

        return """
               SELECT ID, DESCRIPCION, COVERTURA_CONSULTA_PORCIENTO, ESTADO, CANTIDAD_REGISTRO
               FROM V_ARS
               %s
               """.formatted(
                Objects.isNull(ars.getEstado()) ? "" : ars.getEstado()
                ? "WHERE ESTADO" : "WHERE ESTADO IS FALSE"
        ).strip().trim().concat(";");
    }
//------------------------------------------------------------------------------

    /**
     * Procedimiento que permite agregar los seguros de los paciente al sistema.
     *
     * @param ars Es un objecto que contiene la informacion de los seguros en el
     * sistema.
     *
     * @return
     */
    public synchronized static Resultado insert(ARS ars) {
        final String sql
                = """
                  SELECT O_ID 
                  FROM SP_I_ARS (?, ?, ?);
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, ars.getDescripcion());
            ps.setBigDecimal(2, ars.getCovertura());
            ps.setBoolean(3, ars.getEstado());

            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return Resultado
                        .builder()
                        .id(rs.getInt("O_ID"))
                        .mensaje(SEGURO_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR__SEGURO,
                    ex
            );
            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL_INSERTAR__SEGURO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String SEGURO_AGREGADO_CORRECTAMENTE
            = "Seguro agregado correctamente";
    public static final String ERROR_AL_INSERTAR__SEGURO
            = "Error al insertar Seguro...";
//------------------------------------------------------------------------------

    /**
     * Metodo que modifica las ARS del sistema.
     *
     * @param ars
     * @return
     */
    public synchronized static Resultado update(ARS ars) {
        String sql = "EXECUTE PROCEDURE SP_U_ARS (?, ?, ?, ?);";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, ars.getId());
            ps.setString(2, ars.getDescripcion());
            ps.setBigDecimal(3, ars.getCovertura());
            ps.setBoolean(4, ars.getEstado());

            ps.execute();
            return Resultado
                    .builder()
                    .mensaje(SEGURO_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_MODIFICAR_SEGURO,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_SEGURO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String SEGURO_MODIFICADO_CORRECTAMENTE
            = "Seguro modificado correctamente";
    public static final String ERROR_AL_MODIFICAR_SEGURO
            = "Error al modificar seguro...";
//------------------------------------------------------------------------------

    /**
     * Trata de eliminar un registro de la tabla ARS, la cual debe tener una
     *
     * @param ars
     * @return
     */
    public synchronized static Resultado delete(ARS ars) {
        final String sql = "EXECUTE PROCEDURE SP_D_ARS(?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, ars.getId());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_ARS
                            .concat(
                                    " \nError al ejecutar SP_D_ARS(?) en el sistema, con el ID "
                            )
                            .concat(
                                    ars.getId().toString()
                            ),
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_ARS)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR_ARS
            = "Error al borrar ARS del sistema.";
    public static final String BORRADO_CORRECTAMENTE
            = "Borrado correctamente.";

}
