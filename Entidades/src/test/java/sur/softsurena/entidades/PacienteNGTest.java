package sur.softsurena.entidades;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
public class PacienteNGTest {

    public PacienteNGTest() {
        System.out.println("sur.softsurena.entidades.PacienteNGTest.<init>()");
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
    
    @Test
    public void testToString() {}

    @Test
    public void testGetJSON() {}

    @Test
    public void testBuilder() {}

    @Test
    public void testGetPersona() {}

    @Test
    public void testGetPesoNacimiento() {}

    @Test
    public void testGetAltura() {}

    @Test
    public void testGetPerimetroCefalico() {}

    @Test
    public void testGetCesarea() {}

    @Test
    public void testGetTiempoGestacion() {}

    @Test
    public void testGetMasaCefalica() {}
}
