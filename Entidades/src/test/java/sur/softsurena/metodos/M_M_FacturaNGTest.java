package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import static org.testng.Assert.*;
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
        dependsOnGroups = {"init", "gTurno"},
        groups = "gFactura"
)
public class M_M_FacturaNGTest {

    public static int idFactura, idFactura2, idPersona, idTurno;

    @Test
    public static void testSqlSelect() {
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

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public static void testSelect() {
        assertNotNull(
                M_M_Factura.select(
                        M_Factura
                                .builder()
                                .estadoFactura('t')
                                .build()
                ),
                "La lista de facturas temporales se encuentra con registros."
        );
    }
    
    @Test(
            dependsOnGroups = {"usuario.insert", "M_ContactoDireccionNGTest.testUpdateOrInsert"},
            dependsOnMethods = {"testPersona"}
    )
    public static void testInsert() {
        M_ClienteNGTest.testInsert();
        idPersona = M_ClienteNGTest.idPersona;
        
        M_TurnoNGTest.testInsert();
        idTurno = M_TurnoNGTest.idTurno;
        
        Resultado result = M_M_Factura.insert(
                M_Factura
                        .builder()
                        .id(0)
                        .idCliente(idPersona)
                        .idContactoTel(0)
                        .idContactoDir(0)
                        .idContactoEmail(0)
                        .idTurno(idTurno)
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

        idFactura = result.getId();
    }

    @Test(
            dependsOnMethods = "testInsert", 
            groups = "gGetIDFacturaNueva"
    )
    public static void testGetIDFacturaNueva() {
        idFactura2 = M_M_Factura.getIDFacturaNueva(idTurno);
        assertTrue(
                 idFactura2 >= 0,
                "Se obtuvo una factura menor que cero."
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testInsert"
    )
    public static void testUpdate() {
        assertEquals(
                M_M_Factura.update(
                        M_Factura
                                .builder()
                                .id(idFactura)
                                .idCliente(idPersona)
                                .idContactoTel(0)
                                .idContactoEmail(0)
                                .idContactoDir(0)
                                .idTurno(idTurno)
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
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        assertEquals(
                M_M_Factura.delete(idFactura),
                Resultado
                        .builder()
                        .mensaje(FACTURA__BORRADA__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA
        );
        
        assertEquals(
                M_M_Factura.delete(idFactura2),
                Resultado
                        .builder()
                        .mensaje(FACTURA__BORRADA__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__FA
        );
        
    }
    
    @Test(
            dependsOnMethods = "testDelete"
    )
    public static void testDeletePersona() {
        M_ClienteNGTest.idPersona = idPersona;
        M_ClienteNGTest.testDelete();
    }
    
    @Test(
            dependsOnMethods = "testDeletePersona"
    )
    public static void testDeleteTurno() {
        M_TurnoNGTest.idTurno = idTurno;
        M_TurnoNGTest.testDelete();
    }
    
}
