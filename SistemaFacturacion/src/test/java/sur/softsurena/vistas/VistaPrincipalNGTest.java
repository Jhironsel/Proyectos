package sur.softsurena.vistas;

import sur.softsurena.vista.VistaUsuarios;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Entidades;
import static sur.softsurena.vistas.VistaPrincipal.abrirFormulario;
import sur.softsurena.vista.VistaPersonas;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaPrincipalNGTest {

    private VistaPrincipal principal;
    private Entidades entidades;

    @Test
    public void testInicial() {
        principal = new VistaPrincipal();
        entidades = Entidades
                .builder()
                .cliente(true)
                .empleado(true)
                .proveedor(true)
                .build();

        assertNotNull(
                principal,
                "Objecto principal es nulo."
        );

    }

//    private void teclaEspacio() {
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_SPACE);
//            robot.keyRelease(KeyEvent.VK_SPACE);
//        } catch (AWTException ex) {
//            Logger.getLogger(VistaPrincipalNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void teclaEnter() {
//
//        try {
//            Robot robot = new Robot();
//            //robot.delay(500);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//        } catch (AWTException ex) {
//            Logger.getLogger(VistaPrincipalNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private void teclasMagicas() {
//        try {
//            Robot robot = new Robot();
//            robot.delay(500);
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_ALT);
//            robot.keyPress(KeyEvent.VK_SHIFT);
//            robot.keyPress(KeyEvent.VK_ALT_GRAPH);
//            robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
//            robot.keyRelease(KeyEvent.VK_SHIFT);
//            robot.keyRelease(KeyEvent.VK_ALT);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//        } catch (AWTException ex) {
//            Logger.getLogger(VistaPrincipalNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @Test(
            dependsOnMethods = "testInicial"
    )
    public void testCerrarTodos() {
        VistaPrincipal instance = new VistaPrincipal();
        instance.cerrarTodos();
    }

    @Test(
            dependsOnMethods = "testInicial"
    )
    public void testAbrirFormulario() {
        abrirFormulario(new VistaRestaurarDatos());
        abrirFormulario(new VistaPersonas(entidades));
        abrirFormulario(new VistaUsuarios());
        abrirFormulario(new VistaMovimientoEntradaSalida());
        abrirFormulario(new VistaGraficos());
        abrirFormulario(new VistaProductos());
        abrirFormulario(new VistaFacturas());
        abrirFormulario(new VistaAdministradorTurnos());
        abrirFormulario(new VistaDeudas());
        abrirFormulario(new VistaProveedores());
        abrirFormulario(new VistaAlmacenes());
        abrirFormulario(new VistaNomina());
        abrirFormulario(new VistaGestorGastos());
    }

    @Test(
            dependsOnMethods = "testInicial"
    )
    public void testAbrirFormularioCentralizado() {
        VistaPrincipal.abrirFormularioCentralizado(
                new VistaPersonas(entidades)
        );
    }

}
