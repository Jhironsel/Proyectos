package sur.softsurena.vistas;

import java.sql.SQLException;
import java.util.logging.Level;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import org.firebirdsql.gds.ng.WireCrypt;
import sur.softsurena.conexion.VistaParametros;
import sur.softsurena.entidades.Almacen;
import static sur.softsurena.utilidades.Utilidades.LOG;
import sur.softsurena.vista.VistaPersonas;
import sur.softsurena.vista.VistaUsuarios;

public final class FirebirdEventos extends FBEventManager {

    private String user;

    public FirebirdEventos(String user, String password) {
        super();
        this.user = user;

        VistaParametros parametros = new VistaParametros();

        setUser(user);
        setPassword(password);
        setServerName(parametros.cargarParamentos().getHost());
        setDatabaseName(parametros.cargarParamentos().getPathBaseDatos());
        setPortNumber(Integer.parseInt(parametros.cargarParamentos().getPuerto()));
        setCharSet("UTF8");
        setWireCryptAsEnum(WireCrypt.ENABLED);
        try {
            connect();
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            throw new ExceptionInInitializerError("No pudo conectarse.");
        }
        registro();
        user = null;
        password = null;
    }

    public static void main(String[] args) {
        System.out.println("Resultados 1:" + Boolean.logicalAnd(true, true));
        System.out.println("Resultados 1:" + Boolean.logicalAnd(true, false));
        System.out.println("Resultados 1:" + Boolean.logicalAnd(false, true));
        System.out.println("Resultados 1:" + Boolean.logicalAnd(false, false));
        /*
        Resultados 1:true
        Resultados 1:false
        Resultados 1:false
        Resultados 1:false
         */
        System.out.println("");
        System.out.println("Resultados 2:" + Boolean.logicalOr(true, true));
        System.out.println("Resultados 2:" + Boolean.logicalOr(true, false));
        System.out.println("Resultados 2:" + Boolean.logicalOr(false, true));
        System.out.println("Resultados 2:" + Boolean.logicalOr(false, false));
        /*
        Resultados 1:true
        Resultados 1:true
        Resultados 1:true
        Resultados 1:false
         */
        System.out.println("");
        System.out.println("Resultados 3:" + Boolean.logicalXor(true, true));
        System.out.println("Resultados 3:" + Boolean.logicalXor(true, false));
        System.out.println("Resultados 3:" + Boolean.logicalXor(false, true));
        System.out.println("Resultados 3:" + Boolean.logicalXor(false, false));
        /*
        Resultados 1:false
        Resultados 1:true
        Resultados 1:true
        Resultados 1:false
         */
    }

    private void logg(DatabaseEvent event) {
        LOG.log(
                Level.INFO,
                "Event [{0}] occured {1} time(s)",
                new Object[]{event.getEventName(), event.getEventCount()}
        );
    }

    public void registro() {
        try {
            //Evento para productos.********************************************
            addEventListener("EVENT_PRODUCTO ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaProductos.llenarTablaProductos("");
                    }
            );

            //Evento para personas clientes.************************************
            addEventListener("EVENT_PERSONA ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaPersonas.llenarTablaPersonas();
                    }
            );

            //Eventos de usuario.***********************************************
            addEventListener("EVENT_USUARIO ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaUsuarios.llenarTablaUsuarios();
                    }
            );

            //Evento de Direccion de cliente.***********************************
            addEventListener("EVENT_DIRECCION ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaPersonas.llenarTablaDirreciones(null);
                    }
            );

            //Evento de Telefono de cliente.************************************
            addEventListener("EVENT_TELEFONO ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaPersonas.llenarTablaTelefonos(null);
                    }
            );

            //Evento de Correo de cliente.**************************************
            addEventListener("EVENT_CORREO ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaPersonas.llenarTablaCorreos(null);
                    }
            );

            //Evento de VistaDeudas de clientes.*************************************
            addEventListener("EVENT_DEUDA ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaDeudas.llenarTabla();
                    }
            );

            //Evento de VistaAlmacenes del sistema.**********************************
            addEventListener("EVENT_ALMACEN ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaAlmacenes.llenarTabla(
                                Almacen
                                        .builder()
                                        .nombre("")
                                        .build()
                        );
                    }
            );
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
        }
    }

}
