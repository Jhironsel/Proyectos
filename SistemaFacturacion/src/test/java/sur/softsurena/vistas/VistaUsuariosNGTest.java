package sur.softsurena.vistas;

import sur.softsurena.vista.VistaUsuarios;
import java.io.File;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import xy.ui.testing.util.TestingUtils;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaUsuariosNGTest {

    private static VistaUsuarios vistaUsuarios;
    
    @Test
    public void testGetInstance() {
        vistaUsuarios = new VistaUsuarios();
        assertNotNull(
                vistaUsuarios,
                "Error al instanciar el frmUsuarios en el sistema."
        );
    }
    
    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testGetInstance"
    )
    public void testLlenarTablaUsuarios() {
        assertNotNull(
                VistaUsuarios.llenarTablaUsuarios(),
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
