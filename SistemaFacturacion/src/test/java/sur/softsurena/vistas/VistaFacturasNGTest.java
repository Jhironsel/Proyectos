package sur.softsurena.vistas;

import java.awt.event.ActionEvent;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaFacturasNGTest {
    
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetIdCliente() {
        VistaFacturas instance = null;
        Integer expResult = null;
        Integer result = instance.getIdCliente();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetIdCliente() {
        Integer idCliente = null;
        VistaFacturas instance = null;
        instance.setIdCliente(idCliente);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        VistaFacturas expResult = null;
        VistaFacturas result = new VistaFacturas();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testActionPerformed() {
        ActionEvent actionEvent = null;
        VistaFacturas instance = null;
        instance.actionPerformed(actionEvent);
    }

}