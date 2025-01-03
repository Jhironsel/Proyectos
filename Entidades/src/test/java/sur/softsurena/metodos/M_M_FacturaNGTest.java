package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.D_Factura;
import sur.softsurena.entidades.Factura;
import sur.softsurena.entidades.M_Factura;
import static sur.softsurena.metodos.M_M_Factura.ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA;
import static sur.softsurena.metodos.M_M_Factura.FACTURA_INGRESADA_CORRECTAMENTE_AL_SISTEM;
import static sur.softsurena.metodos.M_M_Factura.FACTURA__BORRADA__CORRECTAMENTE;
import static sur.softsurena.metodos.M_M_Factura.OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
public class M_M_FacturaNGTest {

    private int id_factura = -1;
    private Factura factura;

    public M_M_FacturaNGTest() {
        factura = Factura
                .builder()
                .build();
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

    //--------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          TODO la lista de detalle es la misma que esta en 
                          M_D_FACTURANGTEST, seria bueno 
                          """
    )
    public void testAgregarFacturaNombre() {

        Resultado result = M_M_Factura.agregarFacturaNombre(
                Factura
                        .builder()
                        .m_factura(
                                M_Factura.getM_FacturaTest()
                        )
                        .d_factura(
                                D_Factura.getListTest()
                        )
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(FACTURA_INGRESADA_CORRECTAMENTE_AL_SISTEM)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_FACTURA_AL_SISTEMA
        );

        id_factura = result.getId();

    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          Prueba para modificar el encabezado de una factura.
                          """
    )
    public void testModificarFactura() {

        assertEquals(
                M_M_Factura.modificarFactura(factura),
                Resultado
                        .builder()
                        .mensaje("Factura modificada correctamente.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testGetFacturaEstado() {
        List result = M_M_Factura.getFacturaEstado(
                Factura
                        .builder()
                        .m_factura(
                                M_Factura
                                        .builder()
                                        .estadoFactura('t')
                                        .build()
                        )
                        .build()
        );
        assertTrue(
                result.isEmpty(),
                "La lista de facturas temporales se encuentra con registros."
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 6,
            description = """
                          Test que permite eliminar una factura del sistema.
                          """
    )
    public void testBorrarFactura() {
        if (id_factura < 0) {
            return;
        }
        Resultado result = M_M_Factura.borrarFactura(id_factura);

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(FACTURA__BORRADA__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA
        );

    }

    /**
     * Test of sqlGetTemporal method, of class M_M_Factura.
     */
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          
                          """
    )
    public void testSqlFacturaEstado() {
        String expResult = """
                           SELECT
                              ID,
                              ID_CLIENTE,
                              ID_CONTACTOS_TEL,
                              ID_CONTACTOS_DIRECCIONES,
                              ID_CONTACTOS_EMAIL,
                              ID_TURNO,
                              FECHA_HORA,
                              ESTADO_FACTURA,
                              NOMBRE_TEMP,
                              USER_NAME,
                              PNOMBRE,
                              SNOMBRE,
                              APELLIDOS
                           FROM GET_M_FACTURAS
                           ;
                           """;
        String result = M_M_Factura.sqlFacturaEstado(
                Factura
                        .builder()
                        .m_factura(
                                M_Factura.builder().build()
                        )
                        .build()
        );
        assertEquals(result, expResult);

        expResult = """
                    SELECT
                       ID,
                       ID_CLIENTE,
                       ID_CONTACTOS_TEL,
                       ID_CONTACTOS_DIRECCIONES,
                       ID_CONTACTOS_EMAIL,
                       ID_TURNO,
                       FECHA_HORA,
                       ESTADO_FACTURA,
                       NOMBRE_TEMP,
                       USER_NAME,
                       PNOMBRE,
                       SNOMBRE,
                       APELLIDOS
                    FROM GET_M_FACTURAS
                    WHERE ESTADO_FACTURA = 't';
                    """;
        result = M_M_Factura.sqlFacturaEstado(
                Factura
                        .builder()
                        .m_factura(
                                M_Factura
                                        .builder()
                                        .estadoFactura('t')
                                        .build()
                        )
                        .build()
        );
        assertEquals(result, expResult);

        expResult = """
                    SELECT
                       ID,
                       ID_CLIENTE,
                       ID_CONTACTOS_TEL,
                       ID_CONTACTOS_DIRECCIONES,
                       ID_CONTACTOS_EMAIL,
                       ID_TURNO,
                       FECHA_HORA,
                       ESTADO_FACTURA,
                       NOMBRE_TEMP,
                       USER_NAME,
                       PNOMBRE,
                       SNOMBRE,
                       APELLIDOS
                    FROM GET_M_FACTURAS
                    WHERE ESTADO_FACTURA = 'i';
                    """;
        result = M_M_Factura.sqlFacturaEstado(
                Factura
                        .builder()
                        .m_factura(
                                M_Factura
                                        .builder()
                                        .estadoFactura('i')
                                        .build()
                        )
                        .build()
        );
        assertEquals(result, expResult);
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          
                          """
    )
    public void testGetIDFacturaNueva() {
        int idTurno = 0;
        int expResult = 0;
        int result = M_M_Factura.getIDFacturaNueva(idTurno);
        assertEquals(result, expResult);
    }
}
