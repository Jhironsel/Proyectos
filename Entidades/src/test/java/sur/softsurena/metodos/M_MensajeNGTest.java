package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Mensaje;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_MensajeNGTest {

    @Test(
            enabled = false
    )
    public void testExisteMensaje() {
        Mensaje mensaje = null;
        M_Mensaje instance = new M_Mensaje();
        boolean expResult = false;
        boolean result = instance.existeMensaje(mensaje);
        assertEquals(result, expResult);
    }

}