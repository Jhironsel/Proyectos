package sur.softsurena.metodos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import lombok.Cleanup;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Cliente {

    /**
     * Metodo que permite obtener los cliente del sistema.
     *
     * @param cliente contiene los elemento de la consulta.
     *
     * @return
     */
    public static List<Cliente> select(
            @NonNull Cliente cliente
    ) {
        List<Cliente> lista = new ArrayList<>();
        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            @Cleanup
            ResultSet rs = ps.executeQuery(sqlSelect(cliente));

            while (rs.next()) {
                lista.add(
                        Cliente
                                .builder()
                                .id(rs.getInt("ID"))
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTA_LA_VISTA_GET_PERSONA_CL,
                    ex
            );
        }
        return lista;
    }
    public static final String ERROR_AL_CONSULTA_LA_VISTA_GET_PERSONA_CL
            = "Error al consulta la vista V_PERSONAS_CLIENTES";

    /**
     *
     * @param cliente
     *
     * @return
     */
    protected static String sqlSelect(
            Cliente cliente
    ) {
        Boolean id = Objects.isNull(cliente.getId());
        StringBuilder sb = new StringBuilder();
        sb.append(
                """
                SELECT ID
                FROM V_PERSONAS_CLIENTES
                """
        );
        sb.append(id ? "":"WHERE ID = %d ".formatted(cliente.getId()));

        return sb.toString().strip();
    }
    
//------------------------------------------------------------------------------
    /**
     * Metodo que permite obtener los cliente del sistema.
     *
     * @param cliente contiene los elemento de la consulta.
     *
     * @return
     */
    public static List<Cliente> selectATR(
            @NonNull Cliente cliente
    ) {
        List<Cliente> lista = new ArrayList<>();
        try (Statement ps = getCnn().createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            @Cleanup
            ResultSet rs = ps.executeQuery(sqlSelect(cliente));

            while (rs.next()) {
                lista.add(
                        Cliente
                                .builder()
                                .id(rs.getInt("ID"))
                                .totalFacturado(rs.getBigDecimal("TOTAL_FACTURADO"))
                                .totalDeuda(rs.getBigDecimal("TOTAL_DEUDA"))
                                .cantidadFactura(rs.getInt("CANTIDAD_FACTURA"))
                                .fechaUltimaCompra(rs.getDate("FECHA_ULTIMA_COMPRA"))
                                .saldo(rs.getBigDecimal("SALDO"))
                                .build()
                );
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTA_LA_VISTA_GET_PERSONA_CL,
                    ex
            );
        }
        return lista;
    }

    /**
     *
     * @param cliente
     *
     * @return
     */
    protected static String sqlSelectSTR(
            Cliente cliente
    ) {
        Boolean id = Objects.isNull(cliente.getId());
        StringBuilder sb = new StringBuilder();
        sb.append(
                """
                SELECT ID, TOTAL_FACTURADO, TOTAL_DEUDA, CANTIDAD_FACTURA, 
                    FECHA_ULTIMA_COMPRA, SALDO
                FROM V_PERSONAS_CLIENTES_ATR
                """
        );
        sb.append(id ? "":"ID = %d ".formatted(cliente.getId()));

        return sb.toString();
    }
//------------------------------------------------------------------------------
    
    /**
     * Permite agregar un cliente ya registrado en la tabla de Personas a
     * Personas_Cliente.
     *
     * @param id Identificador de la personas en el sistema.
     *
     * @return Un objecto de la clase
     */
    public static Resultado insertById(int id) {
        try (CallableStatement cs = getCnn().prepareCall(
                "EXECUTE PROCEDURE SP_I_PERSONA_CLIENTE(?)",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, id);

            cs.execute();

            return Resultado
                    .builder()
                    .mensaje(CLIENTE__AGREGADO__CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR__CLIENTE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_INSERTAR__CLIENTE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_INSERTAR__CLIENTE
            = "Error al insertar Cliente al sistema.";
    public static final String CLIENTE__AGREGADO__CORRECTAMENTE
            = "Cliente Agregado Correctamente";
//------------------------------------------------------------------------------

    /**
     * Este procedimiento tiene la habilidad de borrar los registros de las
     * vistas siguiente: V_CONTACTS_TEL, V_CONTACTS_EMAIL, V_CLIENTES,
     * V_DIRECCIONES, V_GENERALES y V_PERSONAS.
     *
     * Para eliminar un cliente, no debe de tener registros en el sistema.
     *
     * @param idCliente
     * @return
     */
    public synchronized static Resultado delete(int idCliente) {
        final String sql = "EXECUTE PROCEDURE SP_D_PERSONA_CLIENTE (?);";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idCliente);

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(CLIENTE_BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    CLIENTE_NO_PUEDE_SER_BORRADO,
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .mensaje(CLIENTE_NO_PUEDE_SER_BORRADO)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String CLIENTE_BORRADO_CORRECTAMENTE
            = "Cliente borrado correctamente.";
    public static final String CLIENTE_NO_PUEDE_SER_BORRADO
            = "Cliente no puede ser borrado.";
//------------------------------------------------------------------------------
}
