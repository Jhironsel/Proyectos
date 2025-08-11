package sur.softsurena.vistas;

import java.io.File;
import org.testng.annotations.Test;
import xy.ui.testing.Tester;
import xy.ui.testing.util.TestingUtils;

@Test(
        //dependsOnGroups = "init2",
        threadPoolSize = 0b100
)
public class VistaClientesNGTest {

    //--------------------------------------------------------------------------
    @Test
    public void testSwingProvinciaMunicipioDistrito() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testProvinciaMunicipioDistrito.stt")
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testSwingProvinciaMunicipioDistrito"
    )
    public void testSwingInsertCliente() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testInsertCliente.stt")
        );
    }

//------------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testSwingInsertCliente"
    )
    public void testSwingUpdateCliente() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testUpdateCliente.stt")
        );
    }

//------------------------------------------------------------------------------
    @Test(
           dependsOnMethods = "testSwingUpdateCliente"
    )
    public void testSwingDeleteCliente() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testBorrarCliente.stt")
        );
    }
}
