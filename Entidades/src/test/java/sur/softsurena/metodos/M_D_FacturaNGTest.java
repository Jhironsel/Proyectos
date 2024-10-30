package sur.softsurena.metodos;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
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
import sur.softsurena.entidades.HeaderFactura;
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
                "3050"
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
    /**
     * TODO trabajando en este metodo de prueba.
     */
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          Metodo que agrega detalles de las facturas en el 
                          sitema.
                          """
    )
    public void testAgregarDetalleFactura() {
        Factura f = Factura
                .builder()
                .id(0)
                .headerFactura(
                        HeaderFactura
                                .builder()
                                .id(0)
                                .idContactoTel(0)
                                .idContactoEmail(0)
                                .idContactoDireccion(0)
                                .idTurno(0)
                                .fechaHora(
                                        new Timestamp(
                                                new GregorianCalendar()
                                                        .getTimeInMillis()
                                        )
                                )
                                .estadoFactura('e')
                                .build()
                )
                .detalleFactura(
                        List.of(
                                D_Factura
                                        .builder()
                                        .idLinea(0)
                                        .idProducto(0)
                                        .precio(BigDecimal.TEN)
                                        .cantidad(BigDecimal.TWO)
                                        .build(), 
                                D_Factura
                                        .builder()
                                        .idLinea(1)
                                        .idProducto(0)
                                        .precio(BigDecimal.TEN)
                                        .cantidad(BigDecimal.TWO)
                                        .build(), 
                                D_Factura
                                        .builder()
                                        .idLinea(2)
                                        .idProducto(0)
                                        .precio(BigDecimal.TEN)
                                        .cantidad(BigDecimal.TWO)
                                        .build()
                        )
                )
                .build();
                
        Resultado result = M_D_Factura.agregarDetalleFactura(
                0, 
                f.getDetalleFactura()
        );
        
        assertEquals(result, 
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
        
        assertTrue(
                buscarTemporal.isEmpty(), 
                "La lista de factura Temporales se encuentra con registros."
        );
    }
    
    //--------------------------------------------------------------------------

    /**
     * TODO Trabajando en este metodo de prueba.
     * 
     */
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetFacturasDetalladas() {
        int idFactura = 0;
        ResultSet expResult = null;
        ResultSet result = M_D_Factura.getFacturasDetalladas(idFactura);
        assertEquals(result, expResult);
    }
    
    //--------------------------------------------------------------------------

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetFacturasDetalladaPorCliente_String() {
        String idCliente = "";
        ResultSet expResult = null;
        ResultSet result = M_D_Factura.getFacturasDetalladaPorCliente(idCliente);
        assertEquals(result, expResult);
    }
    
    //--------------------------------------------------------------------------

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetFacturasDetalladaPorCliente_String_int() {
        String idCliente = "";
        int idFactura = 0;
        ResultSet expResult = null;
        ResultSet result = M_D_Factura.getFacturasDetalladaPorCliente(idCliente, idFactura);
        assertEquals(result, expResult);
    }
}
