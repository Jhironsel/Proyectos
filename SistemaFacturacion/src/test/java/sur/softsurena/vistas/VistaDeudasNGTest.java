package sur.softsurena.vistas;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaDeudasNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Permite verificar si el frmDeudas puede ser instanciado.
                          permite otras cosas.
                          """
    )
    public void testGetInstance() {
        assertNotNull(new VistaDeudas(),
                "Se obtuvo un error al instanciar frmDeudas."
        );
    }

}