package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaDetalleQuitarEliminar;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaDetalleQuitarEliminarNGTest {


    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetOpcion() {
        VistaDetalleQuitarEliminar instance = null;
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
        VistaDetalleQuitarEliminar instance = null;
        instance.setOpcion(opcion);
    }

}
