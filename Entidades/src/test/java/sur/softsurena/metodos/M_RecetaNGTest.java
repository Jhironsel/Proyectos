package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.M_Receta;
import static sur.softsurena.metodos.M_M_Receta.REGISTRO_DE_RECETA_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_RecetaNGTest {

    public M_RecetaNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testInsert() {

        assertEquals(
                M_M_Receta.insert(
                        M_Receta
                                .builder()
                                .consulta(
                                        Consulta
                                                .builder()
                                                .id(0)
                                                .build())
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(REGISTRO_DE_RECETA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build());
    }

}
