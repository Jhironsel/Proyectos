package sur.softsurena.vistas;

import java.io.File;
import org.testng.annotations.Test;
import xy.ui.testing.util.TestingUtils;

@Test()
public class VistaEntradaProductoNGTest {
    @Test
    public void testConsultarTituloVentanaEntradaProducto() throws Exception{
        TestingUtils.assertSuccessfulReplay(
                new File("testSwing/testConsultarTituloVentanaEntradaProducto.stt")
        );
    }
}