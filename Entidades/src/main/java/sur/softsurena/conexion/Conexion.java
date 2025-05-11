package sur.softsurena.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import lombok.NonNull;
import static sur.softsurena.metodos.M_BaseDeDatos.periodoMaquina;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

public class Conexion {

    private static Connection cnn;
    private static String USER, CLAVE, ROLE;
    private static final String PROTOCOLO_FIREBIRD = "jdbc:firebirdsql://";
    private static StringBuilder URL_DB;
    private static frmRegistros miRegistros;
    
    /**
     * Metodo que ofrece la conexion realizada y validada del sistema.
     * @return
     */
    public synchronized static Connection getCnn() {
        return cnn;
    }

    /**
     * Metodo que setea la conexion del sistema.
     * @param cnn 
     */
    public static void setCnn(Connection cnn) {
        Conexion.cnn = cnn;
    }

    /**
     * Unico Metodo que permite obtener una instancia de la clase Conexión.La
     * cual requeire de los siguientes parametros de entrada.
     *
     * @param user Es el usuario registrado en el sistema.
     * @param clave Clave de acceso del usuario.
     * @param path_bd Ruta de acceso hacia la Base de Datos.
     * @param dominio Direccion ip o local de la base de datos.
     * @param puerto Puerto utilizado para la conexion de la base de datos.
     * @param role el role tiene los privilegios necesarios para el usuario.
     *
     * @return Devuelve una instancia de la clase conexion. La cual inicializa
     * las variables para la conexion a la base de datos.
     */
    public static Conexion getInstance(
            @NonNull String user,
            @NonNull String clave,
            @NonNull String path_bd,
            @NonNull String dominio,
            @NonNull String puerto,
            @NonNull String role
    ) {
        
        Conexion.USER = user;
        Conexion.CLAVE = clave;
        Conexion.ROLE = role;

        StringBuilder p = new StringBuilder("");

        if (!puerto.isBlank()) {
            p.append(":").append(puerto);
        }

        URL_DB = new StringBuilder();
        URL_DB.append(PROTOCOLO_FIREBIRD)
                .append(dominio)
                .append(p)
                .append("/")
                .append(path_bd)
                .append("?wireEncryption=chacha64");
        return ConexionHolder.INSTANCE;
    }

    //--------------------------------------------------------------------------
    private static class ConexionHolder {

        private static Conexion INSTANCE = new Conexion();
    }

    public static void setInstanceNull() {
        Conexion.ConexionHolder.INSTANCE = null;
    }

    private Conexion() {
        
    }

