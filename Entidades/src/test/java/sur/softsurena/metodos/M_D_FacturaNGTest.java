package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.D_Factura;
import sur.softsurena.entidades.Factura;
import static sur.softsurena.metodos.M_D_Factura.DETALLE_DE_LA_FACTURA_AGREGADO_CORRECTAME;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_D_FacturaNGTest {

    public M_D_FacturaNGTest() {
    }

    //--------------------------------------------------------------------------
    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "None"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    //--------------------------------------------------------------------------
    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }

    //--------------------------------------------------------------------------
    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    //--------------------------------------------------------------------------
    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Metodo que agrega detalles de las facturas en el 
                          sitema.
                          """
    )
    public void testAgregarDetalleFactura() {
        Resultado result = M_D_Factura.agregarDetalleFactura(
                Factura.getFacturaTest()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(DETALLE_DE_LA_FACTURA_AGREGADO_CORRECTAME)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Test que verifica las facturas en temporal.
                          """
    )
    public void testGetBuscarTemporal() {
        Integer idFactura = 0;

        List<D_Factura> buscarTemporal
                = M_D_Factura.getBuscarTemporal(idFactura);

        assertFalse(
                buscarTemporal.isEmpty(),
                "La lista de factura Temporales no se encuentra con registros."
        );
    }
}
