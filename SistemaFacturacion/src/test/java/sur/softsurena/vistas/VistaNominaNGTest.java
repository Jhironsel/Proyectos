package sur.softsurena.vistas;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaNominaNGTest {

    @Test(
            enabled = false
    )
    public void testGetInstance() {
        assertNotNull(
                new VistaNomina(),
                "Error al instanciar frmNomina del sistema."
        );
    }

}