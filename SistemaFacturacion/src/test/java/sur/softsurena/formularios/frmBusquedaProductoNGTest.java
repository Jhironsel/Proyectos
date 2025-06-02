package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmBusquedaProductoNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetRespuesta() {
        frmBusquedaProducto instance = null;
        String expResult = "";
        String result = instance.getRespuesta();
        assertEquals(result, expResult);
    }

}