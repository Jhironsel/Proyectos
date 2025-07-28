package sur.softsurena.vistas;

import sur.softsurena.vista.VistaAcercaDe;
import javax.swing.JLabel;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.utilidades.Resultado;

/**
 * Clase encargada de testear el formulario frmAcercaDe.
 * <p>
 * @author jhironsel
 */
@Test(
        groups = "init2"
)
public class VistaAcercaDeNGTest {

        
    private final VistaAcercaDe acercaDe;

    public VistaAcercaDeNGTest() {
        assertNotNull(
                Conexion.getInstance(
                        "sysdba",
                        "1",
                        "SoftSurena.db",
                        "localhost",
                        "3050",
                        "NONE"
                ),
                "Error obteniendo instancia de Conexion."
        );
        
        Resultado resultado = Conexion.verificar();
        
        assertTrue(
                resultado.getEstado(), 
                "Error al conectarse al sistema."
        );
        
        acercaDe = new VistaAcercaDe(null, false);
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
