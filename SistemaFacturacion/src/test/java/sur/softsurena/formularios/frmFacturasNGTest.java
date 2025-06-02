package sur.softsurena.formularios;

import java.awt.event.ActionEvent;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmFacturasNGTest {
    
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetIdCliente() {
        frmFacturas instance = null;
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
        frmFacturas instance = null;
        instance.setIdCliente(idCliente);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        frmFacturas expResult = null;
        frmFacturas result = frmFacturas.getInstance();
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
        frmFacturas instance = null;
        instance.actionPerformed(actionEvent);
    }

}