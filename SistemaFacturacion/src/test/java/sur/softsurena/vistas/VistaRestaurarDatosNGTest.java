package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaRestaurarDatos;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaRestaurarDatosNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testRun() {
        VistaRestaurarDatos instance = new VistaRestaurarDatos();
        instance.run();
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testIniciarHilo() {
        VistaRestaurarDatos instance = new VistaRestaurarDatos();
        instance.iniciarHilo();
    }

}