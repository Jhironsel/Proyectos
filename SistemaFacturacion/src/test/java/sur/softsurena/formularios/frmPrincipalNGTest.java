package sur.softsurena.formularios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import static sur.softsurena.formularios.frmPrincipal.abrirFormulario;
import sur.softsurena.metodos.M_ContactoEmail;
import sur.softsurena.metodos.M_ContactoTel;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.utilidades.Utilidades;

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
                "3050"
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

    //--------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 1,
            description = """
                          """
    )
    public void testGetMnuMantenimientoClientes() {
        principal.getMnuMantenimientoClientes().doClick();

        //----------------------------------------------------------------------
        frmClientes cliente = frmClientes.getInstance();

        assertTrue(
                frmClientes.getBtnNuevoCliente().isEnabled(),
                "El boton de nuevo cliente esta deshabilitado."
        );

        //----------------------------------------------------------------------
        frmClientes.getBtnNuevoCliente().requestFocus();
        frmClientes.getBtnNuevoCliente().doClick();

        //----------------------------------------------------------------------
        cliente.getTxtCedula().requestFocus();
        cliente.getTxtCedula().setValue(M_Generales.generarCedula());

        Timer timer = new Timer(4000, (
                ActionEvent e) -> {
            //Metodo aqui
            teclaEnter();
        });

        timer.setRepeats(false);
        timer.start();

        cliente.getBtnCedulaValidad().requestFocus();
        cliente.getBtnCedulaValidad().doClick();

        while (timer.isRunning()) {

        }

        if (!timer.isRunning()) {
            //----------------------------------------------------------------------
            cliente.getTxtPNombre().setText("Jhironsel");

            cliente.getTxtSNombre().setText("Arriba.");

            cliente.getTxtApellidos().setText("Diaz Almonte");

            frmClientes.getJcbPersona().setSelectedIndex(1);

            cliente.getDchFechaNacimiento().setDate(
                    Utilidades.stringToDate(
                            "07.04.1984",
                            "dd.MM.YYYY"
                    )
            );

            frmClientes.getJcbEstadoCivil().setSelectedIndex(2);

            frmClientes.getJcbSexo().setSelectedIndex(1);
        }
        //----------------------------------------------------------------------
        cliente.getJtpGeneralesDireccionContactos().requestFocus();
        cliente.getJtpGeneralesDireccionContactos().setSelectedComponent(
                cliente.getJpDireccion()
        );

        do {
            frmClientes.getJcbProvincias().requestFocus();
            teclasMagicas();
        } while (cliente.getJcbMunicipios().getItemCount() == 0);
        cliente.getJcbMunicipios().requestFocus();
        teclasMagicas();

        cliente.getJcbDistritoMunicipal().requestFocus();
        teclasMagicas();

        cliente.getTxtDireccion().setText("Direccion de pruebas.");

        cliente.getBtnAgregarDirecciones().requestFocus();
        cliente.getBtnAgregarDirecciones().doClick();

        //----------------------------------------------------------------------
        do {
            frmClientes.getJcbProvincias().requestFocus();
            teclasMagicas();
        } while (cliente.getJcbMunicipios().getItemCount() == 0);
        cliente.getJcbMunicipios().requestFocus();
        teclasMagicas();

        cliente.getJcbDistritoMunicipal().requestFocus();
        teclasMagicas();

        cliente.getTxtDireccion().setText("Direccion de pruebas 2.");

        timer = new Timer(3500, (
                ActionEvent e) -> {
            //Metodo aqui
            teclaEnter();
        });

        timer.setRepeats(false);
        timer.start();

        cliente.getBtnAgregarDirecciones().requestFocus();
        cliente.getBtnAgregarDirecciones().doClick();

        while (timer.isRunning()) {
        }

        //----------------------------------------------------------------------
        cliente.getJtpGeneralesDireccionContactos().requestFocus();
        cliente.getJtpGeneralesDireccionContactos().setSelectedComponent(
                cliente.getJpContactos()
        );

        cliente.getTxtTelelfonoMovil().requestFocus();
        cliente.getTxtTelelfonoMovil().setValue(
                M_ContactoTel.generarTelMovil()
        );
        cliente.getBtnAgregarTelefonoMovil().requestFocus();
        cliente.getBtnAgregarTelefonoMovil().doClick();

        cliente.getTxtTelelfonoMovil().requestFocus();
        cliente.getTxtTelelfonoMovil().setValue(
                M_ContactoTel.generarTelMovil()
        );
        cliente.getJrbMovil().setSelected(true);

        timer = new Timer(3500, (
                ActionEvent e) -> {
            //Metodo aqui
            teclaEnter();
        });
        timer.setRepeats(false);
        timer.start();
        cliente.getBtnAgregarTelefonoMovil().requestFocus();
        cliente.getBtnAgregarTelefonoMovil().doClick();

        while (timer.isRunning()) {
        }

        //----------------------------------------------------------------------
        cliente.getJtpContactos().requestFocus();
        cliente.getJtpContactos().setSelectedComponent(
                cliente.getJpCorreos()
        );

        //----------------------------------------------------------------------
        cliente.getTxtCorreo().requestFocus();
        cliente.getTxtCorreo().setText(
                M_ContactoEmail.generarCorreo()
        );

        cliente.getBtnAgregarCorreo().requestFocus();
        cliente.getBtnAgregarCorreo().doClick();

        cliente.getTxtCorreo().requestFocus();
        cliente.getTxtCorreo().setText(
                M_ContactoEmail.generarCorreo()
        );

        timer = new Timer(4000, (
                ActionEvent e) -> {
            //Metodo aqui
            teclaEnter();
        });

        timer.setRepeats(false);
        timer.start();

        cliente.getBtnAgregarCorreo().requestFocus();
        cliente.getBtnAgregarCorreo().doClick();
        //----------------------------------------------------------------------

        while (timer.isRunning()) {
        }

        JOptionPane.showMessageDialog(principal, "Espera");

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
        abrirFormulario(new frmMovimientoEntradaSalida());
        abrirFormulario(new frmRestaurarDatos());
        abrirFormulario(new frmGraficos());
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
