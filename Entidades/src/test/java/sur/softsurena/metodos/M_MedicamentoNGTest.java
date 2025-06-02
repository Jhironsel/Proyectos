package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Medicamento;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_MedicamentoNGTest {

    @Test(
            enabled = false
    )
    public void testSelect() {
        List<Medicamento> result = M_Medicamento.select();
        assertNotNull(
                result,
                ""
        );
    }

    @Test(
            enabled = false
    )
    public void testUpdate() {
        Medicamento m = null;
        String expResult = "";
        Resultado result = M_Medicamento.update(m);
        assertEquals(result, expResult);
    }

}
