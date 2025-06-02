package sur.softsurena.formularios;

import java.io.File;
import org.testng.annotations.Test;
import xy.ui.testing.util.TestingUtils;

public class frmLoginNGTest {

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
