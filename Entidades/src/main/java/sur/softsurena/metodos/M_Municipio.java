package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Municipio;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Municipio {

    /**
     * Metodo que me trae un conjunto de datos de los municipios del pais.
     *
     * @param municipio
     * 
     * @nota Metodo creado el dia 16 de agosto 2022.
     *
     * @return retorna un conjunto de datos encapsulados en un ResultSet.
     */
    public synchronized static List<Municipio> select(
            @NonNull Municipio municipio
    ) {
        List<Municipio> municipioList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(municipio),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    municipioList.add(
                            Municipio
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .idProvincia(rs.getInt("ID_PROVINCIA"))
                                    .nombre(rs.getString("NOMBRE"))
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
        return municipioList;
    }

    protected static String sqlSelect(Municipio municipio) {
        Boolean id = Objects.isNull(municipio.getId());
        Boolean idProvincia = Objects.isNull(municipio.getIdProvincia());
        Boolean where = id && idProvincia;
        Boolean or = id || idProvincia;
        return """
               SELECT ID, ID_PROVINCIA, NOMBRE
               FROM V_T_MUNICIPIOS
               %s%s%s%s
               """.formatted(
                       where ? "":"WHERE ",
                       id ? "":"ID IN(0, %d) ".formatted(municipio.getId()),
                       or ? "":"OR ",
                       idProvincia ? "":"ID_PROVINCIA = %d ".formatted(
                               municipio.getIdProvincia()
                       )
               ).strip().concat("\nORDER BY 1;");
    }

    
}
