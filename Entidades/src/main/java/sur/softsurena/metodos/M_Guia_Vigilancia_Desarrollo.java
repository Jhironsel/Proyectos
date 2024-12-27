package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Guia_Vigilancia_Desarrollo;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Guia_Vigilancia_Desarrollo {

    public static synchronized List<Guia_Vigilancia_Desarrollo> select() {
        final String sql = """
                           SELECT ID, EDAD, CARACT_DESARR_EVALUAR
                           FROM T_GUIA_VIGILANCIA_DESARROLLO
                           """;

        List<Guia_Vigilancia_Desarrollo> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(
                        Guia_Vigilancia_Desarrollo
                                .builder()
                                .id(rs.getInt("ID"))
                                .edad(rs.getInt("EDAD"))
                                .caract_desarr_evaluar(rs.getString("CARACT_DESARR_EVALUAR"))
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
}
