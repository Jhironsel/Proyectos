package sur.softsurena.metodos;

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
        assertFalse(
                M_Cajero.select().isEmpty(), 
                "La tabla de cajero NO contiene usuarios"
        );
    }
}
