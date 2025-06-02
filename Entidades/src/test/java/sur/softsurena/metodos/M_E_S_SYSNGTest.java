package sur.softsurena.metodos;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
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

    @Test
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
            dependsOnMethods = "testInsertLogo"
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