package sur.softsurena.vistas;

import sur.softsurena.vistas.VistaFechaReporte;
import java.sql.Date;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class VistaFechaReporteNGTest {


    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetFecha() {
        VistaFechaReporte instance = null;
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
        VistaFechaReporte instance = null;
        instance.setFecha(fecha);
    }

}