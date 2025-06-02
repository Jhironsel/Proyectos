package sur.softsurena.metodos;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import sur.softsurena.entidades.ARS;
import static sur.softsurena.metodos.M_ARS.BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ARS.ERROR_AL_BORRAR_ARS;
import static sur.softsurena.metodos.M_ARS.ERROR_AL_CONSULTAR_LA_VISTA_V_ARS_DEL;
import static sur.softsurena.metodos.M_ARS.ERROR_AL_INSERTAR__SEGURO;
import static sur.softsurena.metodos.M_ARS.ERROR_AL_MODIFICAR_SEGURO;
import static sur.softsurena.metodos.M_ARS.SEGURO_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ARS.SEGURO_MODIFICADO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ARSNGTest {

    private static Integer idARS;

    @Test
    public void testSqlARS() {

        assertEquals(
                M_ARS.sqlARS(
                        ARS
                                .builder()
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, COVERTURA_CONSULTA_PORCIENTO, ESTADO, CANTIDAD_REGISTRO
                FROM V_ARS;
                """.strip()
        );

        //----------------------------------------------------------------------
        assertEquals(
                M_ARS.sqlARS(
                        ARS
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, COVERTURA_CONSULTA_PORCIENTO, ESTADO, CANTIDAD_REGISTRO
                FROM V_ARS
                WHERE ESTADO;
                """.strip()
        );

        //----------------------------------------------------------------------

        assertEquals(
                M_ARS.sqlARS(
                        ARS
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, COVERTURA_CONSULTA_PORCIENTO, ESTADO, CANTIDAD_REGISTRO
                FROM V_ARS
                WHERE ESTADO IS FALSE;
                """.strip()
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = """
                          Test en cargado de verificar la consultas de las 
                          ARS del sistema.
                          """,
            dependsOnMethods = "testSqlARS"
    )
    public static void testSelect() {
        assertNotNull(
                M_ARS.select(
                        ARS
                                .builder()
                                .build()
                ),
                ERROR_AL_CONSULTAR_LA_VISTA_V_ARS_DEL
        );

        assertNotNull(
                M_ARS.select(
                        ARS
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                ERROR_AL_CONSULTAR_LA_VISTA_V_ARS_DEL
        );

        assertNotNull(
                M_ARS.select(
                        ARS
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                ERROR_AL_CONSULTAR_LA_VISTA_V_ARS_DEL
        );

    }

    //--------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = """
                          Test que verifica que un ARS puede ser insertardo en
                          el sistema.
                          """,
            groups = "ars.insert",
            dependsOnMethods = "testSelect"
    )
    public static void testInsert() {
        Resultado result = M_ARS.insert(
                ARS
                        .builder()
                        .descripcion(
                                "TestARS_".concat(
                                        M_Generales.generarCedula().substring(6, 11)
                                )
                        )
                        .covertura(
                                BigDecimal.valueOf(60.00)
                        )
                        .estado(Boolean.FALSE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(SEGURO_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR__SEGURO
        );

        assertTrue(
                result.getId() > 0,
                ERROR_AL_INSERTAR__SEGURO
        );

        idARS = result.getId();
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = "Test para modificar las ars del sistema.",
            dependsOnMethods = "testInsert"
    )
    public static void testUpdate() {
        Resultado result = M_ARS.update(
                ARS
                        .builder()
                        .id(idARS)
                        .descripcion("Senasa3")
                        .covertura(BigDecimal.valueOf(50.00))
                        .estado(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(SEGURO_MODIFICADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_MODIFICAR_SEGURO
        );
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = """
                          Test que permite eliminar un registro de ars del
                          sistema.
                          """,
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        Resultado result = M_ARS.delete(
                ARS
                        .builder()
                        .id(idARS)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_ARS
        );
    }
}
