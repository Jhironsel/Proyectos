package sur.softsurena.vistas;

import java.io.File;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import xy.ui.testing.Tester;
import xy.ui.testing.util.TestingUtils;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = {"init2", "testSwingProducto"}
)
public class VistaCategoriasAdminNGTest {

    public VistaCategoriasAdminNGTest() {
    }

    @Test(
            enabled = false
    )
    public void testGetAceptar() {
        VistaCategoriasAdmin instance = null;
        Boolean expResult = null;
        Boolean result = instance.getAceptar();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testSetAceptar() {
        Boolean aceptar = null;
        VistaCategoriasAdmin instance = null;
        instance.setAceptar(aceptar);
    }
    
    //--------------------------------------------------------------------------
    @Test
    public void testSwingCategoria() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testCategoria.stt")
        );
    }

}