package sur.softsurena.vistas;

import sur.softsurena.vista.VistaBusquedaPersona;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import newscomponents.RSButtonGradientIcon_new;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import rojeru_san.RSMTextFull;
import sur.softsurena.entidades.Persona;

/**
 * TODO 24/11/2024 Crear prueba para esta clase. 
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaBusquedaClienteNGTest {

    public VistaBusquedaClienteNGTest() {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetPersona() {
        VistaBusquedaPersona persona = null;
        Persona expResult = null;
        Persona result = persona.getPersona();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetBtnAceptar() {
        VistaBusquedaPersona instance = null;
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
        VistaBusquedaPersona instance = null;
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
        VistaBusquedaPersona instance = null;
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
        VistaBusquedaPersona instance = null;
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
        VistaBusquedaPersona instance = null;
        RSMTextFull expResult = null;
        RSMTextFull result = instance.getTxtCriterio();
        assertEquals(result, expResult);
    }
}