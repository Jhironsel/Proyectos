package sur.softsurena.metodos;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import static sur.softsurena.metodos.M_E_S_SYS.REGISTRO_EXITOSO;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_E_S_SYSNGTest {

    public M_E_S_SYSNGTest() {
        System.out.println("sur.softsurena.metodos.M_E_S_SYSNGTest.<init>()");
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
//        Conexion.getCnn().close();
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
                          Prueba que realiza la insersion de una imagen 
                          """
    )
    public void testInsertLogo() {
        File file = new File("Imagenes/ImagenPrueba.png");
        
        Resultado result = M_E_S_SYS.insertLogo(file);
        assertEquals(
                result,
                Resultado
                    .builder()
                    .mensaje(REGISTRO_EXITOSO)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build()
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          
                          """
    )
    public void testGetLogo() {
        
        String result = M_E_S_SYS.getLogo();
        
        ImageIcon imagenDecode64 = Utilidades.imagenDecode64(
                result, 
                128, 
                128
        );
        
        assertTrue(
                imagenDecode64.getIconHeight() > 0,
                "La imagen no tiene altura."
        );
        
        assertTrue(
                imagenDecode64.getIconWidth() > 0,
                "La imagen no tiene anchura."
        );
        
    }
}