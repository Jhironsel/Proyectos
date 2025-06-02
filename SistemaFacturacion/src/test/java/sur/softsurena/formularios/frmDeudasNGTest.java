package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmDeudasNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Permite verificar si el frmDeudas puede ser instanciado.
                          permite otras cosas.
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                frmDeudas.getInstance(),
                "Se obtuvo un error al instanciar frmDeudas."
        );
    }

}