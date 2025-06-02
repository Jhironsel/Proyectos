package sur.softsurena.metodos;

import java.util.List;
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

    @Test(
            enabled = false
    )
    public void testGenerarCarton() {
        List expResult = null;
        List result = M_Carton_Bingo.generarCarton();
        assertEquals(result, expResult);
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
