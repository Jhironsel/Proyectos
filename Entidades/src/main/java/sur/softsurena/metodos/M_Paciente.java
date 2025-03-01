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
import sur.softsurena.abstracta.Persona;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class M_Paciente {

    /**
     * Metodo utilizado para consultar el sexo de los pacientes en la Base de
     * Datos.
     *
     * @param idPaciente Identificador que se encuentra registrado en la tabla
     * de V_PERSONAS_PACIENTES.
     *
     * @return
     */
    public static String getSexoPaciente(int idPaciente) {
        final String sql
                = """
                  SELECT SEXO 
                  FROM GET_PACIENTES 
                  WHERE ID = ?
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, idPaciente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_EL_SEXO_DE_UN_PACIENTE,
                    ex
            );
        }
        return "X";
    }
    public static final String ERROR_AL_CONSULTAR_EL_SEXO_DE_UN_PACIENTE
            = "Error al consultar el sexo de un paciente en el sistema.";

    //--------------------------------------------------------------------------
    /**
     * Verificamos si existe la cedula del paciente antes de realizar un
     * registro a la base de datos.
     *
     * TODO Analizar si este metodo es necesario.
     *
     * @param cedula Es el identificador unico de cada persona cuando nace.
     * @return boolean si es verdadero el documento existe false puede
     * realizarse el registro a la base de datos.
     */
    public static Resultado existePaciente(String cedula) {
        final String sql
                = """
                  SELECT ID
                  FROM GET_GENERALES_PACIENTES
                  WHERE CEDULA STARTING WITH ?;
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setString(1, cedula.strip());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Resultado
                        .builder()
                        .id(rs.getInt("ID"))
                        .estado(Boolean.TRUE)
                        .build();
            }
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_LA_CEDULA_DEL_PACIENTE,
                    ex
            );
        }
        return Resultado
                .builder()
                .id(-1)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_CONSULTAR_LA_CEDULA_DEL_PACIENTE
            = "Error al consultar la cedula del paciente.";

