package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaAutorizacion;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaAutorizacionNGTest {

    public VistaAutorizacionNGTest() {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testIsAceptado() {
        VistaAutorizacion instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptado();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetAceptar() {
        String idUsuario = "";
        String clave = "";
        VistaAutorizacion instance = null;
        instance.setAceptar(idUsuario, clave);
    }

}