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
import sur.softsurena.entidades.Generales;
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
                                .idPersona(rs.getInt("ID"))
                                .persona(rs.getString("PERSONA").charAt(0))
                                .pnombre(rs.getString("PNOMBRE"))
                                .snombre(rs.getString("SNOMBRE"))
                                .apellidos(rs.getString("APELLIDOS"))
                                .sexo(rs.getString("SEXO").charAt(0))
                                .fecha_nacimiento(rs.getDate("FECHA_NACIMIENTO"))
                                .fecha_ingreso(rs.getDate("FECHA_INGRESO"))
                                .estado(rs.getBoolean("ESTADO"))
                                .generales(
                                        Generales
                                                .builder()
                                                .idTipoSangre(rs.getInt("ID_TIPO_SANGRE"))
                                                .cedula(rs.getString("CEDULA"))
                                                .estado_civil(rs.getString("ESTADO_CIVIL").charAt(0))
                                                .build()
                                )
                                .totalFacturado(rs.getBigDecimal("TOTAL_FACTURADO"))
                                .totalDeuda(rs.getBigDecimal("TOTAL_DEUDA"))
                                .cantidadFactura(rs.getInt("CANTIDAD_FACTURA"))
                                .fechaUltimaCompra(rs.getDate("FECHA_ULTIMA_COMPRA"))
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
        boolean id = Objects.isNull(cliente.getIdPersona());
        boolean pagina = Objects.isNull(cliente.getPagina());
        
        StringBuilder sb = new StringBuilder();
        sb.append(
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                    FECHA_NACIMIENTO, FECHA_INGRESO, ESTADO, ID_TIPO_SANGRE,
                    CEDULA, ESTADO_CIVIL, TOTAL_FACTURADO, TOTAL_DEUDA,
                    CANTIDAD_FACTURA, FECHA_ULTIMA_COMPRA
                FROM V_PERSONAS_CLIENTES_GEN
                """
        );
        sb.append(id ? "":"WHERE ID = %d ".formatted(cliente.getIdPersona()).strip());
        sb.append(pagina ? "": "ROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                .formatted(
                                        cliente.getPagina().getNPaginaNro(),
                                        cliente.getPagina().getNCantidadFilas(),
                                        cliente.getPagina().getNPaginaNro(),
                                        cliente.getPagina().getNCantidadFilas()
                                ).strip()
        );
        return sb.toString().strip();
    }

//------------------------------------------------------------------------------
    
    /**
     * Permite agregar un cliente ya registrado en la tabla de Personas a
     * Personas_Cliente.
     *
     * @param cliente Identificador de la personas en el sistema.
     *
     * @return Un objecto de la clase
     */
    public static Resultado insert(Cliente cliente) {
        try (CallableStatement cs = getCnn().prepareCall(
                "EXECUTE PROCEDURE SP_I_PERSONA_CLIENTE(?)",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            cs.setInt(1, cliente.getIdPersona());

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
     * @param cliente
     * @return
     */
    public static Resultado delete(Cliente cliente) {
        final String sql = "EXECUTE PROCEDURE SP_D_PERSONA_CLIENTE(?);";
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, cliente.getIdPersona());

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
