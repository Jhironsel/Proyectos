package sur.softsurena.metodos;

import java.sql.ResultSet;
import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.AlturaPeso;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_Dato_NacimientoNGTest {

    public M_Dato_NacimientoNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }    
    
    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testGetDatosNacimiento() {
//        Dato_Nacimiento result = M_Dato_Nacimiento.getDatosNacimiento(id);
//        assertEquals(result, expResult);
    }

    /**
     * TODO Este Metodo siguiente esta completo.
     */
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          
                          """
    )
    public void testGetAlturaPeso() {
        int idPaciente = 0;
        ResultSet expResult = null;
        List<AlturaPeso> result = M_Dato_Nacimiento.getAlturaPeso(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetPCefalico() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getPCefalico(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetPesoKG() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getPesoKG(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetLongitudOEstatura() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getLongitudOEstatura(idPaciente);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetLongitudPeso() {
        int idPaciente = 0;
        ResultSet expResult = null;
        ResultSet result = M_Dato_Nacimiento.getLongitudPeso(idPaciente);
        assertEquals(result, expResult);
    }
}