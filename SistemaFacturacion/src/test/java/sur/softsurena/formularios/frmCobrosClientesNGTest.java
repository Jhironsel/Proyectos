package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test
public class frmCobrosClientesNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetIdTurno() {
        frmCobrosClientes instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetIdTurno() {
        int idTurno = 0;
        frmCobrosClientes instance = null;
        instance.setIdTurno(idTurno);
    }

}