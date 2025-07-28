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
import lombok.Cleanup;
import lombok.NonNull;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Generales;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;

/**
 *
 * @author jhironsel
 */
public class M_Generales {

    /**
     * Metodo que nos permite tener los atributos de las generales de una
     * persona.
     *
     * @param generales
     * @return
     */
    public static List<Generales> select(
            @NonNull Generales generales
    ) {
        List<Generales> lista = new ArrayList<>();

        try (PreparedStatement ps = getCnn().prepareStatement(
                sqlSelect(generales),
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            @Cleanup
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                do {
                    lista.add(
                            Generales
                                    .builder()
                                    .id(rs.getInt("ID"))
                                    .idPersona(rs.getInt("ID_PERSONA"))
                                    .idTipoSangre(rs.getInt("ID_TIPO_SANGRE"))
                                    .cedula(rs.getString("CEDULA"))
                                    .estado_civil(rs.getString("ESTADO_CIVIL").charAt(0))
                                    .build()
                    );
                } while (rs.next());
            } else {
                lista.add(
                        Generales
                                .builder()
                                .id(0)
                                .idPersona(0)
                                .idTipoSangre(0)
                                .cedula("000-0000000-0")
                                .estado_civil('X')
                                .build()
                );
            }

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error al consultar las generales en el sistema.",
                    ex
            );
        }
        return lista;
    }

    protected static String sqlSelect(Generales generales) {
        Boolean id = Objects.isNull(generales.getId());
        Boolean idPersona = Objects.isNull(generales.getIdPersona());
        Boolean cedula = Objects.isNull(generales.getCedula());
        Boolean where = id && idPersona && cedula;

        Boolean f_row = Objects.isNull(generales.getPagina());

        return """
               SELECT ID, ID_PERSONA, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
               FROM V_GENERALES
               %s%s%s%s%s
               """.formatted(
                where ? "" : "WHERE ",
                idPersona ? "" : "ID_PERSONA = %d ".formatted(generales.getIdPersona()),
                id ? "" : "ID = %d ".formatted(generales.getId()),
                cedula ? "" : "CEDULA STARTING WITH '%s' ".formatted(generales.getCedula()),
                f_row ? "" : "ROWS (%d - 1) * %d + 1 TO (%d + (1 - 1)) * %d;"
                                .formatted(
                                        generales.getPagina().getNPaginaNro(),
                                        generales.getPagina().getNCantidadFilas(),
                                        generales.getPagina().getNPaginaNro(),
                                        generales.getPagina().getNCantidadFilas()
                                )
        ).strip();
    }

//------------------------------------------------------------------------------
    /**
     *
     * @param general
     * @return
     */
    public static Resultado insert(
            @NonNull Generales general
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SP_I_GENERAL(?,?,?,?)
                           """;

        try (CallableStatement cs = getCnn().prepareCall(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {

            cs.setInt(1, general.getIdPersona());
            cs.setString(2, general.getCedula());
            cs.setInt(3, general.getIdTipoSangre());
            cs.setString(4, general.getEstado_civil().toString());

            cs.executeUpdate();

            return Resultado
                    .builder()
                    .mensaje(GENERAL_INSERTADA_CORRECTAMENTE_EN_EL_SIS)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_INSERTAR_GENERALES_EN_EL_SISTEMA,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_INSERTAR_GENERALES_EN_EL_SISTEMA)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_INSERTAR_GENERALES_EN_EL_SISTEMA
            = "Error al insertar generales en el sistema.";
    public static final String GENERAL_INSERTADA_CORRECTAMENTE_EN_EL_SIS
            = "General insertada correctamente en el sistema.";

    //--------------------------------------------------------------------------
    /**
     * Metodo que permite la actulizaciones de las generales de una persona en
     * el sistema.
     *
     * @param general
     *
     * @return
     */
    public static Resultado update(
            @NonNull Generales general
    ) {
        final String sql = """
                           EXECUTE PROCEDURE SP_U_GENERAL(?,?,?,?);
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, general.getIdPersona());
            ps.setString(2, general.getCedula());
            ps.setInt(3, general.getIdTipoSangre());
            ps.setString(4, general.getEstado_civil().toString());

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(GENERALES_ACTUALIZADA_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_ACTUALIZAR_LAS__GENERALES_EN_EL_S,
                    ex
            );
        }
        return Resultado
                .builder()
                .mensaje(ERROR_AL_ACTUALIZAR_LAS__GENERALES_EN_EL_S)
                .icono(JOptionPane.ERROR_MESSAGE)
                .estado(Boolean.FALSE)
                .build();
    }
    public static final String ERROR_AL_ACTUALIZAR_LAS__GENERALES_EN_EL_S
            = "Error al actualizar las Generales en el sistema.";
    public static final String GENERALES_ACTUALIZADA_CORRECTAMENTE
            = "Generales actualizada correctamente.";

