package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmSelectorArchivoNGTest {


    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetArchivo() {
        frmSelectorArchivo instance = null;
        String expResult = "";
        String result = instance.getArchivo();
        assertEquals(result, expResult);
    }

}