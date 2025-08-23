package sur.softsurena.vistas;

import java.sql.SQLException;
import java.util.logging.Level;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import org.firebirdsql.gds.ng.WireCrypt;
import sur.softsurena.conexion.VistaParametros;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.entidades.Deuda;
import static sur.softsurena.utilidades.Utilidades.LOG;

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
            addEventListener("EVENT_M_DEUDA ".concat(user).toUpperCase(),
                    (DatabaseEvent event) -> {
                        logg(event);
                        VistaDeudas.llenarTabla(
                                Deuda.builder().build()
                        );
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
