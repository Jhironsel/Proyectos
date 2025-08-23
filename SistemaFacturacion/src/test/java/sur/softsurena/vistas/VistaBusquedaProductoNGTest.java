package sur.softsurena.vistas;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaBusquedaProductoNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetRespuesta() {
        VistaBusquedaProducto instance = null;
        String expResult = "";
        String result = instance.getRespuesta();
        assertEquals(result, expResult);
    }

}