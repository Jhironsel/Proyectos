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
import sur.softsurena.entidades.FotoCategoria;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * Clase encargada de gestionar las imagenes de las categorias del sistema.
 *
 * @author jhironsel
 */
public class M_Foto_Categoria {

    public static List<FotoCategoria> select(
            @NonNull FotoCategoria fotoCategori
    ) {

        List<FotoCategoria> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(fotoCategori),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        FotoCategoria
                                .builder()
                                .id(rs.getInt("ID"))
                                .idCategoria(rs.getInt("ID_CATEGORIA"))
                                .foto(rs.getString("FOTO"))
                                .fechaHoraCreacion(rs.getTimestamp("FECHA_HORA_CREACION"))
                                .actual(rs.getBoolean("ACTUAL"))
                                .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar la foto de la categoria.",
                    ex
            );
        }

        return lista;
    }

    protected static String sqlSelect(FotoCategoria fotoCategoria) {
        Boolean id = Objects.isNull(fotoCategoria.getId());
        Boolean id_categoria = Objects.isNull(fotoCategoria.getIdCategoria());

        Boolean where = id && id_categoria;
        return """
               SELECT ID, ID_CATEGORIA, FOTO, FECHA_HORA_CREACION, ACTUAL
               FROM V_FOTO_CATEGORIA
               %s%s%s
               """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(fotoCategoria.getId()),
                id_categoria ? "" : "ID_CATEGORIA = %d ".formatted(
                                fotoCategoria.getIdCategoria()
                        )
        ).trim().strip();
    }

//------------------------------------------------------------------------------
    public static Resultado insert(
            @NonNull FotoCategoria fotoCategoria
    ) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_FOTO_CATEGORIA(?,?,?)
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, fotoCategoria.getIdCategoria());
            ps.setString(2, fotoCategoria.getFoto());
            ps.setBoolean(3, fotoCategoria.getActual());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje(REGISTRO_REALIZADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ERROR_AL_INSERTAR_LA_FOTO_DE_LA_CATEGORIA,
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .mensaje(ERROR_AL_INSERTAR_LA_FOTO_DE_LA_CATEGORIA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_INSERTAR_LA_FOTO_DE_LA_CATEGORIA
            = "Error al insertar la foto de la categoria.";
    private static final String REGISTRO_REALIZADO_CORRECTAMENTE
            = "Registro realizado correctamente.!!!";
//------------------------------------------------------------------------------

    public static Resultado update(
            @NonNull FotoCategoria fotoCategoria
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_FOTO_CATEGORIA(?,?,?,?)
                           """;

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            cs.setInt(1, fotoCategoria.getId());
            cs.setInt(2, fotoCategoria.getIdCategoria());
            cs.setString(3, fotoCategoria.getFoto());
            cs.setBoolean(4, fotoCategoria.getActual());

            return Resultado
                    .builder()
                    .mensaje("Categoria actualizada del sistema.")
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ERROR_AL_ACTUALIZAR_LA_FOTO_DE_LA_CATEGOR,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_ACTUALIZAR_LA_FOTO_DE_LA_CATEGOR)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_ACTUALIZAR_LA_FOTO_DE_LA_CATEGOR
            = "Error al actualizar la foto de la categoria.";

//------------------------------------------------------------------------------
    public static Resultado delete(
            @NonNull FotoCategoria fotoCategoria
    ) {

        final String sql = """
                           EXECUTE PROCEDURE SP_D_FOTO_CATEGORIA(?)
                           """;

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, fotoCategoria.getId());

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje("Registro eliminado del sistema.")
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_LA_FOTO_DE_LA_CATEGORIA,
                    ex
            );
        }

        return Resultado
                .builder()
                .mensaje(ERROR_AL_ELIMINAR_LA_FOTO_DE_LA_CATEGORIA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_ELIMINAR_LA_FOTO_DE_LA_CATEGORIA
            = "Error al eliminar la foto de la categoria.";

//------------------------------------------------------------------------------
    public static Resultado deleteById_categoria(
            @NonNull FotoCategoria fotoCategoria
    ) {

        final String sql = """
                           EXECUTE PROCEDURE SP_D_FOTO_CATEGORIA_BY_ID_CATEGORIA(?)
                           """;

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, fotoCategoria.getIdCategoria());

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(CATEGORIAS_ELIMINADAS_DEL_SISTEMA)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_LAS_FOTOS_DE_LAS_CATEGO,
                    ex
            );
        }

        return Resultado
                .builder()
                .mensaje(ERROR_AL_ELIMINAR_LAS_FOTOS_DE_LAS_CATEGO)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_ELIMINAR_LAS_FOTOS_DE_LAS_CATEGO
            = "Error al eliminar las fotos de las categorias.";
    public static final String CATEGORIAS_ELIMINADAS_DEL_SISTEMA
            = "Categorias eliminadas del sistema.";

}
