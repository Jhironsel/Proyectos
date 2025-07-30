package sur.softsurena.metodos;

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
import sur.softsurena.entidades.M_Factura;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_M_Factura {

    public synchronized static Integer getIDFacturaNueva(int idTurno) {
        final String sql = """
                           SELECT ID_FACTURA
                           FROM ADMIN_GET_ID_FACTURA_NUEVA (?)
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idTurno);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID_FACTURA");
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA,
                    ex
            );
        }
        return -1;
    }

    /**
     * Para obtener las facturas temporales del sistema.
     *
     * @param factura
     * @return
     */
    public synchronized static List<M_Factura> select(
            @NonNull M_Factura factura
    ) {

        List<M_Factura> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(factura),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    lista.add(
                            M_Factura
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .idCliente(rs.getInt("ID_CLIENTE"))
                                    .idContactoTel(rs.getInt("ID_CONTACTOS_TEL"))
                                    .idContactoDir(rs.getInt("ID_CONTACTOS_DIRECCIONES"))
                                    .idContactoEmail(rs.getInt("ID_CONTACTOS_EMAIL"))
                                    .idTurno(rs.getInt("ID_TURNO"))
                                    .fechaHora(rs.getTimestamp("FECHA_HORA"))
                                    .estadoFactura(rs.getString("ESTADO_FACTURA").charAt(0))
                                    .nombreTemporal(rs.getString("NOMBRE_TEMP"))
                                    .build()
                    );
                }
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar la vista GET_TEMPORALES del sistema.",
                    ex
            );
        }
        return lista;
    }

    protected static String sqlSelect(M_Factura factura) {
        boolean id = Objects.isNull(factura.getId());
        boolean idCliente = Objects.isNull(factura.getIdCliente());
        boolean idContactoTel = Objects.isNull(factura.getIdContactoTel());
        boolean idContactoDir = Objects.isNull(factura.getIdContactoDir());
        boolean idContactoEmail = Objects.isNull(factura.getIdContactoEmail());
        boolean idTurno = Objects.isNull(factura.getIdTurno());
        boolean estado = Objects.isNull(factura.getEstadoFactura());
        boolean where = id && idCliente && idContactoTel && idContactoDir
                && idContactoEmail && idTurno && estado;

        return """
               SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                    ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA,
                    NOMBRE_TEMP
               FROM V_M_FACTURAS
               %s%s%s%s%s%s%s%s
               """.formatted(
                where
                        ? ""
                        : "WHERE ",
                id
                        ? ""
                        : "ID = %d ".formatted(factura.getId()),
                idCliente
                        ? ""
                        : "ID_CLIENTE = %d ".formatted(factura.getIdCliente()),
                idContactoTel
                        ? ""
                        : "ID_CONTACTOS_TEL = %d ".formatted(factura.getIdContactoTel()),
                idContactoDir
                        ? ""
                        : "ID_CONTACTOS_DIRECCIONES = %d ".formatted(factura.getIdContactoDir()),
                idContactoEmail
                        ? ""
                        : "ID_CONTACTOS_EMAIL = %d ".formatted(factura.getIdContactoEmail()),
                idTurno
                        ? ""
                        : "ID_TURNO = %d ".formatted(factura.getIdTurno()),
                estado
                        ? ""
                        : "ESTADO_FACTURA = '%c' ".formatted(
                                factura.getEstadoFactura()
                        )
        ).strip();
    }

//------------------------------------------------------------------------------
    /**
     * Metodo para agregar las facturas al temporar del sistema.
     *
     * Este metodo fue actualizado el dia 24 abril del 2022. Este metodo fue
     * actualizado el 19 05 2022: Se agrego un parametro al Insert que le
     * faltaba.
     *
     * @param factura Un objecto de Factura que recibe la funcion.
     * @return Retorna un valor booleando que indica si la factura fue inserta
     * true y false si hubo un error.
     */
    public synchronized static Resultado insert(M_Factura factura) {
        final String sql
                = """
                  SELECT ID
                  FROM SP_I_M_FACTURA(?,?,?,?,?,?,?)
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, factura.getIdCliente());
            ps.setInt(2, factura.getIdContactoTel());
            ps.setInt(3, factura.getIdContactoDir());
            ps.setInt(4, factura.getIdContactoEmail());
            ps.setInt(5, factura.getIdTurno());
            ps.setString(6,
                    String.valueOf(
                            factura.getEstadoFactura()
                    )
            );
            ps.setString(7, factura.getNombreTemporal());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .mensaje(FACTURA_INGRESADA_CORRECTAMENTE_AL_SISTEM)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA,
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .mensaje(ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();

    }
    public static final String FACTURA_INGRESADA_CORRECTAMENTE_AL_SISTEM
            = "Factura ingresada correctamente al sistema.";
    public static final String ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA
            = "Error al insertar factura al sistema.";

    /**
     * Metodo que permite modificar las facturas que se encuentran en el sistema
     *
     * @param factura Objeto de la clase Factura.
     *
     * @return retorna true si fue modificada y false si hubo un error en la
     * modificacion de la factura.
     */
    public synchronized static Resultado update(M_Factura factura) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_U_FACTURA (
                        ?, --ID
                        ?, --ID_CONTACTOS_TEL
                        ?, --ID_CONTACTOS_DIRECCIONES
                        ?, --ID_CONTACTOS_EMAIL
                        ?, --ID_TURNO
                        ?, --ESTADO_FACTURA
                        ?  --NOMBRE_TEMP
                  );
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, factura.getId());
            ps.setInt(2, factura.getIdContactoTel());
            ps.setInt(3, factura.getIdContactoDir());
            ps.setInt(4, factura.getIdContactoEmail());
            ps.setInt(5, factura.getIdTurno());
            ps.setString(6, factura.getEstadoFactura().toString());
            ps.setString(7, factura.getNombreTemporal());

            ps.executeUpdate();
            return Resultado
                    .builder()
                    .mensaje("Factura modificada correctamente.")
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje("Error al modificar la factura.")
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }

    /**
     * Metodo que elimina las facturas del sistema por el identificador
     * suministrado.
     *
     * Nota: las facturas pueden eliminarse si el estado es nula.
     *
     * @param id Es el identificador del registro de la factura.
     * @return Devuelve un mensaje de la acción
     */
    public synchronized static Resultado delete(int id) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_M_FACTURA (?);";
        try (PreparedStatement ps = getCnn().prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(FACTURA__BORRADA__CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA
            = "!Ocurrio un error al intentar borrar la Factura...!!!";
    public static final String FACTURA__BORRADA__CORRECTAMENTE
            = "Factura Borrada Correctamente.";
}
