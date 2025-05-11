package sur.softsurena.formularios;

import sur.softsurena.modulo_comun.frmUsuarios;
import java.io.File;
import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import xy.ui.testing.util.TestingUtils;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init"
)
public class frmUsuariosNGTest {

    public frmUsuariosNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
//        Conexion.getInstance(
//                "sysdba",
//                "1",
//                "SoftSurena.db",
//                "localhost",
//                "3050",
//                "NONE"
//        );
//        assertTrue(
//                Conexion.verificar().getEstado(),
//                "Error al conectarse..."
//        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        frmUsuarios.getInstance().dispose();
//        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Test que se encarga de hacer la instalacia del
                          formulario.
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                frmUsuarios.getInstance(),
                "Error al instanciar el frmUsuarios en el sistema."
        );
    }
    
    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          """
    )
    public void testLlenarTablaUsuarios() {
        JTable tabla = frmUsuarios.llenarTablaUsuarios();

        assertNotNull(
                tabla,
                "Error en la tabla de usuarios."
        );

    }
    
    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 2,
            description = """
                          Prueba grafica del formulario de Usuario.
                          """
    )
    public void testInsertUsuario() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new File("testSwing/testInsertUsuario.stt")
        );
    }
}
