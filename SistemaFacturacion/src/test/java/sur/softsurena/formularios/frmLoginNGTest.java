package sur.softsurena.formularios;

import java.io.File;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import xy.ui.testing.util.TestingUtils;

public class frmLoginNGTest {


    public frmLoginNGTest() {
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
            priority = 1,
            description = """
                          Test swing de login.
                          """
    )
    public void testParametros() throws Exception {

        TestingUtils.assertSuccessfulReplay(
                new File("testSwing/testParametros.stt")
        );
    }
}
