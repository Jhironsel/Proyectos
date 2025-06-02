package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmAutorizacionNGTest {

    public frmAutorizacionNGTest() {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testIsAceptado() {
        frmAutorizacion instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptado();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetAceptar() {
        String idUsuario = "";
        String clave = "";
        frmAutorizacion instance = null;
        instance.setAceptar(idUsuario, clave);
    }

}