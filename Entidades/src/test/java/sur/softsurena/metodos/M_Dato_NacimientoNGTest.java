package sur.softsurena.metodos;

import java.sql.ResultSet;
import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.AlturaPeso;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_Dato_NacimientoNGTest {
    
    @Test(
            enabled = false
    )
    public void testGetDatosNacimiento() {
//        Dato_Nacimiento result = M_Dato_Nacimiento.getDatosNacimiento(id);
//        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testGetAlturaPeso() {
        int idPaciente = 0;
        ResultSet expResult = null;
        List<AlturaPeso> result = M_Dato_Nacimiento.getAlturaPeso(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testGetPCefalico() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getPCefalico(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testGetPesoKG() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getPesoKG(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testGetLongitudOEstatura() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getLongitudOEstatura(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testGetLongitudPeso() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getLongitudPeso(idPaciente);
        assertEquals(result, expResult);
    }
}