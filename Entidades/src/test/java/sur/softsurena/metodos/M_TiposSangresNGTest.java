package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_TiposSangresNGTest {
    
    @Test
    public void testGetTipoSangre() {
        assertFalse(
                M_TiposSangres.getList().isEmpty(), 
                "La lista de tipo de sangre no carga correctamente."
        );
    }

}