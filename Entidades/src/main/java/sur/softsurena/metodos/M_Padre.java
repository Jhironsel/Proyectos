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
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.ARS;
import sur.softsurena.entidades.Asegurado;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Padre;
import sur.softsurena.entidades.TipoSangre;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Padre {

    /**
     * Metodo que nos devuelve los padres registrados en el sistemas.
     *
     * @param padre
     *
     * @return
     */
    public synchronized static List<Padre> getList(
            @NonNull Padre padre
    ) {

        List<Padre> listaPadre = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlGetList(padre),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaPadre.add(
                        Padre
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .id_persona(rs.getInt("ID"))
                                                .pnombre(rs.getString("PNOMBRE"))
                                                .snombre(rs.getString("SNOMBRE"))
                                                .apellidos(rs.getString("APELLIDOS"))
                                                .sexo(rs.getString("SEXO").charAt(0))
                                                .fecha_nacimiento(rs.getDate("FECHA_NACIMIENTO"))
                                                .estado(rs.getBoolean("ESTADO_PERSONA"))
                                                .generales(
                                                        Generales
                                                                .builder()
                                                                .cedula(rs.getString("CEDULA"))
                                                                .estado_civil(
                                                                        rs.getString("ESTADO_CIVIL").charAt(0)
                                                                )
                                                                .tipoSangre(
                                                                        TipoSangre
                                                                                .builder()
                                                                                .id(rs.getInt("ID_TIPO_SANGREE"))
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .build()
                                )
                                .asegurado(
                                        Asegurado
                                                .builder()
                                                .ars(
                                                        ARS
                                                                .builder()
                                                                .id(rs.getInt("ID_ARS"))
                                                                .build()
                                                )
                                                .no_nss(rs.getString("NO_NSS"))
                                                .estado(rs.getBoolean("ESTADO_SEGURO"))
                                                .build()
                                )
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
        return listaPadre;
    }

    /**
     *
     * @param padre
     * @return
     */
    protected static String sqlGetList(Padre padre) {
        Boolean criterio = Objects.isNull(padre.getPersona().getGenerales());
        Boolean estado = Objects.isNull(padre.getPersona().getEstado());
        Boolean id = Objects.isNull(padre.getPersona().getId_persona());
        Boolean where = criterio && estado && id;
        return """
               SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                    FECHA_NACIMIENTO, ESTADO_PERSONA,
                    ID_TIPO_SANGREE, CEDULA, ESTADO_CIVIL, ID_ARS,
                    NO_NSS, ESTADO_SEGURO
               FROM GET_PADRES
               %s%s%s%s
                """.trim().strip().formatted(
                where ? "" : "WHERE ",
                id ? "" : "ID = %d ".formatted(padre.getPersona().getId_persona()),
                criterio ? "" : ("CEDULA LIKE '%s' ".formatted(padre.getPersona().getGenerales())),
                estado ? "" : (padre.getPersona().getEstado() ? "ESTADO_PERSONA " : "ESTADO_PERSONA IS FALSE")
        ).trim().strip();
    }
//------------------------------------------------------------------------------

    /**
     * Metodo que permite agregar los padres al sistema pediatrico.
     *
     * @param padre
     * @return
     */
    public static Resultado insert(Padre padre) {
        final String sql
                = "SELECT O_ID FROM SP_I_PADRE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(5, padre.getPersona().getPnombre());
            ps.setString(6, padre.getPersona().getSnombre());
            ps.setString(7, padre.getPersona().getApellidos());
            ps.setString(8, "" + padre.getPersona().getSexo());
            ps.setDate(9, padre.getPersona().getFecha_nacimiento());
            ps.setBoolean(10, padre.getPersona().getEstado());

            ResultSet rs = ps.executeQuery();

            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return Resultado
                    .builder()
                    .id(id)
                    .mensaje(PADRE__AGREGADO__EXITOSAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_AGREGAR_PADRE_AL_SISTEMA,
                    ex
            );
            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL_AGREGAR_PADRE_AL_SISTEMA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }

    }
    public static final String ERROR_AL_AGREGAR_PADRE_AL_SISTEMA
            = "Error al agregar padre al sistema";
    public static final String PADRE__AGREGADO__EXITOSAMENTE
            = "Padre Agregado Exitosamente!";

    /**
     *
     * @param p
     * @return
     */
    public synchronized static Resultado update(Padre p) {
        final String sql
                = "EXECUTE PROCEDURE SP_U_PADRE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setString(6, p.getPersona().getPnombre());
            ps.setString(7, p.getPersona().getSnombre());
            ps.setString(8, p.getPersona().getApellidos());
            ps.setString(9, p.getPersona().getSexo().toString());
            ps.setDate(10, p.getPersona().getFecha_nacimiento());
            ps.setBoolean(11, p.getPersona().getEstado());

            ps.executeUpdate();
            return Resultado
                    .builder()
                    .mensaje(PADRE_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_MODIFICAR_PADRE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_PADRE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_MODIFICAR_PADRE
            = "Error al modificar padre...";
    public static final String PADRE_MODIFICADO_CORRECTAMENTE
            = "Padre modificado correctamente";

    /**
     * Metodo que elimina el registro del identificador de la tabla
     * PERSONAS_PADRES.
     *
     * @param id
     *
     * @return
     */
    public synchronized static Resultado delete(int id) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_PERSONA_PADRE (?)";

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, id);

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(BORRADO_DE_REGISTRO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_PADRE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR_PADRE
            = "Error al borrar Registro.!!!";
    public static final String BORRADO_DE_REGISTRO_CORRECTAMENTE
            = "Borrado de registro correctamente.!!!";

    /**
     * TODO CREAR VISTA.
     *
     * @param idPadre
     * @return
     */
    public static ResultSet getPadreMadres(int idPadre) {

        final String sql = "SELECT * FROM PADREMADRES WHERE documento LIKE ?";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idPadre);

            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return null;
        }
    }

    /**
     * TODO CREAR VISTA.
     *
     * @param cedula
     * @return
     */
    public static boolean validarPadreMadre(String cedula) {
        final String sql = "SELECT 1 FROM PERSONA WHERE documento like ?";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return false;
        }
    }

    /**
     *
     * @param idPadre
     * @return
     */
    public synchronized static ResultSet getPadresActivoID(int idPadre) {
        final String sql = "SELECT NOMBRES, APELLIDOS, ARS, NONSS "
                + "FROM GET_PADRES "
                + "WHERE IDPADRE = ?";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idPadre);
            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return null;
        }
    }

    /**
     *
     * @param cedula
     * @param sexo
     * @return
     */
    public synchronized static ResultSet getPadresActivo(String cedula, String sexo) {
        final String sql = "SELECT IDPADRE, CEDULA, NOMBRES, APELLIDOS "
                + "FROM GET_PADRES "
                + "WHERE ESTADO AND CEDULA STARTING WITH ? AND SEXO LIKE ?;";

        try (PreparedStatement ps = getCnn().prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
            ps.setString(1, cedula);
            ps.setString(2, sexo);
            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return null;
        }
    }

    /**
     *
     * @param estado
     * @return
     */
    public synchronized static ResultSet getPadresActivo(boolean estado) {
        final String sql = "SELECT IDPADRE, CEDULA, NOMBRES, APELLIDOS, SEXO, "
                + "IDTIPOSANGRE, TIPOSANGRE, IDARS, ARS, NONSS, "
                + "TELEFONO, MOVIL, CORREO, DIRECCION, CIUDAD, FECHANACIMIENTO, "
                + "ESTADO "
                + "FROM GET_PADRES "
                + "WHERE ESTADO IS ? and idPadre != 0";

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setBoolean(1, estado);

            return ps.executeQuery();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return null;
        }
    }

    public synchronized int getIdMadrePadre(String cedula) {
        final String sql = "SELECT IDPADRE FROM V_PADRES WHERE CEDULA LIKE ?";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, cedula);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("IDPADRE");
                } else {
                    return 0;
                }
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return -1;
    }

    public synchronized static boolean existePadre(String cedula, boolean estado) {
        final String sql = "SELECT (1) FROM V_PADRES WHERE cedula = ? and ESTADO IS ?";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, cedula);
            ps.setBoolean(2, estado);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }
}
