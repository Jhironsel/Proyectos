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
import sur.softsurena.entidades.FotoPersona;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 * Clase encargada de gestionar las imagenes de la personas en el sistema.
 *
 * @author jhironsel
 */
public class M_Foto_Persona {

    public static List<FotoPersona> select(
            @NonNull FotoPersona fotoPersona
    ) {

        List<FotoPersona> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(fotoPersona),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(
                        FotoPersona
                                .builder()
                                .id(rs.getInt("ID"))
                                .idPersona(rs.getInt("ID_PERSONA"))
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

    protected static String sqlSelect(FotoPersona fotoPersona) {
        Boolean id = Objects.isNull(fotoPersona.getId());
        Boolean id_persona = Objects.isNull(fotoPersona.getIdPersona());
        Boolean where = id && id_persona;
        Boolean and = !id && !id_persona;
        return """
               SELECT ID, ID_PERSONA, FOTO, FECHA_HORA_CREACION, ACTUAL
               FROM V_FOTO_PERSONA
               %s%s%s%s
               """.formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(fotoPersona.getId()),
                and ? "AND " : "",
                id_persona ? "" : "ID_PERSONA = %d ".formatted(fotoPersona.getIdPersona())
        ).trim().strip();
    }
    
//------------------------------------------------------------------------------
    public static Resultado insert(
            @NonNull FotoPersona fotoPersona
    ) {
        final String sql = """
                           SELECT ID
                           FROM SP_I_FOTO_PERSONA(?,?,?)
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, fotoPersona.getIdPersona());
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
            @NonNull FotoPersona fotoPersona
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_FOTO_PERSONA(?,?,?,?)
                           """;
        
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            
            cs.setInt(1, fotoPersona.getId());
            cs.setInt(2, fotoPersona.getIdPersona());
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
            @NonNull FotoPersona fotoPersona
    ) {
        
        final String sql = """
                           EXECUTE PROCEDURE SP_D_FOTO_PERSONA(?)
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
            @NonNull FotoPersona fotoPersona
    ) {
        
        final String sql = """
                           EXECUTE PROCEDURE SP_D_FOTO_PERSONA_BY_ID_PERSONA(?)
                           """;
        
        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, fotoPersona.getIdPersona());
            
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
