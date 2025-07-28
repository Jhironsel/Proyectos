package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaCalculoEfectivo;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaCalculoEfectivoNGTest {


    @Test(
            enabled = false
    )
    public void testGetResp() {
        VistaCalculoEfectivo instance = null;
        int expResult = 0;
        int result = instance.getResp();
        assertEquals(result, expResult);
    }

}