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
import sur.softsurena.entidades.FotoProducto;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * Clase encargada de gestionar las imagenes de la personas en el sistema.
 *
 * @author jhironsel
 */
public class M_Foto_Producto {

    public static List<FotoProducto> select(
            @NonNull FotoProducto fotoPersona
    ) {

        List<FotoProducto> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(fotoPersona),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        FotoProducto
                                .builder()
                                .id(rs.getInt("ID"))
                                .idProducto(rs.getInt("ID_PERSONA"))
                                .foto(rs.getString("FOTO"))
                                .fechaHoraCreacion(rs.getTimestamp("FECHA_HORA_CREACION"))
                                .actual(rs.getBoolean("ACTUAL"))
                                .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar la foto de la persona.",
                    ex
            );
        }

        return lista;
    }

    protected static String sqlSelect(FotoProducto fotoProducto) {
        boolean id = Objects.isNull(fotoProducto.getId());
        boolean id_persona = Objects.isNull(fotoProducto.getIdProducto());
        boolean where = id && id_persona;
        return """
               SELECT ID, ID_PRODUCTO, FOTO, FECHA_HORA_CREACION, ACTUAL
               FROM V_FOTO_PRODUCTO
               %s%s%s
               """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(fotoProducto.getId()),
                id_persona ? "" : "ID_PRODUCTO = %d ".formatted(
                        fotoProducto.getIdProducto()
                )
        ).trim().strip();
    }
    
//------------------------------------------------------------------------------
    public static Resultado insert(
            @NonNull FotoProducto fotoPersona
    ) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_FOTO_PRODUCTO(?,?,?)
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, fotoPersona.getIdProducto());
            ps.setString(2, fotoPersona.getFoto());
            ps.setBoolean(3, fotoPersona.getActual());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje("Registro realizado correctamente.!!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }
            
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al insertar la foto de la persona.",
                    ex
            );
        }
        return Resultado
                        .builder()
                        .id(-1)
                        .mensaje("Error al realizar Registro.!!!")
                        .icono(JOptionPane.ERROR_MESSAGE)
                        .estado(Boolean.FALSE)
                        .build();
    }
//------------------------------------------------------------------------------
    public static Resultado update(
            @NonNull FotoProducto fotoPersona
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_FOTO_PRODUCTO(?,?,?,?)
                           """;
        
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            cs.setInt(1, fotoPersona.getId());
            cs.setInt(2, fotoPersona.getIdProducto());
            cs.setString(3, fotoPersona.getFoto());
            cs.setBoolean(4, fotoPersona.getActual());
            
            return Resultado
                    .builder()
                    .mensaje("Registro actualizado del sistema.")
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ACTUALIZAR_LA_FOTO_DE_LA_PERSONA,
                    ex
            );
        }
        return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ACTUALIZAR_LA_FOTO_DE_LA_PERSONA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
    }
    
    public static final String ERROR_AL_ACTUALIZAR_LA_FOTO_DE_LA_PERSONA
            = "Error al actualizar la foto de la persona.";
    
//------------------------------------------------------------------------------
    public static Resultado delete(
            @NonNull FotoProducto fotoPersona
    ) {
        
        final String sql = """
                           EXECUTE PROCEDURE SP_D_FOTO_PRODUCTO(?)
                           """;
        
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, fotoPersona.getId());
            
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
                    ERROR_AL_ELIMINAR_LA_FOTO_DE_LA_PERSONA,
                    ex
            );
        }
        
        return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_LA_FOTO_DE_LA_PERSONA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
    }
    public static final String ERROR_AL_ELIMINAR_LA_FOTO_DE_LA_PERSONA
            = "Error al eliminar la foto de la persona.";
    
//------------------------------------------------------------------------------
    public static Resultado deleteById_persona(
            @NonNull FotoProducto fotoPersona
    ) {
        
        final String sql = """
                           EXECUTE PROCEDURE SP_D_FOTO_PRODUCTO_BY_ID_PRODUCTO(?)
                           """;
        
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, fotoPersona.getIdProducto());
            
            cs.executeUpdate();
            
            return Resultado
                    .builder()
                    .mensaje("Registros eliminados del sistema.")
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ELIMINAR_LAS_FOTOS_DE_LA_PERSONA,
                    ex
            );
        }
        
        return Resultado
                    .builder()
                    .mensaje(ERROR_AL_ELIMINAR_LAS_FOTOS_DE_LA_PERSONA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
    }
    public static final String ERROR_AL_ELIMINAR_LAS_FOTOS_DE_LA_PERSONA
            = "Error al eliminar las fotos de la persona.";

}
