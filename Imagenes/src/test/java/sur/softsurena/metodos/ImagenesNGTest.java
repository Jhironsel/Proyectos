package sur.softsurena.metodos;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
public class ImagenesNGTest {
    
    public ImagenesNGTest() {
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
            description = """
                          """
    )
    public void testGetIcono_0args() {
        Imagenes instance = new Imagenes("NoImageTransp 96 x 96.png");
        
        assertNotNull(
                instance.getIcono(), 
                "Obtenemos null de la imagen."
        );
        
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testGetIcono_int_int() {
        Imagenes instance = new Imagenes("NoImageTransp 96 x 96.png");
        
        assertTrue(
                instance.getIcono(42, 42).getIconHeight() != 0,
                "Icono no es mayor que cero."
        );
    }

    @Test
    public void testGetRuta() {
    }
    
}
