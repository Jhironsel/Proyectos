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
import sur.softsurena.entidades.D_Factura;
import sur.softsurena.entidades.Factura;
import sur.softsurena.entidades.M_Factura;
import static sur.softsurena.metodos.M_D_Factura.DETALLE_DE_LA_FACTURA_AGREGADO_CORRECTAME;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = {"init", "init.factura"}
)
public class M_D_FacturaNGTest {

    public M_D_FacturaNGTest() {}

    //--------------------------------------------------------------------------
    @BeforeClass
    public void setUpClass() throws Exception {
    }

    //--------------------------------------------------------------------------
    @AfterClass
    public void tearDownClass() throws Exception {
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
    public void testInsert() {
        Resultado result = M_D_Factura.insert(
                Factura
                        .builder()
                        .id(0)
                        .m_factura(//2
                                M_Factura
                                        .builder()
                                        .id(0)
                                        .idCliente(0)
                                        .idContactoTel(0)
                                        .idContactoDir(0)
                                        .idContactoEmail(0)
                                        .idTurno(0)
                                        .estadoFactura('n')
                                        .nombreTemporal("")
                                        .build()
                        )
                        .d_factura(
                                null //D_Factura.getListTest()
                        )
                        .build()
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
    public void testSelect() {
        Integer idFactura = 0;

        List<D_Factura> buscarTemporal
                = M_D_Factura.select(idFactura);

        assertFalse(
                buscarTemporal.isEmpty(),
                "La lista de factura Temporales no se encuentra con registros."
        );
    }
}
