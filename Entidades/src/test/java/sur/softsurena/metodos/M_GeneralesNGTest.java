package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sur.softsurena.entidades.Generales;
import static sur.softsurena.metodos.M_Generales.ERROR_AL_BORRAR_LAS_GENERALES_EN_EL_SISTE;
import static sur.softsurena.metodos.M_Generales.ERROR_AL_INSERTAR_GENERALES_EN_EL_SISTEMA;
import static sur.softsurena.metodos.M_Generales.GENERALES_BORRADA_CORRECTAMENTE_DEL_SISTE;
import static sur.softsurena.metodos.M_Generales.GENERAL_INSERTADA_CORRECTAMENTE_EN_EL_SIS;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_GeneralesNGTest {

    private static Integer idGeneral, idPersona, idTipoSangre=0;
    private final SoftAssert softAssert;

    public M_GeneralesNGTest() {
        softAssert = new SoftAssert();
    }

    @Test
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
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Generales.select(
                        Generales
                                .builder()
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

    @Test
    public void testPersona() {
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;
        
        System.out.println("personas registrada para las generales %d.".formatted(idPersona));
    }

    @Test(
        dependsOnMethods = "testPersona"
    )
    public void testUpdateOrInsert() {
        Resultado resultado = M_Generales.updateOrInsert(
                getGenerales()
        );
        assertEquals(
                resultado,
                Resultado
                        .builder()
                        .mensaje(GENERAL_INSERTADA_CORRECTAMENTE_EN_EL_SIS)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_GENERALES_EN_EL_SISTEMA
        );
        
        idGeneral = resultado.getId();
    }

//------------------------------------------------------------------------------
    @Test(
            dependsOnMethods = {"testInsert", "testUpdateOrInsert"}
    )
    public void testDelete() {
        Resultado result = M_Generales.delete(idPersona);

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

    }
    
    @Test(
            dependsOnMethods = "testDelete"
    )
    public static void testDeletePersona(){
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }

//------------------------------------------------------------------------------
    @Test
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
    @Test
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

    public synchronized static Generales getGenerales() {
        return Generales
                .builder()
                .id(idGeneral)
                .idPersona(idPersona)
                .idTipoSangre(idTipoSangre)
                .cedula(M_Generales.generarCedula())
                .estado_civil('X')
                .build();
    }
}
