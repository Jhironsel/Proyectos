package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmGestorGastosNGTest {


    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        
        assertNotNull(
                frmGestorGastos.getInstance(), 
                "Error al iniciarlizar el frmGestorGastos"
        );
    }

}