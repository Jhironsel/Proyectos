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
import sur.softsurena.entidades.DistritoMunicipal;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_DistritoMunicipal {

    /**
     * Metodo que me trae un conjunto de datos de los Distritos Municipales del
     * pais.
     *
     * @param distritoMunicipal
     * 
     * @nota Metodo creado el dia 16 de agosto 2022.
     *
     * @return
     */
    public synchronized static List<DistritoMunicipal> select(
            @NonNull DistritoMunicipal distritoMunicipal
    ) {

        List< DistritoMunicipal> distritos_municipaleses_list = new ArrayList<>();

        try (PreparedStatement ps1 = getCnn().prepareStatement(
                sqlSelect(distritoMunicipal),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {


            ResultSet rs = ps1.executeQuery();

            while (rs.next()) {
                distritos_municipaleses_list.add(DistritoMunicipal
                        .builder()
                        .id(rs.getInt("id"))
                        .nombre(rs.getString("nombre"))
                        .idMunicipio(rs.getInt("ID_MUNICIPIO"))
                        .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSUTAR_LA_VISTA_V_DISTRITOS_MU,
                    ex
            );
        }

        return distritos_municipaleses_list;
    }

    public static final String ERROR_AL_CONSUTAR_LA_VISTA_V_DISTRITOS_MU
            = "Error al consutar la vista V_DISTRITOS_MUNICIPALES.";

    protected static String sqlSelect(DistritoMunicipal distritoMunicipal) {
        Boolean id = Objects.isNull(distritoMunicipal.getId());
        Boolean idMunicipio = Objects.isNull(distritoMunicipal.getIdMunicipio());
        Boolean where = id && idMunicipio;
        Boolean or = id || idMunicipio;
        return """
               SELECT ID, ID_MUNICIPIO, NOMBRE
               FROM V_T_DISTRITOS_MUNICIPALES
               %s%s%s%s
               """.strip().formatted(
                       where ? "":"WHERE ",
                       id ? "":"ID IN(0, %d) ".formatted(distritoMunicipal.getId()),
                       or ? "":"OR ",
                       idMunicipio ? "":"ID_MUNICIPIO = %d ".formatted(distritoMunicipal.getIdMunicipio())
               ).strip().concat("\nORDER BY 1;");
    }
}
