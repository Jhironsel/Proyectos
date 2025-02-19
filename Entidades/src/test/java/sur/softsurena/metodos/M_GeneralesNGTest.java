package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Generales;
import static sur.softsurena.metodos.M_Generales.ERROR_AL_ACTUALIZAR_LAS__GENERALES_EN_EL_S;
import static sur.softsurena.metodos.M_Generales.ERROR_AL_BORRAR_LAS_GENERALES_EN_EL_SISTE;
import static sur.softsurena.metodos.M_Generales.ERROR_AL_INSERTAR_GENERALES_EN_EL_SISTEMA;
import static sur.softsurena.metodos.M_Generales.GENERALES_ACTUALIZADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Generales.GENERALES_BORRADA_CORRECTAMENTE_DEL_SISTE;
import static sur.softsurena.metodos.M_Generales.GENERAL_INSERTADA_CORRECTAMENTE_EN_EL_SIS;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_GeneralesNGTest {

    private final SoftAssert softAssert;
    private String cedula;
    private int idGeneral;

    public M_GeneralesNGTest() {
        softAssert = new SoftAssert();
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
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSqlSelect() {
        assertEquals(
                M_Generales.sqlSelect(
                        Generales.builder().build()
                ), 
                """
                SELECT ID, ID_PERSONA, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_GENERALES
                """.strip()
        );
        assertEquals(
                M_Generales.sqlSelect(
                        Generales
                                .builder()
                                .cedula("012-0089344-2")
                                .build()
                ), 
                """
                SELECT ID, ID_PERSONA, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_GENERALES
                WHERE CEDULA STARTING WITH '012-0089344-2'
                """.strip()
        );
        assertEquals(
                M_Generales.sqlSelect(
                        Generales
                                .builder()
                                .idPersona(0)
                                .build()
                ), 
                """
                SELECT ID, ID_PERSONA, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_GENERALES
                WHERE ID_PERSONA = 0
                """.strip()
        );
        assertEquals(
                M_Generales.sqlSelect(
                        Generales
                                .builder()
                                .id(0)
                                .build()
                ), 
                """
                SELECT ID, ID_PERSONA, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_GENERALES
                WHERE ID = 0
                """.strip()
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSelect() {
        assertNotNull(
                M_Generales.select(
                        Generales.builder().build()
                ), 
                """
                Error al realizar la consulta a generales.
                """
        );
        assertNotNull(
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula("012-0089344-2")
                                .build()
                ), 
                """
                Error al realizar la consulta a generales.
                """
        );
        assertNotNull(
                M_Generales.select(
                        Generales
                                .builder()
                                .idPersona(0)
                                .build()
                ), 
                """
                Error al realizar la consulta a generales.
                """
        );
        assertNotNull(
                M_Generales.select(
                        Generales
                                .builder()
                                .id(0)
                                .build()
                ), 
                """
                Error al realizar la consulta a generales.
                """
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          
                          """
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();

        assertEquals(
                M_Generales.insert(
                        Generales
                                .builder()
                                .idPersona(
                                        M_PersonaNGTest
                                                .persona(Boolean.FALSE)
                                                .getIdPersona()
                                )
                                .cedula(
                                        M_Generales.generarCedula()
                                )
                                .idTipoSangre(1)
                                .estado_civil('X')
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(GENERAL_INSERTADA_CORRECTAMENTE_EN_EL_SIS)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_GENERALES_EN_EL_SISTEMA
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 3,
            description = ""
    )
    public void testUpdate() {
        assertEquals(
                M_Generales.update(
                        Generales
                                .builder()
                                .idPersona(
                                        M_PersonaNGTest
                                                .persona(Boolean.TRUE)
                                                .getIdPersona()
                                )
                                .cedula(M_Generales.generarCedula())
                                .idTipoSangre(0)
                                .estado_civil('X')
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(GENERALES_ACTUALIZADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ACTUALIZAR_LAS__GENERALES_EN_EL_S
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 4,
            description = ""
    )
    public void testDelete() {
        Resultado result = M_Generales.delete(
                M_PersonaNGTest.persona(Boolean.TRUE).getIdPersona()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(GENERALES_BORRADA_CORRECTAMENTE_DEL_SISTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_LAS_GENERALES_EN_EL_SISTE
        );

        M_PersonaNGTest.testDelete();
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Prueba que me permite testear los dos metodos de la 
                          clase.
                          M_Generales.generarCedula() Nos genera una cedula DO.
                          M_Generales.cedula() Nos valida que la cedula sea 
                          valida.
                          """
    )
    public void testGenerarCedula() {
        String cedula2 = M_Generales.generarCedula();
        try {
            assertTrue(
                    M_Generales.cedula(cedula2),
                    "Cedula que trata de valida es incorrecta. %s"
                            .formatted(cedula2)
            );
        } catch (java.lang.AssertionError e) {
            fail(
                    "Cedula que trata de valida es incorrecta. %s"
                            .formatted(cedula2)
            );
        }
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testCedula() {
        softAssert.assertTrue(
                false,
                "Esta condición debería ser verdadera"
        );

        softAssert.assertEquals(
                1,
                2,
                "Los valores no coinciden"
        );

        //Deberia de ejecutarse al final de todas las pruebas.
        //softAssert.assertAll(); // Verifica todas las condiciones
    }
}
