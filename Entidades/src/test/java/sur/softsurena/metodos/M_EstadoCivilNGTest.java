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
public class M_EstadoCivilNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = "Verifica que los estados civiles de las personas esten bien definidos en el sistema."
    )
    public void testGetEstadoCivilList() {
        assertFalse(
                M_EstadoCivil.getEstadoCivilList().isEmpty(), 
                "La lista de estado civil está vacia."
        );
    }

}