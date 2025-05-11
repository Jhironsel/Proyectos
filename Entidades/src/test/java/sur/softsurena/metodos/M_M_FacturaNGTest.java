package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
@Test(
        dependsOnGroups = {"init"},
        groups = "init.factura"
)
public class M_M_FacturaNGTest {

    private int id_factura = -1;

    public M_M_FacturaNGTest() {
        System.out.println("sur.softsurena.metodos.M_M_FacturaNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = true,
            description = """
                          """,
            dependsOnGroups = {
                
                "cliente.insert", 
                "contactoTel.insert", 
                "contactoDir.insert", 
                "contactoEmail.insert",
                "turno.insert"
            }
    )
    public void testGetIDFacturaNueva() {
        assertTrue(
                M_M_Factura.getIDFacturaNueva(M_TurnoNGTest.idTurno) > 0,
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
            alwaysRun = true,
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
                          """,
            dependsOnGroups = {
                "cliente.insert", 
                "contactoTel.insert", 
                "contactoDir.insert", 
                "contactoEmail.insert",
                "turno.insert"
            }
    )
    public void testInsert() {

        M_ClienteNGTest.testInsert();
        
        Resultado result = M_M_Factura.insert(
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
                          """,
            dependsOnGroups = {
                "cliente.insert", 
                "contactoTel.insert", 
                "contactoEmail.insert",
                "contactoDir.insert", 
                "turno.insert"
            }
    )
    public void testUpdate() {
        assertEquals(
                M_M_Factura.update(
                        M_Factura
                                .builder()
                                .id(0)
                                .idCliente(M_ClienteNGTest.idCliente)
                                .idContactoTel(M_ContactoTelNGTest.idContactoTel)
                                .idContactoEmail(0)
                                .idContactoDir(0)
                                .idTurno(M_TurnoNGTest.idTurno)
                                .estadoFactura('n')
                                .nombreTemporal("")
                                .build()
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
            enabled = false,
            priority = 2,
            description = """
                          Test que permite eliminar una factura del sistema.
                          """, 
            dependsOnMethods = {"testInsert", "testUpdate"}
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
