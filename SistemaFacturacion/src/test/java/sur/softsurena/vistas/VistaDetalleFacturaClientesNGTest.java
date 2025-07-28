package sur.softsurena.vistas;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaDetalleFacturaClientesNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testTablaClientes() {
        Assert.assertNotNull(new VistaDetalleFacturaClientes(),
                "No puede ser instanaciada la clase frmDetalleFacturaClientes."
        );
    }

}
