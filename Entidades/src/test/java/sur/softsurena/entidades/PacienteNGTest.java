package sur.softsurena.entidades;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;

/**
 *
 * @author jhironsel
 */
public class PacienteNGTest {

    public PacienteNGTest() {
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
    public void testToString() {
        Paciente instance
                = Paciente
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .pnombre("Jhironsel")
                                        .apellidos("Diaz Almonte")
                                        .build()
                        )
                        .build();

        assertEquals(instance.toString(), "Jhironsel Diaz Almonte");

        instance
                = Paciente
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .pnombre("Jhadiel")
                                        .snombre("Jhoandry")
                                        .apellidos("Diaz Paniagua")
                                        .build()
                        )
                        .build();
        
        assertEquals(instance.toString(), "Jhadiel Jhoandry Diaz Paniagua");
    }

    @Test
    public void testGetJSON() {
    }

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
