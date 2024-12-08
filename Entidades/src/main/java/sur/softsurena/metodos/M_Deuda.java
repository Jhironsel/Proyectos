package sur.softsurena.metodos;

import java.math.BigDecimal;
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
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Deuda;
import sur.softsurena.entidades.Generales;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Deuda {

    /**
     * Es el metodo utilizado para obtener la lista de las deudas registrada en
     * el sistema cuyo ESTADO debe ser Credito, Iniciada o Abonada.
     *
     * Consulta que nos trae la informacion de los registros de las deudas que
     * como estado estan a Credito, Iniciada o Abonada.
     *
     * Cuya consulta está unida por las tablas de V_DEUDAS, V_PERSONAS,
     * V_GENERALES.
     *
     * @param filtro
     *
     * @return
     */
    public static synchronized List<Deuda> getDeudas(@NonNull FiltroBusqueda filtro) {
        List<Deuda> deudasList = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlGetDeudas(filtro),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    deudasList.add(
                            Deuda
                                    .builder()
                                    .id_deuda(rs.getInt("ID"))
                                    .cliente(
                                            Cliente
                                                    .builder()
                                                    .persona(
                                                            Persona
                                                                    .builder()
                                                                    .id_persona(rs.getInt("ID_CLIENTE"))
                                                                    .pnombre(rs.getString("P_NOMBRE"))
                                                                    .snombre(rs.getString("S_NOMBRE"))
                                                                    .apellidos(rs.getString("APELLIDOS"))
                                                                    .generales(
                                                                            Generales
                                                                                    .builder()
                                                                                    .cedula(rs.getString("CEDULA"))
                                                                                    .build()
                                                                    )
                                                                    .build()
                                                    )
                                                    .build()
                                    )
                                    .concepto(rs.getString("CONCEPTO"))
                                    .monto(rs.getBigDecimal("MONTO"))
                                    .fecha(rs.getDate("FECHA"))
                                    .hora(rs.getTime("HORA"))
                                    .estadoDeuda(rs.getString("ESTADO").charAt(0))
                                    .build()
                    );
                }
            }
        } catch (SQLException e) {
            LOG.log(
                    Level.SEVERE,
                    e.getMessage(),
                    e
            );
        }
        return deudasList;
    }

    protected static String sqlGetDeudas(FiltroBusqueda filtro) {
        Boolean f_criterio = Objects.isNull(filtro.getCriterioBusqueda());
        Boolean f_id = Objects.isNull(filtro.getId());
        boolean f_where = f_criterio && f_id;
        return """
               SELECT ID, ID_CLIENTE, CONCEPTO, MONTO, FECHA, HORA,
               ESTADO, P_NOMBRE, S_NOMBRE, APELLIDOS, CEDULA
               FROM GET_DEUDAS
               %s%s%s
               """.formatted(
                f_where ? "" : "WHERE ",
                f_criterio ? "" : "CEDULA LIKE '%s' ".formatted(filtro.getCriterioBusqueda()),
                f_id ? "" : "ID = %d ".formatted(filtro.getId())
        ).trim().strip();
    }
