
package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_TipoPersonaNGTest {

    public M_TipoPersonaNGTest() {
        System.out.println("sur.softsurena.metodos.M_TipoPersonaNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = true,
            priority = 0,
            description = "Metodo que proporciona una lista de tipos de personas que se maneja en el sistema."
    )
    public void testGetTipoPersonaList() {
        assertFalse(
                M_TipoPersona.getTipoPersonaList().isEmpty(), 
                "La lista de Tipo de Personas esta vacia."
        );
    }

}