package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Clase que realiza los test de los sexo de las personas. Comprueba que los 
 * sexo estan definidos en el sistema. 
 * 
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_SexoNGTest {

    @Test
    public void testGetSexoList() {
        assertFalse(
                M_Sexo.getSexoList().isEmpty(), 
                "La lista de Sexo no cargo correctamente."
        );
    }

}