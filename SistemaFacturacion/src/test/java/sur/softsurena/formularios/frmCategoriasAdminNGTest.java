package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmCategoriasAdminNGTest {

    public frmCategoriasAdminNGTest() {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetAceptar() {
        frmCategoriasAdmin instance = null;
        Boolean expResult = null;
        Boolean result = instance.getAceptar();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetAceptar() {
        Boolean aceptar = null;
        frmCategoriasAdmin instance = null;
        instance.setAceptar(aceptar);
    }

}