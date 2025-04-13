package sur.softsurena.formularios;

import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;

/**
 *
 * @author jhironsel
 */
public class frmAdministradorTurnosNGTest {
    
    public frmAdministradorTurnosNGTest() {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "NONE"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
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
