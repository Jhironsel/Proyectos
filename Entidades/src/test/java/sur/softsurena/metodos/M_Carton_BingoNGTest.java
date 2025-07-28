package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_Carton_BingoNGTest {

    @Test(
            enabled = false
    )
    public void testCheckBingo() {
        boolean expResult = false;
        boolean result = M_Carton_Bingo.checkBingo();
        assertEquals(result, expResult);
    }

    @Test
    public void testGenerarCarton() {
        assertNotNull(
                M_Carton_Bingo.generarCarton(), 
                "Error al generar carton de bingo...!"
        );
    }

    @Test(
            enabled = false
    )
    public void testGenerarCarton_int() {
        int cantidad = 0;
        Boolean expResult = null;
        Boolean result = M_Carton_Bingo.generarCarton(cantidad);
        assertEquals(result, expResult);
    }

}
