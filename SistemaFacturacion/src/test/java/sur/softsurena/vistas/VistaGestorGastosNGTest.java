package sur.softsurena.vistas;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaGestorGastosNGTest {


    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        
        assertNotNull(
                new VistaGestorGastos(), 
                "Error al iniciarlizar el frmGestorGastos"
        );
    }

}