package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import static org.testng.Assert.assertEquals;
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
    
    @Test(
            enabled = false
    )
    public void testGetCodigoPostal() {
        int id_provincia = 0;
        List expResult = null;
        List result = M_Codigo_Postal.getCodigoPostal(id_provincia);
        assertEquals(result, expResult);
    }
    
}
