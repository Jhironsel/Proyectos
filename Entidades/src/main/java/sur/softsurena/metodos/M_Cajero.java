package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import sur.softsurena.entidades.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Cajero;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Cajero {

    /**
     * Metodo que devuelve una lista de atributos de los usuarios del sistema.
     *
     * @return El valor devuelto de este metodo es una lista de atributos de los
     * usuarios del sistema.
     */
    public static List<Cajero> select() {
        List<Cajero> cajerosList = new ArrayList<>();

        final String SELECT
                = """
                  SELECT USER_NAME, ROL, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO, DESCRIPCION
                  FROM GET_CAJEROS;
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                SELECT,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {

            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    cajerosList.add(
                            Cajero
                                    .builder()
                                    .usuario(
                                            Usuario
                                                    .builder()
                                                    .userName(rs.getString("USER_NAME"))
                                                    .persona(
                                                            Persona
                                                                    .builder()
                                                                    
                                                                    .rol(rs.getString("ROL"))
                                                                    .pnombre(rs.getString("PNOMBRE"))
                                                                    .snombre(rs.getString("SNOMBRE"))
                                                                    .apellidos(rs.getString("APELLIDOS"))
                                                                    .estado(rs.getBoolean("ESTADO"))
                                                                    .build()
                                                    )
                                                    .descripcion(rs.getString("DESCRIPCION"))
                                                    .build()
                                    )
                                    .build());
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_LA_VISTA_DE_GET_CAJERO,
                    ex
            );
        }

        return cajerosList;
    }
    public static final String ERROR_AL_CONSULTAR_LA_VISTA_DE_GET_CAJERO
            = "Error al consultar la vista de GET_CAJEROS.";
}
