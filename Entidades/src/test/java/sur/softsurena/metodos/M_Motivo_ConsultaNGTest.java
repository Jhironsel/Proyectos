package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.MotivoConsulta;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_Motivo_ConsultaNGTest {

    @Test
    public void testSelect() {
        assertNotNull(
                M_Motivo_Consulta.select(),
                "Error al consultar los motivos de consultas."
        );
    }
    
    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testBorrarMotivoConsulta() {
        MotivoConsulta mc = null;
        String expResult = "";
        String result = M_Motivo_Consulta.delete(mc);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testAgregarMotivo() {
        String m = "";
        boolean expResult = false;
        boolean result = M_Motivo_Consulta.insert(m);
        assertEquals(result, expResult);
    }

    

}