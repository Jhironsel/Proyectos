package sur.softsurena.vistas;

import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaAdministradorTurnosNGTest {
    

    @Test(
            enabled = true,
            priority = 0
    )
    public void testGetInstance() {
        assertNotNull(
                new VistaAdministradorTurnos(),
                "Error al cargar frmAdministradorTurnos."
        );
    }

    @Test(
            enabled = true,
            priority = 1
    )
    public void testCrearReporte() {
        
        JTable result = VistaAdministradorTurnos.crearReporte("sysdba");
        
        assertNotNull(
                result,
                "Tabla de crear reporte de usuario no instanciada."
        );
        
        assertFalse(
                result.getRowCount() > 0,
                "No existe registros en el formulario."
        );
    }

}
