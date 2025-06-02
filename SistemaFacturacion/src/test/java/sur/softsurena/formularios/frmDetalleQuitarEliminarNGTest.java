package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmDetalleQuitarEliminarNGTest {


    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetOpcion() {
        frmDetalleQuitarEliminar instance = null;
        int expResult = 0;
        int result = instance.getOpcion();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetOpcion() {
        int opcion = 0;
        frmDetalleQuitarEliminar instance = null;
        instance.setOpcion(opcion);
    }

}
