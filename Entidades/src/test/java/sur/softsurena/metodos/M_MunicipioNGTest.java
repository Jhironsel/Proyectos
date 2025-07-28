package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Municipio;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_MunicipioNGTest {

    @Test
    public void testSqlSelect() {
        assertEquals(
                M_Municipio.sqlSelect(
                        Municipio
                                .builder()
                                .build()
                ), 
                """
                SELECT ID, ID_PROVINCIA, NOMBRE
                FROM V_T_MUNICIPIOS
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_Municipio.sqlSelect(
                        Municipio
                                .builder()
                                .id(-1)
                                .build()
                ), 
                """
                SELECT ID, ID_PROVINCIA, NOMBRE
                FROM V_T_MUNICIPIOS
                WHERE ID IN(0, -1)
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_Municipio.sqlSelect(
                        Municipio
                                .builder()
                                .idProvincia(0)
                                .build()
                ), 
                """
                SELECT ID, ID_PROVINCIA, NOMBRE
                FROM V_T_MUNICIPIOS
                WHERE ID_PROVINCIA = 0
                ORDER BY 1;
                """.strip()
        );
        assertEquals(
                M_Municipio.sqlSelect(
                        Municipio
                                .builder()
                                .id(-1)
                                .idProvincia(0)
                                .build()
                ), 
                """
                SELECT ID, ID_PROVINCIA, NOMBRE
                FROM V_T_MUNICIPIOS
                WHERE ID IN(0, -1) OR ID_PROVINCIA = 0
                ORDER BY 1;
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Municipio.select(
                        Municipio
                                .builder()
                                .id(0)
                                .build()
                ),
                "La tabla de municipio esta vacia"
        );

        assertNotNull(
                M_Municipio.select(
                        Municipio
                                .builder()
                                .id(1)
                                .build()
                ),
                "La tabla de municipio esta vacia"
        );
        assertNotNull(
                M_Municipio.select(
                        Municipio
                                .builder()
                                .idProvincia(0)
                                .build()
                ),
                "La tabla de municipio esta vacia"
        );

        assertNotNull(
                M_Municipio.select(
                        Municipio
                                .builder()
                                .idProvincia(1)
                                .build()
                ),
                "La tabla de municipio esta vacia"
        );
    }

}
