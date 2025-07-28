package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaCobrosClientes;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test
public class VistaCobrosClientesNGTest {

    @Test(
            enabled = false
    )
    public void testGetIdTurno() {
        VistaCobrosClientes instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testSetIdTurno() {
        int idTurno = 0;
        VistaCobrosClientes instance = null;
        instance.setIdTurno(idTurno);
    }

}