package sur.softsurena.FirebirdEventos;

import java.sql.SQLException;
import java.util.logging.Level;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import org.firebirdsql.gds.ng.WireCrypt;
import sur.softsurena.conexion.frmParametros;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.formularios.frmAlmacenes;
import sur.softsurena.formularios.frmClientes;
import static sur.softsurena.formularios.frmClientes.llenarTablaCorreos;
import static sur.softsurena.formularios.frmClientes.llenarTablaDirreciones;
import static sur.softsurena.formularios.frmClientes.llenarTablaTelefonos;
import sur.softsurena.formularios.frmDeudas;
import static sur.softsurena.formularios.frmProductos.llenarTablaProductos;
import static sur.softsurena.modulo_comun.frmUsuarios.llenarTablaUsuarios;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class FirebirdEventos extends FBEventManager {

    private static String USUARIO, CLAVE;

    public FirebirdEventos() {
        //super(GDSType.getType("PURE_JAVA"));
        super();
    }

    public static void main(String[] args) {
        FirebirdEventos eventos = new FirebirdEventos();

        FirebirdEventos.USUARIO = "sysdba";
        FirebirdEventos.CLAVE = "1";

        eventos.registro();
    }

    public synchronized boolean registro() {

        conectese(FirebirdEventos.USUARIO, FirebirdEventos.CLAVE);

        /*
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int num1 = (int) (Math.random() * tblProducto.getRowCount());

                        if (num1 == 0) {
                            num1 = 1;
                        }

                        tblProducto.setRowSelectionInterval(num1, num1);

                    }
                }
            }
        }
        
        new RSMaterialComponent.RSTableMetro(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        }
        tblProducto
        public static
         */
        try {
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
                frmClientes.llenarTablaClientes();
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
                        Almacen
                                .builder()
                                .id(-1)
                                .nombre("")
                                .build()
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

    public void conectese(String usuario, String clave) {
        FirebirdEventos.USUARIO = usuario;
        FirebirdEventos.CLAVE = clave;

        frmParametros parametros = frmParametros.getInstance();

        setUser(usuario);
        setPassword(clave);
        setServerName(parametros.cargarParamentos().getHost());
        setDatabaseName(parametros.cargarParamentos().getPathBaseDatos());
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
    }

}
