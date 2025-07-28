package sur.softsurena.vistas;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaProveedoresNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                new VistaProveedores(), 
                "Error al instanciar el formulario frmProveedores."
        );
    }

}