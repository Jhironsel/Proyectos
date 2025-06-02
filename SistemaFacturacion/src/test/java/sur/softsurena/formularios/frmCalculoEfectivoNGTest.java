package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmCalculoEfectivoNGTest {


    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetResp() {
        frmCalculoEfectivo instance = null;
        int expResult = 0;
        int result = instance.getResp();
        assertEquals(result, expResult);
    }

}