package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaCategoriasAdmin;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaCategoriasAdminNGTest {

    public VistaCategoriasAdminNGTest() {
    }

    @Test(
            enabled = false
    )
    public void testGetAceptar() {
        VistaCategoriasAdmin instance = null;
        Boolean expResult = null;
        Boolean result = instance.getAceptar();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testSetAceptar() {
        Boolean aceptar = null;
        VistaCategoriasAdmin instance = null;
        instance.setAceptar(aceptar);
    }

}