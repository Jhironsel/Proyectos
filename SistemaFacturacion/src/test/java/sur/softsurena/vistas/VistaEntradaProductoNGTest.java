package sur.softsurena.vistas;

import java.io.File;
import org.testng.annotations.Test;
import xy.ui.testing.Tester;
import xy.ui.testing.util.TestingUtils;

@Test
public class VistaEntradaProductoNGTest {
    @Test
    public void testConsultarTituloVentanaEntradaProducto() throws Exception{
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testConsultarTituloVentanaEntradaProducto.stt")
        );
    }
    
    @Test
    public void testEntradaProducto() throws Exception{
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testEntradaProducto.stt")
        );
    }
}