//    //--------------------------------------------------------------------------
//    /**
//     * TODO Devolver una lista. Analizar si este metodo es necesario.
//     *
//     * @param estado
//     * @return
//     */
//    public static List<Paciente> getPacienteActivo(boolean estado) {
//        final String sql
//                = """
//                  SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO, 
//                        FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, ESTADO, 
//                        PESO_NACIMIENTO_KG, ALTURA, PERIMETRO_CEFALICO, 
//                        CESAREA, TIEMPO_GESTACION, MASA_CEFALICA
//                  FROM GET_PACIENTES
//                  WHERE ESTADO IS ?
//                """;
//
//        try (PreparedStatement ps = getCnn().prepareStatement(sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
//
//            ps.setBoolean(1, estado);
//
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//            return null;
//        }
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * TODO Devolver una lista. Analizar si este metodo es necesario.
//     *
//     * @param filtro
//     * @param fecha
//     * @param idControlConsulta
//     * @return
//     */
//    public static ResultSet getPacienteActivo(String filtro, String fecha,
//            int idControlConsulta) {
//        final String sql
//                = """
//                  SELECT a.IDPACIENTE, a.CEDULAPACIENTE, a.NOMBRES, a.APELLIDOS, a.SEXO, 
//                         a.IDARS, COALESCE(a.NONSS, '') as NONSS 
//                  FROM GET_PACIENTES a 
//                  WHERE IDPACIENTE not in (SELECT IDPACIENTE
//                                           FROM V_CONSULTAS C 
//                                           WHERE C.FECHA = ? and 
//                                                 C.IDCONTROLCONSULTA = ?) and 
//                        a.Estado
//                  """
//                + filtro;
//
//        try (PreparedStatement ps = getCnn().prepareStatement(sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
//
//            ps.setString(1, fecha);
//            ps.setInt(2, idControlConsulta);
//
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(
//                    Level.SEVERE,
//                    ex.getMessage(),
//                    ex
//            );
//            return null;
//        }
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * TODO Devolver una lista. Analizar si este metodo es necesario.
//     *
//     * @param filtro
//     * @param fecha
//     * @param idControlConsulta
//     * @return
//     */
//    public static ResultSet getPacienteActivo2(String filtro, String fecha,
//            int idControlConsulta) {
//        final String sql
//                = """
//                  SELECT p.IDPACIENTE, p.CEDULAPACIENTE, p.NOMBRES, 
//                    p.APELLIDOS, p.SEXO, p.IDARS, p.NONSS, p.COVER, p.ESTADO,
//                    c.IDCONSULTA,c.TURNO, c.FECHA 
//                  FROM GET_PACIENTES p 
//                  RIGHT JOIN V_CONSULTAS c ON c.IDPACIENTE = p.IDPACIENTE 
//                  LEFT JOIN V_CONSULTAS_APROVADAS A on A.IDCONSULTA = C.IDCONSULTA 
//                  WHERE A.IDCONSULTA is null and c.FECHA = ? and  c.IDCONTROLCONSULTA = ? 
//                  %s
//                  ORDER BY c.TURNO
//                  """.formatted(filtro);
//
//        try (PreparedStatement ps = getCnn().prepareStatement(sql,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_READ_ONLY,
//                ResultSet.HOLD_CURSORS_OVER_COMMIT)) {
//
//            ps.setString(1, fecha);
//            ps.setInt(2, idControlConsulta);
//
//            return ps.executeQuery();
//
//        } catch (SQLException ex) {
//            LOG.log(
//                    Level.SEVERE,
//                    ex.getMessage(),
//                    ex
//            );
//            return null;
//        }
//    }
//
//    //--------------------------------------------------------------------------
//    /**
//     * TODO Devolver una lista. Analizar si este metodo es necesario.
//     *
//     * @param filtro
//     * @param fecha
//     * @param idControlConsulta
//     * @return
//     */
//    public static ResultSet getPacienteActivo3(
//            String filtro, String fecha, int idControlConsulta
//    ) {
//        final String sql
//                = """
//                  SELECT C.IDCONSULTA, C.TURNO, 
//                    P.CEDULAPACIENTE, P.NOMBRES, P.APELLIDOS, 
//                    A.COD_AUTORIZACION, A.COSTO, A.DESCUENTO, A.TOTALCOSTO 
//                  FROM GET_PACIENTES P 
//                  RIGHT JOIN V_CONSULTAS C on C.IDPACIENTE = P.IDPACIENTE 
//                  RIGHT JOIN V_CONSULTAS_APROVADAS A on A.IDCONSULTA = C.IDCONSULTA 
//                  WHERE C.FECHA = ? and C.IDCONTROLCONSULTA = ? 
//                  ORDER BY TURNO;
//                """;
//
//        try (PreparedStatement ps = getCnn().prepareStatement(sql)) {
//
//            ps.setString(1, fecha);
//            ps.setInt(2, idControlConsulta);
//
//            return ps.executeQuery();
//        } catch (SQLException ex) {
//            LOG.log(
//                    Level.SEVERE,
//                    ex.getMessage(),
//                    ex);
//            return null;
//        }
//    }

    //--------------------------------------------------------------------------
    /**
     *
     * @param paciente
     * @return
     */
    public static List<Paciente> select(
            @NonNull Paciente paciente
    ) {
        
        List<Paciente> pacienteList = new ArrayList<>();
        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(paciente),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pacienteList.add(
                        Paciente
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .idPersona(rs.getInt("ID"))
                                                .pnombre(rs.getString("PNOMBRE"))
                                                .snombre(rs.getString("SNOMBRE"))
                                                .apellidos(rs.getString("APELLIDOS"))
                                                .sexo(rs.getString("SEXO").charAt(0))
                                                .fecha_nacimiento(rs.getDate("FECHA_NACIMIENTO"))
                                                .fecha_ingreso(rs.getDate("FECHA_INGRESO"))
                                                .fecha_hora_ultima_update(rs.getDate("FECHA_HORA_ULTIMO_UPDATE"))
                                                .estado(rs.getBoolean("ESTADO"))
                                                .build()
                                )
                                .pesoNacimiento(rs.getBigDecimal("PESO_NACIMIENTO_KG"))
                                .altura(rs.getBigDecimal("ALTURA"))
                                .perimetroCefalico(rs.getBigDecimal("PERIMETRO_CEFALICO"))
                                .cesarea(rs.getBoolean("CESAREA"))
                                .tiempoGestacion(rs.getInt("TIEMPO_GESTACION"))
                                .masaCefalica(rs.getBigDecimal("MASA_CEFALICA"))
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_CONSULTAR_LA_VISTA_GET_PACIENTES,
                    ex
            );
        }
        return pacienteList;
    }
    
    protected static String sqlSelect(Paciente paciente) {
        Boolean estado = Objects.isNull(paciente.getPersona().getEstado());
        Boolean where = estado;
        
        return """
               SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO,
                   FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, ESTADO,
                   PESO_NACIMIENTO_KG, ALTURA, PERIMETRO_CEFALICO,
                   CESAREA, TIEMPO_GESTACION, MASA_CEFALICA
               FROM GET_PACIENTES
               %s%s
               """.strip().trim().formatted(
                       where ? "":"WHERE ",
                       estado ? "":(paciente.getPersona().getEstado() ? "ESTADO ":"ESTADO IS FALSE ")
               ).strip().trim();
    }
    public static final String ERROR_AL_CONSULTAR_LA_VISTA_GET_PACIENTES
            = "Error al consultar la vista GET_PACIENTES del sistema.";

    //--------------------------------------------------------------------------
    /**
     * Metodo que permite agregar un paciente al sisteme.
     *
     * @param paciente objecto de la clase Paciente, con los campos requerido
     * para agregar un paciente.
     *
     * @return Retorna un objecto de la clase Resultados el cual indica si la
     * operacion fue exito o no.
     */
    public static Resultado insert(Paciente paciente) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_I_PERSONA_PACIENTE (?,?,?,?,?,?);
                  """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, paciente.getPersona().getIdPersona());
            ps.setBigDecimal(2, paciente.getPesoNacimiento());
            ps.setBigDecimal(3, paciente.getAltura());
            ps.setBigDecimal(4, paciente.getPerimetroCefalico());
            ps.setBoolean(5, paciente.getCesarea());
            ps.setInt(6, paciente.getTiempoGestacion());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(PACIENTE_AGREGADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_PACIENTE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_INSERTAR_PACIENTE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_INSERTAR_PACIENTE
            = "Error al insertar paciente.";
    public static final String PACIENTE_AGREGADO_CORRECTAMENTE
            = "Paciente agregado correctamente.";

    //--------------------------------------------------------------------------
    /**
     * Metodo que te permite modificar los paciente del sistema.
     *
     * @param paciente
     * @return
     */
    public static Resultado update(Paciente paciente) {
        final String sql
                = """
                  EXECUTE PROCEDURE SP_U_PERSONA_PACIENTE (?,?,?,?,?,?);
                  """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, paciente.getPersona().getIdPersona());
            ps.setBigDecimal(2, paciente.getPesoNacimiento());
            ps.setBigDecimal(3, paciente.getAltura());
            ps.setBigDecimal(4, paciente.getPerimetroCefalico());
            ps.setBoolean(5, paciente.getCesarea());
            ps.setInt(6, paciente.getTiempoGestacion());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(PACIENTE_MODIFICADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_MODIFICAR_PACIENTE,
                    ex
            );
            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_MODIFICAR_PACIENTE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String PACIENTE_MODIFICADO_CORRECTAMENTE
            = "Paciente modificado correctamente";
    public static final String ERROR_AL_MODIFICAR_PACIENTE
            = "Error al modificar cliente...";

    //--------------------------------------------------------------------------
    /**
     * Metodos que permiten borrar registros de la base de datos.
     *
     * @param paciente
     * @return
     */
    public static Resultado delete(Paciente paciente) {
        final String sql = """
                           EXECUTE PROCEDURE SP_D_PERSONA_PACIENTE(?)
                           """;
        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, paciente.getPersona().getIdPersona());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(PACIENTE_BORRADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_PACIENTE.formatted(
                            paciente.getPersona().getIdPersona()
                    ),
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_BORRAR_PACIENTE.formatted(
                        paciente.getPersona().getIdPersona())
                )
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_BORRAR_PACIENTE
            = "Error al borrar paciente. \n[Codigo = %s]";
    public static final String PACIENTE_BORRADO_CORRECTAMENTE
            = "Paciente borrado correctamente.";
}
