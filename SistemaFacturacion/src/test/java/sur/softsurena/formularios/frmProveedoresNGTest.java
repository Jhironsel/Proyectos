package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmProveedoresNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                frmProveedores.getInstance(), 
                "Error al instanciar el formulario frmProveedores."
        );
    }

}