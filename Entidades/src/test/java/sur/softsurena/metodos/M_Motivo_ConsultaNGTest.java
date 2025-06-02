package sur.softsurena.metodos;

import java.sql.ResultSet;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Motivo_Consulta;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_Motivo_ConsultaNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testBorrarMotivoConsulta() {
        Motivo_Consulta mc = null;
        String expResult = "";
        String result = M_Motivo_Consulta.borrarMotivoConsulta(mc);
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
        boolean result = M_Motivo_Consulta.agregarMotivo(m);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetMotivo() {
        ResultSet expResult = null;
        ResultSet result = M_Motivo_Consulta.getMotivo();
        assertEquals(result, expResult);
    }

}