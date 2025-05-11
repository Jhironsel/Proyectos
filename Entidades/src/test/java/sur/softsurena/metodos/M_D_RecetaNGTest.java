package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.entidades.D_Receta;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_D_RecetaNGTest {

    public M_D_RecetaNGTest() {
        System.out.println("sur.softsurena.metodos.M_D_RecetaNGTest.<init>()");
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
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testAgregarRecetaDetalle() {
        List<D_Receta> dr = null;
        M_D_Receta.agregarRecetaDetalle(dr);
    }

}