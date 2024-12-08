package sur.softsurena.metodos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.ContactoEmail;
import sur.softsurena.entidades.ContactoTel;
import sur.softsurena.entidades.Direccion;
import sur.softsurena.entidades.Factura;
import sur.softsurena.entidades.M_Factura;
import sur.softsurena.entidades.Turno;
import static sur.softsurena.metodos.M_D_Factura.agregarDetalleFactura;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_M_Factura {

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
    public synchronized static Resultado agregarFacturaNombre(Factura factura) {
        final String sql
                = """
                  SELECT ID
                  FROM SP_I_M_FACTURA (?, ?, ?, ?, ?, ?, ?, ?, ?);
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, factura.getM_factura().getCliente().getPersona().getId_persona());
            ps.setInt(2, factura.getM_factura().getContactoTel().getId());
            ps.setInt(3, factura.getM_factura().getDireccion().getId());
            ps.setInt(4, factura.getM_factura().getContactoEmail().getId());
            ps.setInt(5, factura.getM_factura().getTurno().getId());
            ps.setString(8, String.valueOf(
                    factura.getM_factura().getEstadoFactura()
            ));
            ps.setString(9, factura.getM_factura().getNombreTemporal());

            ResultSet rs = ps.executeQuery();

            rs.next();

            int idFactura = rs.getInt("ID");

            Resultado resultado = agregarDetalleFactura(
                    factura
            );

            if (!resultado.getEstado()) {
                throw new SQLException("Error en el detalle de la factrura.");
            }

            return Resultado
                    .builder()
                    .id(idFactura)
                    .mensaje(FACTURA_INGRESADA_CORRECTAMENTE_AL_SISTEM)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA,
                    ex
            );
            return Resultado
                    .builder()
                    .id(-1)
                    .mensaje(ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }

    }
    public static final String FACTURA_INGRESADA_CORRECTAMENTE_AL_SISTEM
            = "Factura ingresada correctamente al sistema.";
    public static final String ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA
            = "Error al insertar factura al sistema.";

    /**
     * Metodo que permite modificar las facturas que se encuentran en el sistema
     *
     * @param f Objeto de la clase Factura.
     * 
     * @return retorna true si fue modificada y false si hubo un error en la
     * modificacion de la factura.
     */
    public synchronized static Resultado modificarFactura(Factura f) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_U_FACTURA (
                        ?, --ID
                        ?, --ID_CONTACTOS_TEL
                        ?, --ID_CONTACTOS_DIRECCIONES
                        ?, --ID_CONTACTOS_EMAIL
                        ?, --ID_TURNO
                        ?, --ESTADO_FACTURA
                        ?, --NOMBRE_TEMP
                  );
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, f.getM_factura().getId());
            ps.setInt(2, f.getM_factura().getContactoTel().getId());
            ps.setInt(3, f.getM_factura().getDireccion().getId());
            ps.setInt(4, f.getM_factura().getContactoEmail().getId());
            ps.setInt(5, f.getM_factura().getTurno().getId());
            ps.setString(6, f.getM_factura().getEstadoFactura().toString());
            ps.setString(7, f.getM_factura().getNombreTemporal());

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
     * Para obtener las facturas temporales del sistema.
     *
     * TODO este metodo deberia de llamar realmente las facturas temporales del
     * sistema.
     *
     * @return
     */
    public synchronized static List<Factura> getTemporales() {
        final String sql
                = """
                  SELECT 
                    ID, 
                    ID_CLIENTE, 
                    ID_CONTACTOS_TEL, 
                    ID_CONTACTOS_DIRECCIONES, 
                    ID_CONTACTOS_EMAIL, 
                    ID_TURNO, 
                    FECHA_HORA, 
                    ESTADO_FACTURA, 
                    NOMBRE_TEMP, 
                    USER_NAME, 
                    PNOMBRE, 
                    SNOMBRE, 
                    APELLIDOS
                  FROM GET_M_FACTURAS
                  WHERE ESTADO_FACTURA = 't';
                  """;

        List<Factura> facturaList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    facturaList.add(
                            Factura
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .m_factura(
                                            M_Factura
                                                    .builder()
                                                    .cliente(
                                                            Cliente
                                                                    .builder()
                                                                    .persona(
                                                                            Persona
                                                                                    .builder()
                                                                                    .id_persona(rs.getInt("ID_CLIENTE"))
                                                                                    .pnombre(rs.getString("PNOMBRE"))
                                                                                    .snombre(rs.getString("SNOMBRE"))
                                                                                    .apellidos(rs.getString("APELLIDOS"))
                                                                                    .build()
                                                                    )
                                                                    .build()
                                                    )
                                                    .contactoTel(
                                                            ContactoTel
                                                                    .builder()
                                                                    .id(rs.getInt("ID_CONTACTOS_TEL"))
                                                                    .build()
                                                    )
                                                    .direccion(
                                                            Direccion
                                                                    .builder()
                                                                    .id(rs.getInt("ID_CONTACTOS_DIRECCIONES"))
                                                                    .build()
                                                    )
                                                    .contactoEmail(
                                                            ContactoEmail
                                                                    .builder()
                                                                    .id(rs.getInt("ID_CONTACTOS_EMAIL"))
                                                                    .build()
                                                    )
                                                    .turno(
                                                            Turno
                                                                    .builder()
                                                                    .id(rs.getInt("ID_TURNO"))
                                                                    .build()
                                                    )
                                                    .fechaHora(rs.getTimestamp("FECHA_HORA"))
                                                    .estadoFactura(rs.getString("ESTADO_FACTURA").charAt(0))
                                                    .nombreTemporal(rs.getString("NOMBRE_TEMP"))
                                                    .userName(rs.getString("USER_NAME"))
                                                    .build()
                                    )
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
        return facturaList;
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
    public synchronized static Resultado borrarFactura(int id) {
        final String sql
                = "EXECUTE PROCEDURE SP_D_M_FACTURA (?);";
        try (PreparedStatement ps = getCnn().prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.execute();

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
