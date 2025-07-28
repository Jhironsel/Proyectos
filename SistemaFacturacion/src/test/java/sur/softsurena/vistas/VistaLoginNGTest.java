package sur.softsurena.vistas;

import java.io.File;
import org.testng.annotations.Test;
import xy.ui.testing.util.TestingUtils;

public class VistaLoginNGTest {

    @Test()
    public void testParametros() throws Exception {

        TestingUtils.assertSuccessfulReplay(
                new File("testSwing/testParametros.stt")
        );
    }
}
