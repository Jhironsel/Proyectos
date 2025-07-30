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
import sur.softsurena.entidades.Provincia;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Provincia {

    /**
     * Metodo que me trae un conjunto de datos de las provincias del pais.
     *
     * @param provincia
     * @nota Metodo creado el dia 16 de agosto 2022.
     *
     * @return retorna un conjunto de datos encapsulados en un ResultSet.
     */
    public static List<Provincia> select(
            @NonNull Provincia provincia
    ) {
        List<Provincia> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(provincia),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(
                        Provincia
                                .builder()
                                .id(rs.getInt("ID"))
                                .nombre(rs.getString("NOMBRE"))
                                .zona(rs.getString("ZONA"))
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

    protected static String sqlSelect(Provincia provincia) {
        boolean id = Objects.isNull(provincia.getId());
        return """
               SELECT ID, NOMBRE, ZONA
               FROM V_T_PROVINCIAS
               %s
               """.formatted(
                id ? "" : "WHERE ID = %d ".formatted(provincia.getId())
        ).strip();
    }
//------------------------------------------------------------------------------
}
