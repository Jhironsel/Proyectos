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
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Horario;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Horario {
    
    public static List<Horario> select(Horario horario){
        //TODO 18.04.2025 queda pendiente crear paginacion a este select.
        List<Horario> lista = new ArrayList<>();
        
        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery(sqlSelect(horario));
            while (rs.next()) {
                lista.add(
                        Horario
                                .builder()
                                .id(rs.getInt("ID"))
                                .descripcion(rs.getString("DESCRIPCION"))
                                .hora(rs.getTime("HORA"))
                                .tolerancia(rs.getInt("TOLERANCIA"))
                                .estado(rs.getBoolean("ESTADO"))
                                .build()
                );
            }
        }catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        
        return lista;
    }
    
    public static String sqlSelect(Horario horario){
        boolean id = Objects.isNull(horario.getId());
        boolean descripcion = Objects.isNull(horario.getDescripcion());
        boolean estado = Objects.isNull(horario.getEstado());
        
        boolean where = id && descripcion && estado;
        return """
               SELECT ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO
               FROM HORARIOS
               %s%s%s%s
               """.formatted(
                       where ? "":"WHERE ",
                       id ? "":"ID = %d ".formatted(horario.getId()),
                       descripcion ? "":"DESCRIPCION STARTING WITH '%s' ".formatted(horario.getDescripcion()),
                       estado ? "": horario.getEstado() ? "ESTADO":"ESTADO IS FALSE"
               ).strip();
    }
//------------------------------------------------------------------------------
    
    public static Resultado insert(Horario horario) {
        final String sql = """
                           SELECT ID FROM SP_I_HORARIO(?,?,?,?);
                           """;
        try (PreparedStatement st = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            st.setString(1, horario.getDescripcion());
            st.setTime(2, horario.getHora());
            st.setInt(3, horario.getTolerancia());
            st.setBoolean(4, horario.getEstado());

            var rs = st.executeQuery();
            rs.first();
            return Resultado
                    .builder()
                    .id(rs.getInt("ID"))
                    .mensaje(AGREGADO__CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_INSERTAR)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_INSERTAR
            = "Error al insertar Horario al sistema.";
    public static final String AGREGADO__CORRECTAMENTE
            = "Horario Agregado Correctamente.!!!";
//------------------------------------------------------------------------------
    public static Resultado delete(Horario horario) {
        final String sql = """
                           EXECUTE PROCEDURE SP_D_HORARIO (?);
                           """;
        try (PreparedStatement st = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            st.setInt(1, horario.getId());
            st.executeUpdate();
            
            return Resultado
                    .builder()
                    .mensaje(HORARIO_ELIMINADO__CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_HORARIO,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_HORARIO)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_ELIMINAR_HORARIO
            = "Error al eliminar Horario al sistema.";
    public static final String HORARIO_ELIMINADO__CORRECTAMENTE
            = "Horario Eliminado Correctamente.!!!";
//------------------------------------------------------------------------------
    
}
