package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Metrica;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_MetricaNGTest {

    @Test
    public void testSqlSelect() {
        assertEquals(
                M_Metrica.sqlSelect(
                        Metrica
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_CONSULTA, PESOKG, ESTATURAMETRO, ESCEFALO,
                 ENF_DETECT, HALLAZGOS_POS, ID_DIAG, TX, COMPLEMENTO,
                 IMAGEN_TEXTO, USER_NAME
                FROM V_METRICAS
                """.strip()
        );

        assertEquals(
                M_Metrica.sqlSelect(
                        Metrica
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CONSULTA, PESOKG, ESTATURAMETRO, ESCEFALO,
                 ENF_DETECT, HALLAZGOS_POS, ID_DIAG, TX, COMPLEMENTO,
                 IMAGEN_TEXTO, USER_NAME
                FROM V_METRICAS
                WHERE ID_CONSULTA = -1
                """.strip()
        );
    }

//------------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Metrica.sqlSelect(
                        Metrica
                                .builder()
                                .build()
                ),
                "Error al consultar la tabla de Metricas."
        );
        
        assertNotNull(
                M_Metrica.sqlSelect(
                        Metrica
                                .builder()
                                .id(0)
                                .build()
                ),
                "Error al consultar la tabla de Metricas."
        );
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = false
    )
    public void testInsert() {
        //TODO 12/12/2024 agregar los datos a este objecto metrica
        M_Metrica.insert(
                Metrica
                        .builder()
                        .build()
        );
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = false
    )
    public void testUdapte() {
        Metrica metrica = null;
        Resultado expResult = null;
        Resultado result = M_Metrica.udapte(metrica);
        assertEquals(result, expResult);
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = false
    )
    public void testDelete() {
        Metrica metrica = null;
        Resultado expResult = null;
        Resultado result = M_Metrica.delete(metrica);
        assertEquals(result, expResult);
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = false
    )
    public void testDeleteByIdConsulta() {
        Metrica metrica = null;
        Resultado expResult = null;
        Resultado result = M_Metrica.deleteByIdConsulta(metrica);
        assertEquals(result, expResult);
    }
}
