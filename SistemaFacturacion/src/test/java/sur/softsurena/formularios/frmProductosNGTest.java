package sur.softsurena.formularios;

import java.io.File;
import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import xy.ui.testing.Tester;
import xy.ui.testing.util.TestingUtils;

/**
 *
 * @author jhironsel
 */
@Test(enabled = true)
public class frmProductosNGTest {
    
    @Test
    public void testGetInstance() {
        assertNotNull(
                frmProductos.getInstance(new frmPrincipal()),
                "Error al instanciar frmProductos."
        );
    }
//------------------------------------------------------------------------------

    @Test(
            dependsOnMethods = "testGetInstance"
    )
    public void testLlenarTablaProductos() {
        JTable tabla = frmProductos.llenarTablaProductos("");

        assertNotNull(
                tabla,
                "La tabla de producto se encuentra nula."
        );

        assertTrue(
                tabla.getRowCount() > 0,
                """
                La tabla de producto contiene informacion.
                """
        );
    }
//------------------------------------------------------------------------------

    @Test(
            dependsOnMethods = "testLlenarTablaProductos"
    )
    public void testInsertProducto() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testInsertProducto.stt")
        );
    }
//------------------------------------------------------------------------------

    @Test(
            dependsOnMethods = "testInsertProducto"
    )
    public void testUpdateProducto() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testUpdateProducto.stt")
        );
    }
//------------------------------------------------------------------------------

    @Test(
            dependsOnMethods = "testUpdateProducto"
    )
    public void testDeleteProducto() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testDeleteProducto.stt")
        );
    }
}
