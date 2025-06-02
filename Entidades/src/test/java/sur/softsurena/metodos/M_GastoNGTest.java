package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Gasto;
import sur.softsurena.utilidades.Resultado;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_GastoNGTest {
    
    @Test(
            enabled = false
    )
    public void testAgregarGastosPorTurno() {
        Gasto gasto = null;
        Resultado expResult = null;
        Resultado result = M_Gasto.agregarGastosPorTurno(gasto);
        assertEquals(result, expResult);
    }
    
}
