package sur.softsurena.FirebirdEventos;

import java.sql.SQLException;
import java.util.logging.Level;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import sur.softsurena.formularios.frmAlmacenes;
import static sur.softsurena.formularios.frmClientes.llenarTablaClientes;
import static sur.softsurena.formularios.frmClientes.llenarTablaCorreos;
import static sur.softsurena.formularios.frmClientes.llenarTablaDirreciones;
import static sur.softsurena.formularios.frmClientes.llenarTablaTelefonos;
import sur.softsurena.formularios.frmDeudas;
import static sur.softsurena.formularios.frmProductos.llenarTablaProductos;
import static sur.softsurena.formularios.frmUsuarios.llenarTablaUsuarios;
import sur.softsurena.utilidades.FiltroBusqueda;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class FirebirdEventos extends FBEventManager {

    public synchronized boolean registro(String user, String clave,
            String dominio, String pathBaseDatos, int puerto) {
        setUser(user);
        setPassword(clave);

//        setHost(dominio); //Han sido sustituido para futura versiones de JayBird
        setServerName(dominio);

//        setDatabase(pathBaseDatos);
        setDatabaseName(pathBaseDatos);

//        setPort(puerto);
        setPortNumber(puerto);

        try {
            if (!isConnected()) {
                connect();
            }
            //Evento para productos.********************************************
            addEventListener("EVENT_PRODUCTO", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                llenarTablaProductos("evento");
            });

            //Evento para personas clientes.************************************
            addEventListener("EVENT_CLIENTE", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                llenarTablaClientes(-1, "");
            });

            //Eventos de usuario.***********************************************
            addEventListener("EVENT_USUARIO", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                llenarTablaUsuarios();
            });

            //Evento de Direccion de cliente.***********************************
            addEventListener("EVENT_DIRECCION", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                llenarTablaDirreciones(null);
            });

            //Evento de Telefono de cliente.************************************
            addEventListener("EVENT_TELEFONO", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                llenarTablaTelefonos(null);
            });

            //Evento de Correo de cliente.**************************************
            addEventListener("EVENT_CORREO", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                llenarTablaCorreos(null);
            });
            
            //Evento de Deudas de clientes.*************************************
            addEventListener("EVENT_DEUDA", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                frmDeudas.llenarTabla();
            });
            
            //Evento de Almacenes del sistema.**********************************
            addEventListener("EVENT_ALMACEN", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                frmAlmacenes.llenarTabla(
                        FiltroBusqueda
                                .builder()
                                .id(-1)
                                .criterioBusqueda("")
                                .build()
                );
            });
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    "Error en los eventos de Firebird",
                    ex
            );
            return false;
        }
        return true;
    }
}