package sur.softsurena.vistas;

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
@Test(
        dependsOnGroups = "init2",
        groups = "testSwingProducto"
)
public class VistaProductosNGTest {
    
    @Test
    public void testGetInstance() {
        assertNotNull(new VistaProductos(),
                "Error al instanciar frmProductos."
        );
    }
//------------------------------------------------------------------------------

    @Test(
            dependsOnMethods = "testGetInstance"
    )
    public void testLlenarTablaProductos() {
        JTable tabla = VistaProductos.llenarTablaProductos("");

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
