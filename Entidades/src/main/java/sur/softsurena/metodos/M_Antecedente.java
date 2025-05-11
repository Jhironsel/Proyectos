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
import sur.softsurena.entidades.Antecedente;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Antecedente {

    /**
     * Es una tabla utilizada para almacenar los antecedentes de los pacientes
     * del sistema, dicho antecedente describe la condicion de los paciente en
     * el momento de la consulta.
     *
     * @param antecedente objecto que contiene identificador de la consulta, que
     * tiene registros de historico de los antecedentes.
     *
     * @return Se obtiene una lista de todos los antecendentes de los registros
     * del paciente.
     */
    public static List<Antecedente> select(
            @NonNull Antecedente antecedente
    ) {

        List<Antecedente> lista = new ArrayList<>();

        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        ); ResultSet rs = ps.executeQuery(sqlSelect(antecedente));) {

                while (rs.next()) {
                    lista.add(
                            Antecedente
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .idConsulta(rs.getInt("ID_CONSULTA"))
                                    .descripcion(rs.getString("Descripcion"))
                                    .build()
                    );
                }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar la vista V_ANTECEDENTES del sistema.",
                    ex
            );
        }
        return lista;
    }

    protected static String sqlSelect(Antecedente antecedente) {
        Boolean id = Objects.isNull(antecedente.getId());
        Boolean id_consulta = Objects.isNull(antecedente.getIdConsulta());
        Boolean where = id && id_consulta;
        Boolean and = id || id_consulta;
        final String sql = """
                           SELECT ID, ID_CONSULTA, DESCRIPCION 
                           FROM V_ANTECEDENTES
                           %s%s%s%s
                           """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(antecedente.getId()),
                and ? "" : "AND ",
                id_consulta ? "" : "ID_CONSULTA = %d ".formatted(antecedente.getIdConsulta())
        );
        return sql.trim().strip();
    }

//------------------------------------------------------------------------------
    /**
     * Metodo que permite agregar los antecendentes de los pacientes del
     * sistema.
     *
     * Los antecedentes son aquellos que el paciente a tenido antes de la
     * consulta programada.
     *
     * @param antecedente objeto que contiene el identificador de la consulta de
     * dicha consulta, tambien una pequeña descripcion del antecendete que el
     * paciente padeció antes de la consulta.
     *
     * @return retorna una cadena o mensaje con la accion realizada por el
     * sistema.
     */
    public static Resultado insert(
            @NonNull Antecedente antecedente
    ) {
        final String sql
                = "SELECT O_ID FROM SP_I_ANTECEDENTE (?, ?);";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, antecedente.getIdConsulta());
            ps.setString(2, antecedente.getDescripcion());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("O_ID"))
                        .mensaje(ANTECEDENTE_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR__ANTECEDENTES,
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .mensaje(ERROR_AL_INSERTAR__ANTECEDENTES)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ANTECEDENTE_AGREGADO_CORRECTAMENTE
            = "Antecedente agregado correctamente";
    public static final String ERROR_AL_INSERTAR__ANTECEDENTES
            = "Error al insertar Antecedentes...";

    /**
     * Metodo que permite actualizar los antecendente de un paciente. Se utiliza
     * el identificador del antecedente para ser actualizado.
     *
     * @param antecedente objecto que contiene el identificador del registro y
     * la descripcion del antecedente del paciente.
     *
     * @return
     */
    public static Resultado update(
            @NonNull Antecedente antecedente
    ) {
        final String sql = "EXECUTE PROCEDURE SP_U_ANTECEDENTE(?, ?);";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, antecedente.getId());
            ps.setString(2, antecedente.getDescripcion());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(ANTECEDENTE_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_MODIFICAR_ANTECEDENTE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_ANTECEDENTE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ANTECEDENTE_MODIFICADO_CORRECTAMENTE
            = "Antecedente modificado correctamente";
    public static final String ERROR_AL_MODIFICAR_ANTECEDENTE
            = "Error al modificar el antecendete...";

    /**
     * Permite eliminar un antecedente registrado previamente del sistema.
     *
     * @param antecedente contiene el identificador de la consulta a borrar.
     *
     * @return
     */
    public static Resultado delete(
            @NonNull Antecedente antecedente
    ) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_ANTECEDENTE(?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, antecedente.getId());

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
                    ERROR_AL_BORRAR_PACIENTE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_PACIENTE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String BORRADO_CORRECTAMENTE
            = "Antecendente borrado correctamente";
    public static final String ERROR_AL_BORRAR_PACIENTE
            = "Error al borrar paciente...";
}
