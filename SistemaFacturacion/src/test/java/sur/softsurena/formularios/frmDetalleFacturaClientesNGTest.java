package sur.softsurena.formularios;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmDetalleFacturaClientesNGTest {

    public frmDetalleFacturaClientesNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

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
