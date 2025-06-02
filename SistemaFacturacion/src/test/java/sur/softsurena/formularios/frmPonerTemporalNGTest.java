package sur.softsurena.formularios;

import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
public class frmPonerTemporalNGTest {

    /**
     * Test of repararRegistro2 method, of class frmPonerTemporal.
     */
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testRepararRegistro2() {
        frmPonerTemporal instance = frmPonerTemporal.getInstance(null, true);
        instance.repararRegistro2();
    }
    
}
