package sur.softsurena.vistas;

import java.sql.SQLException;
import java.util.logging.Level;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import org.firebirdsql.gds.ng.WireCrypt;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.VistaParametros;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.vista.VistaPersonas;
import static sur.softsurena.vista.VistaPersonas.llenarTablaCorreos;
import static sur.softsurena.vista.VistaPersonas.llenarTablaDirreciones;
import static sur.softsurena.vista.VistaPersonas.llenarTablaTelefonos;
import static sur.softsurena.utilidades.Utilidades.LOG;
import sur.softsurena.vista.VistaUsuarios;

public final class FirebirdEventos extends FBEventManager {


    public FirebirdEventos(String user, String password) {
        super();
        
        VistaParametros parametros = new VistaParametros();
        
        setUser(user);
        setPassword(password);
        setServerName(parametros.cargarParamentos().getHost());
        setDatabaseName(parametros.cargarParamentos().getPathBaseDatos());
        setPortNumber(Integer.parseInt(parametros.cargarParamentos().getPuerto()));
        setCharSet("UTF8");
        setWireCryptAsEnum(WireCrypt.ENABLED);

        if (!isConnected()) {
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
        }
        registro();
        user = null;
        password = null;
    }

    public static void main(String[] args) {
//        FirebirdEventos eventos = new FirebirdEventos();
//
//        FirebirdEventos.USUARIO = "sysdba";
//        FirebirdEventos.CLAVE = "1";
//
//        eventos.registro();

        System.out.println("Resultados 1:"+Boolean.logicalAnd(true, true));
        System.out.println("Resultados 1:"+Boolean.logicalAnd(true, false));
        System.out.println("Resultados 1:"+Boolean.logicalAnd(false, true));
        System.out.println("Resultados 1:"+Boolean.logicalAnd(false, false));
        
        System.out.println("");
        System.out.println("Resultados 1:"+Boolean.logicalOr(true, true));
        System.out.println("Resultados 1:"+Boolean.logicalOr(true, false));
        System.out.println("Resultados 1:"+Boolean.logicalOr(false, true));
        System.out.println("Resultados 1:"+Boolean.logicalOr(false, false));
        
        System.out.println("");
        System.out.println("Resultados 1:"+Boolean.logicalXor(true, true));
        System.out.println("Resultados 1:"+Boolean.logicalXor(true, false));
        System.out.println("Resultados 1:"+Boolean.logicalXor(false, true));
        System.out.println("Resultados 1:"+Boolean.logicalXor(false, false));
        /*
        Resultados 1:true
        Resultados 1:false
        Resultados 1:false
        Resultados 1:false

        Resultados 1:true
        Resultados 1:true
        Resultados 1:true
        Resultados 1:false

        Resultados 1:false
        Resultados 1:true
        Resultados 1:true
        Resultados 1:false
        */
    }

    public boolean registro() {
        try {
            //Evento para productos.********************************************
            addEventListener("EVENT_PRODUCTO", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                VistaProductos.llenarTablaProductos("");
            });

            //Evento para personas clientes.************************************
            addEventListener("EVENT_CLIENTE", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                VistaPersonas.llenarTablaPersonas(
                        Persona
                                .builder()
                                .pagina(Paginas
                                                .builder()
                                                .nPaginaNro((int)VistaPersonas.jsPaginaNro.getValue())
                                                .nCantidadFilas((int) VistaPersonas.jsCantidadFilas.getValue())
                                                .build()
                                )
                                .build()
                );
            });

            //Eventos de usuario.***********************************************
            addEventListener("EVENT_USUARIO", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                VistaUsuarios.llenarTablaUsuarios();
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

            //Evento de VistaDeudas de clientes.*************************************
            addEventListener("EVENT_DEUDA", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                VistaDeudas.llenarTabla();
            });

            //Evento de VistaAlmacenes del sistema.**********************************
            addEventListener("EVENT_ALMACEN", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                VistaAlmacenes.llenarTabla(
                        Almacen
                                .builder()
                                .nombre("")
                                .build()
                );
            });
            
            //Evento de VistaAlmacenes del sistema.**********************************
            addEventListener("EVENT_PERSONA", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO,
                        "Event [{0}] occured {1} time(s)",
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
            });
        } catch (SQLException ex) {
            LOG.log(
                    Level.SEVERE,
                    ex.getMessage(),
                    ex
            );
            return false;
        }
        return true;
    }

}
