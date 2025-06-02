package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmNominaNGTest {

    @Test(
            enabled = false
    )
    public void testGetInstance() {
        assertNotNull(
                frmNomina.getInstance(),
                "Error al instanciar frmNomina del sistema."
        );
    }

}