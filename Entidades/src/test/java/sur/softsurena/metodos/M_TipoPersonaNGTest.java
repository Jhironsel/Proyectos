
package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_TipoPersonaNGTest {


    @Test
    public void testGetTipoPersonaList() {
        assertFalse(
                M_TipoPersona.getTipoPersonaList().isEmpty(), 
                "La lista de Tipo de Personas esta vacia."
        );
    }

}