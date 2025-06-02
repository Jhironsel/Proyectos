package sur.softsurena.formularios;

import java.sql.Date;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmFechaReporteNGTest {


    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetFecha() {
        frmFechaReporte instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetFecha() {
        Date fecha = null;
        frmFechaReporte instance = null;
        instance.setFecha(fecha);
    }

}