//------------------------------------------------------------------------------

    /**
     * Este metodo permite registrar las deudas en el sistema. Solo pide por el
     * momento id del cliente, el concepto de la deuda y el monto de la deuda.
     *
     * @param miDeuda
     *
     * @return
     */
    public synchronized static Resultado insertDeudas(@NonNull Deuda miDeuda) {
        final String sql = """
                           SELECT O_ID
                           FROM SP_I_M_DEUDAS (?,?,?);
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {

            ps.setInt(1, miDeuda.getCliente().getPersona().getId_persona());
            ps.setString(2, miDeuda.getConcepto());
            ps.setBigDecimal(3, miDeuda.getMonto());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id_deuda = rs.getInt("O_ID");

                return Resultado
                        .builder()
                        .id(id_deuda)
                        .mensaje("Registro de deuda exitoso.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build();
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .mensaje("Error al insertar la deuda.")
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }

    /**
     * Este procedimiento permite modificar el estado de una factura.
     *
     * @param deuda
     * @return
     */
    public synchronized static Resultado modificarDeuda(Deuda deuda) {
        final String sql = "EXECUTE PROCEDURE SP_U_DEUDA(?,?,?)";

        try (CallableStatement ps = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
        )) {
            ps.setInt(1, deuda.getId_deuda());
            ps.setString(2, deuda.getConcepto());
            ps.setBigDecimal(3, deuda.getMonto());

            ps.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje("Esperacion realizada correctamente.")
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return Resultado
                    .builder()
                    .mensaje("Error a ejecutar Operacion")
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }

    /**
     * TODO CREAR VISTA.
     *
     * @param estado
     * @return
     */
//    public synchronized static ResultSet getDeudaClientesEstado(String estado) {
//        final String sql
//                = "SELECT r.IDDEUDAS, IIF(r.IDCLIENTE = '0', '000-0000000-0', "
//                + "r.IDCLIENTE) as IDCLIENTE, c.NOMBRES, c.APELLIDOS, "
//                + "r.CONCEPTO, r.MONTO, r.FECHA, "
//                + "        (IIF(r.ESTADO = 'i', 'Inicial', "
//                + "         IIF(r.ESTADO = 'p', 'Pagada', "
//                + "         IIF(r.ESTADO = 'a', 'Abonada', "
//                + "         IIF(r.ESTADO = 'n','Nula','No Definida'))))) as ESTADO "
//                + "FROM TABLA_DEUDAS r "
//                + "LEFT JOIN TABLA_CLIENTES c ON c.IDCLIENTE LIKE r.IDCLIENTE "
//                + estado
//                + "ORDER by 1";
//        try (PreparedStatement ps = getCnn().prepareStatement(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT
//        )) {
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return null;
//        }
//    }

    /**
     *
     * @param idCliente
     * @return
     */
//    public synchronized static ResultSet getDeudaCliente(String idCliente) {
//        final String sql
//                = "SELECT r.IDDEUDAS, r.CONCEPTO, r.MONTO, r.FECHA, r.ESTADO "
//                + "FROM TABLA_DEUDAS r "
//                + "WHERE r.IDCLIENTE LIKE ? AND r.ESTADO NOT IN('n', 'p')";
//        try (PreparedStatement ps = getCnn().prepareStatement(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT
//        )) {
//            ps.setString(1, idCliente);
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return null;
//        }
//    }

    /**
     *
     * @param idDeuda
     * @return
     */
//    public synchronized static ResultSet getDeudaClienteExterna(String idDeuda) {
//        final String sql
//                = "SELECT r.CODIGO, r.FECHA, r.HORA, r.MONTO "
//                + "FROM TABLA_PAGO_DEUDAS_EXTERNA r "
//                + "WHERE r.IDDEUDA = ?";
//        try (PreparedStatement ps = getCnn().prepareStatement(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT
//        )) {
//            ps.setString(1, idDeuda);
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return null;
//        }
//    }

    /**
     *
     * @param idDeuda
     * @return
     */
    //!OJO Metodo para analizarlo
//    public synchronized static ResultSet getPagoDeudasExterna(int idDeuda) {
//        final String sql
//                = "SELECT r.CODIGO, r.MONTO, r.FECHA, r.HORA "
//                + "FROM TABLA_PAGO_DEUDAS_EXTERNA r "
//                + "WHERE r.IDDEUDA = ?";
//        try (PreparedStatement ps = getCnn().prepareStatement(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT
//        )) {
//            ps.setInt(1, idDeuda);
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return null;
//        }
//    }

    /**
     *
     * @param idFactura
     * @return
     */
    //!OJO Metodo para analizarlo
//    public synchronized static ResultSet getPagoDeudas(int idFactura) {
//        final String sql
//                = "SELECT r.IDPAGODEUDA, r.FECHA, r.HORA, r.MONTOPAGO "
//                + "FROM TABLA_PAGODEUDA r "
//                + "WHERE r.IDFACTURA = ?";
//
//        try (PreparedStatement ps = getCnn().prepareStatement(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT
//        )) {
//            ps.setInt(1, idFactura);
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return null;
//        }
//    }

    /**
     *
     * @param idCliente
     * @return
     */
//    public synchronized static BigDecimal getDeudaActual(String idCliente) {
//        final String sql
//                = "SELECT r.DEUDAACTUAL "
//                + "FROM TABLA_DEUDAS r "
//                + "WHERE r.IDCLIENTE LIKE ?;";
//
//        try (PreparedStatement ps = getCnn().prepareStatement(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT
//        )) {
//            ps.setString(1, idCliente);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getBigDecimal("DEUDAACTUAL");
//                } else {
//                    return new BigDecimal(0);
//                }
//            }
//
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return new BigDecimal(-1);
//        }
//    }

    /**
     * 
     * @param idDeuda
     * @return 
     */
//    public synchronized static BigDecimal sumaMontoPagoDeudaExterna(int idDeuda) {
//        final String sql
//                = "SELECT SUM(r.MONTO) "
//                + "FROM TABLA_PAGO_DEUDAS_EXTERNA r "
//                + "WHERE r.IDDEUDA = ?";
//        try (PreparedStatement ps = getCnn().prepareStatement(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT
//        )) {
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getBigDecimal(1);
//                } else {
//                    return new BigDecimal(0);
//                }
//            }
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return new BigDecimal(-1);
//        }
//    }

    /**
     *
     * @param idDeuda
     * @param idTurno
     * @param monto
     * @return
     */
//    public synchronized static Boolean pagoDeuda(int idDeuda, int idTurno,
//            BigDecimal monto) {
//        final String sql = "EXECUTE PROCEDURE INSER_PAGO_DEUDAS_EXT (?, ?, ?)";
//        try (CallableStatement cs = getCnn().prepareCall(
//                sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.CLOSE_CURSORS_AT_COMMIT
//        )) {
//            cs.setInt(1, idDeuda);
//            cs.setInt(2, idTurno);
//            cs.setBigDecimal(3, monto);
//            return cs.execute();
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//        }
//        return null;
//    }
}
