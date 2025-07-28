package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

/**
 * 
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_Codigo_PostalNGTest {
    
    @Test
    public void testGetCodigoPostal() {
        assertFalse(
                M_Codigo_Postal.getCodigoPostal(0).isEmpty(), 
                "Registro de codigo postal principal no se encuentra."
        );
    }
    
}
