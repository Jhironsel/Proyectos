package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmCobrosDeudasNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetNombreCajero() {
        frmCobrosDeudas instance = null;
        String expResult = "";
        String result = instance.getNombreCajero();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetIdTurno() {
        frmCobrosDeudas instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(result, expResult);
    }
}