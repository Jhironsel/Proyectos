package sur.softsurena.formularios;

import sur.softsurena.modulo_comun.frmUsuarios;
import java.io.File;
import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import xy.ui.testing.util.TestingUtils;

/**
 *
 * @author jhironsel
 */
@Test
public class frmUsuariosNGTest {
    
    @Test
    public void testGetInstance() {
        assertNotNull(
                frmUsuarios.getInstance(),
                "Error al instanciar el frmUsuarios en el sistema."
        );
    }
    
    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testGetInstance"
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
            dependsOnMethods = "testLlenarTablaUsuarios"
    )
    public void testInsertUsuario() throws Exception {
        TestingUtils.assertSuccessfulReplay(
                new File("testSwing/testInsertUsuario.stt")
        );
    }
}
