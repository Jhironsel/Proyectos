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
import sur.softsurena.entidades.Estudiante;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Estudiante {

    /**
     *
     * @param estudiante
     *
     * @return
     */
    public synchronized static List<Estudiante> select(
            @NonNull Estudiante estudiante
    ) {

        List<Estudiante> listaEstudiante = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(estudiante),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaEstudiante.add(
                        Estudiante
                                .builder()
                                .id(rs.getInt("ID"))
                                .matricula(rs.getString("MATRICULA"))
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
        return listaEstudiante;
    }

    protected static String sqlSelect(Estudiante estudiante) {
        Boolean matricula = Objects.isNull(estudiante.getMatricula());
        return """
               SELECT ID, MATRICULA
               FROM V_PERSONAS_ESTUDIANTES_ATR
               %s
               """.formatted(
                matricula
                        ? ""
                        : "WHERE MATRICULA STARTING WITH '%s' "
                                .formatted(
                                        estudiante.getMatricula()
                                )
        ).strip();
    }

//------------------------------------------------------------------------------
    /**
     * Metodo que permite agregar un estudiante al sistema de ballet, el cual
     * ejecuta un procedimiento almacenado en la base de datos.
     *
     * Procedimiento almacenado que permite registro de estudiantes al sistema.
     *
     * @param estudiante Objecto de la clase estudiante que capsula los
     * atributos de un estudiantes.
     *
     * @return Retorna un mensaje que indica si el estudiantes ha sido
     * registrado si o no.
     */
    public synchronized static Resultado insert(
            Estudiante estudiante
    ) {
        try (CallableStatement cs = getCnn().prepareCall(
                "EXECUTE PROCEDURE SP_I_PERSONA_ESTUDIANTE(?,?)",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, estudiante.getId());
            cs.setString(2, estudiante.getMatricula());

            cs.execute();

            return Resultado
                    .builder()
                    .mensaje(ESTUDIANTE__AGREGADO__CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_AGREGAR__ESTUDIANTE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_AGREGAR__ESTUDIANTE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }

    public static final String ERROR_AL_AGREGAR__ESTUDIANTE
            = "Error al agregar Estudiante.";
    public static final String ESTUDIANTE__AGREGADO__CORRECTAMENTE
            = "Estudiante Agregado Correctamente.";

    /**
     * Metodo que permite modificar las matriculas de los estudiantes.
     *
     * @param estudiante
     * @return
     */
    public synchronized static Resultado update(
            Estudiante estudiante
    ) {
        try (PreparedStatement ps = getCnn().prepareStatement(
                "EXECUTE PROCEDURE SP_U_PERSONA_ESTUDIANTE (?, ?)",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, estudiante.getId());
            ps.setString(2, estudiante.getMatricula());

            ps.executeUpdate();
            return Resultado
                    .builder()
                    .mensaje(ESTUDIANTE__MODIFICADO__CORRECTAMENTE)
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
                    .mensaje(ESTUDIANTE_NO_PUDO_SER__MODIFICADO__CONCTAT)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }

    public static final String ESTUDIANTE_NO_PUDO_SER__MODIFICADO__CONCTAT
            = "Estudiante no pudo ser Modificado, Conctate SoftSureña...!!!";
    public static final String ESTUDIANTE__MODIFICADO__CORRECTAMENTE
            = "Estudiante Modificado Correctamente...!!!";

    /**
     *
     * @param estudiante
     * @return
     */
    public synchronized static Resultado delete(
            Estudiante estudiante
    ) {

        try (PreparedStatement ps = getCnn().prepareStatement(
                "EXECUTE PROCEDURE SP_D_PERSONA_ESTUDIANTE(?);",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, estudiante.getId());

            ps.executeUpdate();
            
            return Resultado
                    .builder()
                    .mensaje("Estudiante borrado correctamente.!!")
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
                    .mensaje("Error al eliminar el estudiante.")
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
}
