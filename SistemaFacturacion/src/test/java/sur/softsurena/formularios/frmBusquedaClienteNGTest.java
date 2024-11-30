package sur.softsurena.formularios;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import newscomponents.RSButtonGradientIcon_new;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rojeru_san.RSMTextFull;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.Cliente;

/**
 * TODO 24/11/2024 Crear prueba para esta clase. 
 * @author jhironsel
 */
@Test(enabled = false)
public class frmBusquedaClienteNGTest {

    public frmBusquedaClienteNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetMiTabla() {
        frmBusquedaCliente instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getMiTabla();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetPersona() {
        frmBusquedaCliente instance = null;
        Persona expResult = null;
        Cliente result = instance.getCliente();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetBtnAceptar() {
        frmBusquedaCliente instance = null;
        RSButtonGradientIcon_new expResult = null;
        RSButtonGradientIcon_new result = instance.getBtnAceptar();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetBtnCancelar() {
        frmBusquedaCliente instance = null;
        RSButtonGradientIcon_new expResult = null;
        RSButtonGradientIcon_new result = instance.getBtnCancelar();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetJScrollPane1() {
        frmBusquedaCliente instance = null;
        JScrollPane expResult = null;
        JScrollPane result = instance.getJScrollPane1();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetTblTabla() {
        frmBusquedaCliente instance = null;
        JTable expResult = null;
        JTable result = instance.getTblTabla();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetTxtCriterio() {
        frmBusquedaCliente instance = null;
        RSMTextFull expResult = null;
        RSMTextFull result = instance.getTxtCriterio();
        assertEquals(result, expResult);
    }
}