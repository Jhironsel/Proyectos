package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmBuscarTemporalNGTest {

    public frmBuscarTemporalNGTest() {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetFactura() {
        frmBuscarTemporal instance = null;
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
        frmBuscarTemporal instance = null;
        instance.setFactura(factura);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testIsAceptar() {
        frmBuscarTemporal instance = null;
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
        frmBuscarTemporal instance = null;
        instance.setAceptar(aceptar);
    }
}