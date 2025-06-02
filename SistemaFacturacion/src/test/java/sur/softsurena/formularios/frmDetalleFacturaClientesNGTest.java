package sur.softsurena.formularios;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmDetalleFacturaClientesNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testTablaClientes() {
        Assert.assertNotNull(
                frmDetalleFacturaClientes.getInstance(),
                "No puede ser instanaciada la clase frmDetalleFacturaClientes."
        );
    }

}
