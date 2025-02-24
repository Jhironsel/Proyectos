package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.ContactoDireccion;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_ContactoDireccion {

    /**
     * Metodo utilizado para agregar una lista de direcciones del cliente al
     * sistema.
     *
     * @param direccion Objecto de la clase direccion de una persona.
     *
     * @return Devuelve true si la operacion fue exitosa, false caso contrario.
     */
    public static synchronized Resultado agregarDireccion(ContactoDireccion direccion) {
        final String sql
                = "SELECT O_ID FROM SP_I_CONTACTO_DIRECCION(?,?,?,?,?,?,?);";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ps.setInt(1, direccion.getIdPersona());
            ps.setInt(2, direccion.getIdProvincia());
            ps.setInt(3, direccion.getIdMunicipio());
            ps.setInt(4, direccion.getIdDistritoMunicipal());
            ps.setInt(
                    5,
                    Objects.isNull(direccion.getIdCodigoPostal())
                    ? 0 : (int) direccion.getIdCodigoPostal()
            );
            ps.setString(6, direccion.getDireccion());
            ps.setBoolean(7, direccion.getPorDefecto());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt(1))
                        .mensaje(DIRECCION_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE,
                    ERROR_AL_INSERTAR_DIRECCION,
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .mensaje(ERROR_AL_INSERTAR_DIRECCION)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_INSERTAR_DIRECCION
            = "Error al insertar direccion.";
    public static final String DIRECCION_AGREGADA_CORRECTAMENTE
            = "Direccion agregada o modificada correctamente.";

    /**
     * Obtenemos el historia de direcciones del cliente, lo cual permite tener
     * mejor control de la direcciones de los clientes.
     *
     * @param idPersona identificador del cliente del sistema, la cual ayuda
     * obtener los registros de un usuario en expecifico.
     *
     * Consulta utilizada para obtener la direccion de una persona en
     * particular.
     *
     * @return Retorna un conjunto de datos del tipo resultSet.
     */
    public synchronized static List<ContactoDireccion> selectByID(Integer idPersona) {
        final String sql = """
                           SELECT ID, ID_PERSONA, ID_PROVINCIA, ID_MUNICIPIO, 
                                ID_DISTRITO_MUNICIPAL, ID_CODIGO_POSTAL, 
                                DIRECCION, FECHA, ESTADO, POR_DEFECTO
                           FROM V_CONTACTOS_DIRECCIONES
                           %s
                           """.formatted(
                                   (Objects.isNull(idPersona) ? "ROWS (10);" : "WHERE ID_PERSONA = ?;")
                           );

        List<ContactoDireccion> direcciones = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            if (!Objects.isNull(idPersona)) {
                ps.setInt(1, idPersona);
            }
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    direcciones.add(
                            ContactoDireccion
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .idProvincia(rs.getInt("ID_PROVINCIA"))
                                    .idMunicipio(rs.getInt("ID_MUNICIPIO"))
                                    .idDistritoMunicipal(rs.getInt("ID_DISTRITO_MUNICIPAL"))
                                    .idCodigoPostal(rs.getInt("ID_CODIGO_POSTAL"))
                                    .direccion(rs.getString("DIRECCION"))
                                    .fecha(rs.getDate("FECHA"))
                                    .estado(rs.getBoolean("ESTADO"))
                                    .porDefecto(rs.getBoolean("POR_DEFECTO"))
                                    .build()
                    );
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_REALIZAR_LA_CONSULTA_EN_LA_VISTA,
                    ex
            );
        }
        return direcciones;
    }
    public static final String ERROR_AL_REALIZAR_LA_CONSULTA_EN_LA_VISTA
            = "Error al realizar la consulta en la vista GET_DIRECCION_BY_ID.";

    public synchronized static Resultado borrarDireccion(int id_direccion) {
        String sql = """
                     EXECUTE PROCEDURE SP_D_CONTACTO_DIRECCION (?);
                     """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, id_direccion);

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI
            = "Error al borrar el registro de la direccion.";
    public static final String REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA
            = "Registro de la direccion borrado correctamente.";

    public static synchronized Resultado modificarDireccion(
            ContactoDireccion direccion
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_CONTACTO_DIRECCION
                                (?,?,?,?,?,?,?,?,?);
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, direccion.getId());
            ps.setInt(2, direccion.getIdPersona());
            ps.setInt(3, direccion.getIdProvincia());
            ps.setInt(4, direccion.getIdMunicipio());
            ps.setInt(5, direccion.getIdDistritoMunicipal());
            ps.setInt(6, direccion.getIdCodigoPostal());
            ps.setString(7, direccion.getDireccion());
            ps.setBoolean(8, direccion.getEstado());
            ps.setBoolean(9, direccion.getPorDefecto());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(DIRECCION_DE_CONTACTO_ACTUALIZADA_CORRECT)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ACTUALIZAR_LA_DIRECCION_DEL_CONT,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_ACTUALIZAR_LA_DIRECCION_DEL_CONT)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();

    }
    public static final String DIRECCION_DE_CONTACTO_ACTUALIZADA_CORRECT
            = "Direccion de contacto actualizada correctamente.";
    public static final String ERROR_AL_ACTUALIZAR_LA_DIRECCION_DEL_CONT
            = "Error al actualizar la direccion del contacto.";
}
