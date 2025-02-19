package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Medicamento;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_MedicamentoNGTest {

    public M_MedicamentoNGTest() {
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
            priority = 0,
            description = ""
    )
    public void testSelect() {
        
        List<Medicamento> result = M_Medicamento.select();
        assertNotNull(
                result, 
                ""
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testUpdate() {
        Medicamento m = null;
        String expResult = "";
        Resultado result = M_Medicamento.update(m);
        assertEquals(result, expResult);
    }

}