package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaSelectorArchivo;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaSelectorArchivoNGTest {


    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetArchivo() {
        VistaSelectorArchivo instance = null;
        String expResult = "";
        String result = instance.getArchivo();
        assertEquals(result, expResult);
    }

}