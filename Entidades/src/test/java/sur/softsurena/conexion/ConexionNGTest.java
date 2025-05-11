package sur.softsurena.conexion;

import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
@Test(
        groups = "init",
        enabled = true
)
public class ConexionNGTest {

    public ConexionNGTest() {}

    @BeforeClass
    public void setUpClass() throws Exception {}

    @AfterClass
    public void tearDownClass() throws Exception {}

    @BeforeMethod
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    //--------------------------------------------------------------------------
    @Test(
            enabled = true
    )
    public void testGetInstance() {
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
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            dependsOnMethods = "testGetInstance"
    )
    public void testVerificar() {
        assertTrue(
                Conexion.verificar().getEstado(), 
                "Fallo en la verificacion."
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            dependsOnMethods = "testGetInstance"
    )
    public void testValidarUsario() {
        JTextField txtUsuario = new JTextField("sysdba");
        JPasswordField txtClave = new JPasswordField("1");
        JFrame jframe = null;
        assertTrue(
                Conexion.validarUsario(txtUsuario, txtClave, jframe),
                "Error en el metodo de validarUsuario."
        );
    }
    
    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            dependsOnMethods = {"testVerificar", "testValidarUsario"}
    )
    public void testGetCnn() {
        assertNotNull(
                Conexion.getCnn(), 
                "Conexion nula del sistema."
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = false
    )
    public void testSetInstanceNull() {
        Conexion.setInstanceNull();
    }

    @Test(
            enabled = false
    )
    public void testSetCnn() {
        Connection cnn = null;
        Conexion.setCnn(cnn);
    }

}
