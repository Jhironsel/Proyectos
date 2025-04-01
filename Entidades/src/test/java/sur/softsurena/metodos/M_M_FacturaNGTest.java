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

    public M_M_FacturaNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "NONE"
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
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testGetIDFacturaNueva() {
        int idTurno = 0;
        assertTrue(
                M_M_Factura.getIDFacturaNueva(idTurno) > 0,
                "Se obtuvo una factura menor que cero."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testSelect() {
        List result = M_M_Factura.select(
                M_Factura
                        .builder()
                        .estadoFactura('t')
                        .build()
        );
        assertNotNull(
                result,
                "La lista de facturas temporales se encuentra con registros."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          
                          """
    )
    public void testSqlSelect() {
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura.builder().build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                """.strip()
        );
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                WHERE ID = -1
                """.strip()
        );
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura
                                .builder()
                                .idCliente(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                WHERE ID_CLIENTE = -1
                """.strip()
        );
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura
                                .builder()
                                .idContactoTel(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                WHERE ID_CONTACTOS_TEL = -1
                """.strip()
        );
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura
                                .builder()
                                .idContactoDir(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                WHERE ID_CONTACTOS_DIRECCIONES = -1
                """.strip()
        );
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura
                                .builder()
                                .idContactoEmail(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                WHERE ID_CONTACTOS_EMAIL = -1
                """.strip()
        );
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura
                                .builder()
                                .idTurno(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                WHERE ID_TURNO = -1
                """.strip()
        );
        assertEquals(
                M_M_Factura.sqlSelect(
                        M_Factura
                                .builder()
                                .estadoFactura('t')
                                .build()
                ),
                """
                SELECT ID, ID_CLIENTE, ID_CONTACTOS_TEL, ID_CONTACTOS_DIRECCIONES,
                     ID_CONTACTOS_EMAIL, ID_TURNO, FECHA_HORA, ESTADO_FACTURA, 
                     NOMBRE_TEMP
                FROM V_M_FACTURAS
                WHERE ESTADO_FACTURA = 't'
                """.strip()
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          TODO la lista de detalle es la misma que esta en 
                          M_D_FACTURANGTEST, seria bueno 
                          """
    )
    public void testInsert() {

        Resultado result = M_M_Factura.insert(
                M_Factura.getM_FacturaTest()
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
        
        assertTrue(
                result.getId() > 0,
                "Error en el registro de la factura en el sistema."
        );

        id_factura = result.getId();

    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Prueba para modificar el encabezado de una factura.
                          """
    )
    public void testUpdate() {
        assertEquals(
                M_M_Factura.update(
                        M_Factura.getM_FacturaTest()
                ),
                Resultado
                        .builder()
                        .mensaje("Factura modificada correctamente.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 2,
            description = """
                          Test que permite eliminar una factura del sistema.
                          """
    )
    public void testDelete() {
        assertEquals(
                M_M_Factura.delete(id_factura),
                Resultado
                        .builder()
                        .mensaje(FACTURA__BORRADA__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA
        );
    }
}