//------------------------------------------------------------------------------
    public static Resultado delete(Integer id) {
        final String sql = """
                           EXECUTE PROCEDURE SP_D_GENERAL(?);
                           """;

        try (PreparedStatement ps = getCnn().prepareStatement(
                sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT
        )) {
            ps.setInt(1, id);

            ps.execute();

            return Resultado
                    .builder()
                    .mensaje(GENERALES_BORRADA_CORRECTAMENTE_DEL_SISTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build();

        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ERROR_AL_BORRAR_LAS_GENERALES_EN_EL_SISTE.formatted(id),
                    ex
            );

            return Resultado
                    .builder()
                    .mensaje(ERROR_AL_BORRAR_LAS_GENERALES_EN_EL_SISTE.formatted(id))
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();
        }
    }
    public static final String ERROR_AL_BORRAR_LAS_GENERALES_EN_EL_SISTE
            = "Error al borrar las generales en el sistema. [ Codigo: %d ]";
    public static final String GENERALES_BORRADA_CORRECTAMENTE_DEL_SISTE
            = "Generales borrada correctamente del sistema.";

    /**
     * Genera una cedula automaticamente para pruebas en el sistema.
     *
     * @return devuelve una cedula valida en el sistema.
     */
    public static String generarCedula() {
        int primerDigito = (int) (Math.random() * 4) + 1;
        int segundoDigito = (int) (Math.random() * 5);
        int tercerDigito = (int) (Math.random() * 10);
        int cuartoDigito = (int) (Math.random() * 10);
        int quintoDigito = (int) (Math.random() * 10);
        int sextoDigito = (int) (Math.random() * 10);
        int septimoDigito = (int) (Math.random() * 10);
        int octavoDigito = (int) (Math.random() * 10);
        int novenoDigito = (int) (Math.random() * 10);

        int[] multiplicadores = {2, 1, 2, 1, 2, 1, 2, 1, 2};

        int suma = 0;

        for (int i = 0; i < multiplicadores.length; i++) {
            int digito = i == 0 ? primerDigito : i == 1 ? segundoDigito : i == 2 ? tercerDigito
                    : i == 3 ? cuartoDigito : i == 4 ? quintoDigito : i == 5 ? sextoDigito
                                            : i == 6 ? septimoDigito : i == 7 ? octavoDigito : novenoDigito;
            int producto = digito * multiplicadores[i];
            suma += producto > 9 ? producto - 9 : producto;
        }

        int ultimoDigito = (10 - (suma % 10)) % 10;

        String cedula = String.format(
                "%d%d%d-0%d%d%d%d%d%d-%d",
                primerDigito,
                segundoDigito,
                tercerDigito,
                cuartoDigito,
                quintoDigito,
                sextoDigito,
                septimoDigito,
                octavoDigito,
                novenoDigito,
                ultimoDigito
        );

        if (cedula(cedula)) {
            return cedula;
        } else {
            return generarCedula();
        }

    }

    /**
     * Verifica se una cedula cumple con los requisito para una cedula
     * dominicana.
     *
     * @param cedula cedula para validar.
     *
     * @return devuelve true si es autentica o falso en caso contrario.
     *
     */
    public static boolean cedula(String cedula) {
        // Eliminar guiones y espacios en blanco
        cedula = cedula.replaceAll("[\\s-]+", "");

        final int[] MULTIPLOS = {2, 1, 2, 1, 2, 1, 2, 1, 2};

        // Verificar longitud
        if (cedula.length() != 11) {
            return false;
        }

        // Calcular suma de productos
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.digit(cedula.charAt(i), 10);
            int producto = digito * MULTIPLOS[i];
            suma += producto > 9 ? producto - 9 : producto;
        }

        // Verificar dígito verificador
        int digitoVerificador = Character.digit(cedula.charAt(10), 10);
        int resto = (10 - (suma % 10)) % 10;

        return digitoVerificador == resto;
    }
}
