package sur.softsurena.formularios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
public class frmPonerTemporalNGTest {
    
    public frmPonerTemporalNGTest() {
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

    /**
     * Test of repararRegistro2 method, of class frmPonerTemporal.
     */
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testRepararRegistro2() {
        frmPonerTemporal instance = frmPonerTemporal.getInstance(null, true);
        instance.repararRegistro2();
    }
    
}
