package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.DistritoMunicipal;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init",
        groups = "distritoMunicipal"
)
public class M_DistritoMunicipalNGTest {

    @Test
    public void testSqlSelect() {
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                WHERE ID IN(0, -1)
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .idMunicipio(0)
                                .build()
                ),
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                WHERE ID_MUNICIPIO = 0
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_DistritoMunicipal.sqlSelect(
                        DistritoMunicipal
                                .builder()
                                .id(-1)
                                .idMunicipio(0)
                                .build()
                ),
                """
                SELECT ID, ID_MUNICIPIO, NOMBRE
                FROM V_T_DISTRITOS_MUNICIPALES
                WHERE ID IN(0, -1) OR ID_MUNICIPIO = 0
                ORDER BY 1;
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testGetDistritosMunicipales() {
        assertFalse(
                M_DistritoMunicipal.select(
                        DistritoMunicipal
                                .builder()
                                .id(0)
                                .build()
                ).isEmpty(),
                "Registro principal no existe."
        );

        assertFalse(
                M_DistritoMunicipal.select(
                        DistritoMunicipal
                                .builder()
                                .idMunicipio(27)
                                .build()
                ).isEmpty(),
                "Registros Distritos municipales de San Juan no encontrado."
        );
    }

}
