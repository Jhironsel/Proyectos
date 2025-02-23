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
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.Metrica;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * TODO 13/12/2024 Podria crear una tabla que guarde unicamente las imagenes de 
 * las metricas, lo cual podrias requerirse que en una metrica se requiera 
 * almacenar varias imagenes. 
 * 
 * @author jhironsel
 */
public class M_Metrica {

    /**
     * 
     * @param metrica
     * 
     * @return
     */
    public synchronized static List<Metrica> select(
            @NonNull Metrica metrica
    ) {

        List<Metrica> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(metrica),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        Metrica
                                .builder()
                                .id(rs.getInt("ID"))
                                .consulta(
                                        Consulta
                                                .builder()
                                                .id(rs.getInt("ID_CONSULTA"))
                                                .build()
                                )
                                .pesoKG(rs.getBigDecimal("PESOKG"))
                                .estaturaM(rs.getBigDecimal("ESTATURAMETRO"))
                                .escefalo(rs.getBigDecimal("ESCEFALO"))
                                .enf_detect(rs.getString("ENF_DETECT"))
                                .hallazgosPositivo(rs.getString("HALLAZGOS_POS"))
                                .idDiagnostico(rs.getString("ID_DIAG"))
                                .tx(rs.getString("TX"))
                                .complemento(rs.getString("COMPLEMENTO"))
                                .imagen(
                                        Utilidades.imagenDecode64(
                                                rs.getString("IMAGEN_TEXTO"),
                                                0,
                                                0
                                        )
                                )
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

    protected static String sqlSelect(Metrica metrica) {
        Boolean id = Objects.isNull(metrica.getId());
        Boolean where = id;
        return """
               SELECT ID, ID_CONSULTA, PESOKG, ESTATURAMETRO, ESCEFALO,
                ENF_DETECT, HALLAZGOS_POS, ID_DIAG, TX, COMPLEMENTO,
                IMAGEN_TEXTO, USER_NAME
               FROM V_METRICAS
               %s%s
               """.trim().strip().formatted(
                where ? "" : "WHERE ",
                       id ? "":"ID_CONSULTA = %d ".formatted(metrica.getId())
        ).trim().strip();
    }

//------------------------------------------------------------------------------
    /**
     * Metodo que nos permite registrar los registros de las metricas de los
     * paciente en el sistema.
     *
     * @param metrica
     *
     * @return
     */
    public synchronized static Resultado insert(Metrica metrica) {
        final String sql
                = """
                  SELECT ID
                  FROM SP_I_METRICA(?,?,?,?,?,?,?,?,?,?);
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, metrica.getConsulta().getId());
            ps.setBigDecimal(2, metrica.getPesoKG());
            ps.setBigDecimal(3, metrica.getEstaturaM());
            ps.setBigDecimal(4, metrica.getEscefalo());
            ps.setString(5, metrica.getEnf_detect());
            ps.setString(6, metrica.getHallazgosPositivo());
            ps.setString(7, metrica.getIdDiagnostico());
            ps.setString(8, metrica.getTx());
            ps.setString(9, metrica.getComplemento());
            ps.setString(10, Utilidades.imagenEncode64(metrica.getImagenPath()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje("Registro guardado correctamente.!!!")
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
                .mensaje("Registro cancelado.!!!")
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    
    
//------------------------------------------------------------------------------
    /**
     * Metodo que nos permite registrar los registros de las metricas de los
     * paciente en el sistema.
     *
     * @param metrica
     *
     * @return
     */
    public synchronized static Resultado udapte(Metrica metrica) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_U_METRICA(?,?,?,?,?,?,?,?,?,?);
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, metrica.getId());
            ps.setBigDecimal(2, metrica.getPesoKG());
            ps.setBigDecimal(3, metrica.getEstaturaM());
            ps.setBigDecimal(4, metrica.getEscefalo());
            ps.setString(5, metrica.getEnf_detect());
            ps.setString(6, metrica.getHallazgosPositivo());
            ps.setString(7, metrica.getIdDiagnostico());
            ps.setString(8, metrica.getTx());
            ps.setString(9, metrica.getComplemento());
            ps.setString(10, Utilidades.imagenEncode64(metrica.getImagenPath()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje("Registro guardado correctamente.!!!")
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
                .mensaje("Registro cancelado.!!!")
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    
//------------------------------------------------------------------------------
    public synchronized static Resultado delete(Metrica metrica) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_D_METRICA(?)
                  """;
        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, metrica.getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje("Registro eliminado correctamente.!!!")
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
                .mensaje("Error al eliminar el registro.!!!")
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }

//------------------------------------------------------------------------------
    public synchronized static Resultado deleteByIdConsulta(Metrica metrica) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_D_METRICA_BY_CONSULTA(?)
                  """;
        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, metrica.getConsulta().getId());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje("Registros eliminados correctamente.!!!")
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
                .mensaje("Error al eliminar los registros.!!!")
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
}
