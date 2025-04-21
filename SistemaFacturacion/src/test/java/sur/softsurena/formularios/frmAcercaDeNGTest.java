package sur.softsurena.formularios;

import sur.softsurena.modulo_comun.frmAcercaDe;
import javax.swing.JLabel;
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
@Test(enabled = true)
public class frmAcercaDeNGTest {

    private frmAcercaDe acercaDe;

    public frmAcercaDeNGTest() {
        acercaDe = frmAcercaDe.getInstance(null, false);
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
                          Metodo encargado de testear el formulario de acercaDe.
                          """
    )
    public void testSomeMethod() {
        assertNotNull(
                acercaDe,
                "El formulario de acercaDe no inicia o instancia."
        );
        
        acercaDe.setVisible(true);

        assertTrue(
                acercaDe.isVisible(),
                "No puede colocarse visible."
        );

        
        acercaDe.dispose();

        assertFalse(
                acercaDe.isVisible(),
                "No puede cerrarse el formulario frmAcercaDe."
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Prueba que se encarga de testear la foto mia.
                          """
    )
    public void testGetJlDesarrollador() {
        JLabel jlDesarrollador = acercaDe.getJlDesarrollador();
        assertNotNull(
                jlDesarrollador.getIcon(), 
                "Mi foto no aparece."
        );
    }

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          """
    )
    public void testGetJlLogo() {
        JLabel jlLogo = acercaDe.getJlLogo();
        assertNotNull(
                jlLogo.getIcon(), 
                "Error en el logo de acercaDe."
        );
    }

}
