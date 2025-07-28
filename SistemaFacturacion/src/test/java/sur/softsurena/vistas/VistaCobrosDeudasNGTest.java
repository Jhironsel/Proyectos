package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaCobrosDeudas;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaCobrosDeudasNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetNombreCajero() {
        VistaCobrosDeudas instance = null;
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
        VistaCobrosDeudas instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(result, expResult);
    }
}