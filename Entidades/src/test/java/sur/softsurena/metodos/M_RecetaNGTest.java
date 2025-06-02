package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
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
@Test(
        dependsOnGroups = "init"
)
public class M_RecetaNGTest {

    @Test(
            enabled = false
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
