package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_CajeroNGTest {

    @Test
    public void testGetCajeros() {
        List result = M_Cajero.select();
        assertFalse(
                result.isEmpty(), 
                "La tabla de cajero NO contiene usuarios"
        );
    }
}
