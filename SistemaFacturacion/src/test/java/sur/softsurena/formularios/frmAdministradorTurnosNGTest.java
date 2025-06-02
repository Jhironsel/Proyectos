package sur.softsurena.formularios;

import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
public class frmAdministradorTurnosNGTest {
    

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Prueba de la instacia de administracion de turnos.
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                frmAdministradorTurnos.getInstance(),
                "Error al cargar frmAdministradorTurnos."
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Prueba o consulta que verifica la tabla de reporte.
                          """
    )
    public void testCrearReporte() {
        
        JTable result = frmAdministradorTurnos.crearReporte("sysdba");
        
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
