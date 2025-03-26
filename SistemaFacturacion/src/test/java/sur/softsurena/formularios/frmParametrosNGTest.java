package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.utilidades.Servidor;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmParametrosNGTest {

    public frmParametrosNGTest() {
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

    //TODO 15.03.2025 Este test te espera con ansia.
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testCargarParamentos() {
        frmParametros instance = frmParametros.getInstance();
        Servidor expResult = null;
        Servidor result = instance.cargarParamentos();
        assertEquals(result, expResult);
    }

}