    public static boolean validarUsario(
            JTextField txtUsuario, JPasswordField txtClave, JFrame jframe
    ) {
        //Validación de campos del login. 
        if (txtUsuario.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    jframe,
                    "Ingrese un usuario",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtUsuario.requestFocus();
            return false;
        }

        if (txtClave.getPassword().length == 0) {
            JOptionPane.showMessageDialog(
                    jframe,
                    "Inserte una clave",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtClave.requestFocus();
            return false;
        }//Fin de validaciones de campos

        frmParametros parametros = frmParametros.getInstance();

        Conexion.getInstance(
                txtUsuario.getText(),
                new String(txtClave.getPassword()),
                parametros.cargarParamentos().getPathBaseDatos(),
                parametros.cargarParamentos().getHost(),
                parametros.cargarParamentos().getPuerto(),
                "NONE"
        );

        Resultado resultado = Conexion.verificar();

        if (!resultado.getEstado()) {
            JOptionPane.showMessageDialog(
                    jframe,
                    resultado.getMensaje(),
                    "",
                    resultado.getIcono()
            );

            txtClave.setText("");
            txtUsuario.setText("");
            txtUsuario.requestFocus();
            return false;
        }

        //Comprobación de los dias restante de la licencia.
        int dia = periodoMaquina();
        if (dia < 1) {
            JOptionPane.showMessageDialog(
                    jframe,
                    "Licencia expirada...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            int resp = JOptionPane.showConfirmDialog(
                    jframe,
                    "Desea registrar el producto?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.OK_OPTION) {
                miRegistros = frmRegistros.getInstance(null, true);
                miRegistros.setVisible(true);

                if (miRegistros.txtIdMaquina.getText()
                        .equalsIgnoreCase("cancelado")) {
                    return false;
                }

                miRegistros.dispose();
                Conexion.setInstanceNull();
            }
            return false;
        }

        if (dia > 1 && dia < 10) {
            JOptionPane.showMessageDialog(
                    jframe,
                    "Tiempo de version de prueba se acaba en " + dia + " dias.",
                    "",
                    JOptionPane.WARNING_MESSAGE
            );
        }

        //Blanquear la pass
        txtClave.setText("");
        return true;
    }

    /**
     * Metodo que permite a los usuarios del sistema validar si estan
     * debidamente Loggeado,
     *
     * @return Retorna true si esta dentro o false si tuvo problema en la
     * conexion.
     */
    public static Resultado verificar() {

        final Properties properties = new Properties();
        properties.setProperty("user", Conexion.USER);
        properties.setProperty("password", Conexion.CLAVE);
        properties.setProperty("charSet", "UTF8");

        if (Objects.nonNull(Conexion.ROLE)) {
            properties.setProperty("roleName", Conexion.ROLE);
        }

        try {
            setCnn(DriverManager.getConnection(URL_DB.toString(), properties));
            return Resultado
                    .builder()
                    .mensaje("Bienvendo al sistema.")
                    .estado(Boolean.TRUE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .build();
        } catch (java.sql.SQLInvalidAuthorizationSpecException ex1) {
            Utilidades.LOG.setLevel(Level.INFO);
            Utilidades.LOG.log(
                    Level.INFO,
                    JAVASQL_SQL_INVALID_AUTHORIZATION_SPEC_EXCEPTI,
                    ex1.getCause()
            );
            return Resultado
                    .builder()
                    .mensaje(JAVASQL_SQL_INVALID_AUTHORIZATION_SPEC_EXCEPTI)
                    .estado(Boolean.FALSE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .build();
        } catch (SQLException ex) {
            String mensaje = "";

            if (ex.getMessage().contains(E_FECHA_INICIAL_INCORRECTA)) {
                mensaje = E_FECHA_INICIAL_INCORRECTA;
            }

            if (ex.getMessage().contains(E_FECHA_ACTUAL_INCORRECTA)) {
                mensaje = E_FECHA_ACTUAL_INCORRECTA;
            }

            if (ex.getMessage().contains(E_FECHA_VENCIMIENTO)) {
                mensaje = E_FECHA_VENCIMIENTO;
            }

            if (ex.getMessage().contains(E_EQUIPO_NO_REGISTRADO)) {
                mensaje = E_EQUIPO_NO_REGISTRADO;
            }

            if (ex.getMessage().contains(UNABLE_TO_COMPLETE_NETWORK_REQUEST_TO_HOS)) {
                mensaje = UNABLE_TO_COMPLETE_NETWORK_REQUEST_TO_HOS;
            }

            if (mensaje.isBlank()) {
                mensaje = ex.getMessage();
            }

            Utilidades.LOG.log(
                    Level.SEVERE, 
                    mensaje, 
                    ex
            );

            return Resultado
                    .builder()
                    .mensaje(mensaje)
                    .estado(Boolean.FALSE)
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .build();
        }
    }

    public static final String UNABLE_TO_COMPLETE_NETWORK_REQUEST_TO_HOS
            = "Unable to complete network request to host";
    /**
     * Driver de firebird (Jaybird) no se encuentra en la carpecta /lib del
     * proyecto. https://firebirdsql.org/en/jdbc-driver/
     */
    public static final String LIBRERIA_DEL_DRIVER_NO_ENCONTRADA
            = "Libreria no encontrada";

    /**
     * Esta variable indica que el usuario y la contraseña son incorrecto.
     */
    public static final String JAVASQL_SQL_INVALID_AUTHORIZATION_SPEC_EXCEPTI
            = "Usuario y contraseña incorrecta.!!!";
    /**
     * Esta variable indica que la fecha inicial es incorrecta. Debe ajustar la
     * fecha del servidor.
     */
    public static final String E_FECHA_INICIAL_INCORRECTA
            = "E_FECHA_INICIAL_INCORRECTA";
    /**
     * La fecha actual registrada en el revidor es incorrecta.
     */
    public static final String E_FECHA_ACTUAL_INCORRECTA
            = "E_FECHA_ACTUAL_INCORRECTA";
    /**
     * La fecha del producto ha caducado.
     */
    public static final String E_FECHA_VENCIMIENTO
            = "E_FECHA_VENCIMIENTO";

    /**
     * Indica que no existe registros en el servidor de la base de datos.
     */
    public static final String E_EQUIPO_NO_REGISTRADO
            = "E_EQUIPO_NO_REGISTRADO";
}
