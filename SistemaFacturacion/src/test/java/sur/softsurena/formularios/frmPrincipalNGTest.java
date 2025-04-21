package sur.softsurena.formularios;

import sur.softsurena.modulo_comun.frmUsuarios;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import static sur.softsurena.formularios.frmPrincipal.abrirFormulario;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmPrincipalNGTest {

    private frmPrincipal principal;

    public frmPrincipalNGTest() {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "NONE"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testInicial() {
        principal = new frmPrincipal();

        assertNotNull(
                principal,
                "Objecto principal es nulo."
        );

    }

    private void teclaEspacio() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
        } catch (AWTException ex) {
            Logger.getLogger(frmPrincipalNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void teclaEnter() {

        try {
            Robot robot = new Robot();
            //robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException ex) {
            Logger.getLogger(frmPrincipalNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void teclasMagicas() {
        try {
            Robot robot = new Robot();
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_ALT_GRAPH);
            robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (AWTException ex) {
            Logger.getLogger(frmPrincipalNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test(
            enabled = true,
            priority = 9,
            description = """
                          Test que cierra todos los JInternalFrames.
                          """
    )
    public void testCerrarTodos() {
        frmPrincipal instance = new frmPrincipal();
        instance.cerrarTodos();
    }


    @Test(
            enabled = true,
            priority = 9,
            description = """
                          Permite verificar si una ventana interna abre
                          correctamente.
                          """
    )
    public void testAbrirFormulario() {
        abrirFormulario(frmMovimientoEntradaSalida.getInstance());
        abrirFormulario(new frmRestaurarDatos());
        abrirFormulario(frmGraficos.getInstance());
        abrirFormulario(frmClientes.getInstance());
        abrirFormulario(frmProductos.getInstance(new frmPrincipal()));
        abrirFormulario(frmUsuarios.getInstance());
        abrirFormulario(frmFacturas.getInstance());
        abrirFormulario(frmAdministradorTurnos.getInstance());
        abrirFormulario(frmDeudas.getInstance());
        abrirFormulario(frmProveedores.getInstance());
        abrirFormulario(frmAlmacenes.getInstance());
        abrirFormulario(frmNomina.getInstance());
        abrirFormulario(frmGestorGastos.getInstance());
    }


    @Test(
            enabled = true,
            priority = 9,
            description = """
                          Validacion que se realizar para obtener una ventana
                          centralizada.
                          """
    )
    public void testAbrirFormularioCentralizado() {
        frmPrincipal.abrirFormularioCentralizado(frmClientes.getInstance());
    }

}
