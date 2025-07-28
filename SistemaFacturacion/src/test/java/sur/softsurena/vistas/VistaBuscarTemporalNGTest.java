package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaBuscarTemporal;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaBuscarTemporalNGTest {

    public VistaBuscarTemporalNGTest() {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetFactura() {
        VistaBuscarTemporal instance = null;
        String expResult = "";
        String result = instance.getFactura();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetFactura() {
        String factura = "";
        VistaBuscarTemporal instance = null;
        instance.setFactura(factura);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testIsAceptar() {
        VistaBuscarTemporal instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptar();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetAceptar() {
        boolean aceptar = false;
        VistaBuscarTemporal instance = null;
        instance.setAceptar(aceptar);
    }
}