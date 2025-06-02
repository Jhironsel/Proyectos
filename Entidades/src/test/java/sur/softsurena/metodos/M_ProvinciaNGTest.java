package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Provincia;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ProvinciaNGTest {

    @Test(
            enabled = true,
            description = """
                          """,
            alwaysRun = true
    )
    public void testSqlSelect() {
        assertEquals(
                M_Provincia.sqlSelect(
                        Provincia
                                .builder()
                                .build()
                ),
                """
                SELECT ID, NOMBRE, ZONA
                FROM V_T_PROVINCIAS
                """.strip()
        );
        assertEquals(
                M_Provincia.sqlSelect(
                        Provincia
                                .builder()
                                .id(0)
                                .build()
                ),
                """
                SELECT ID, NOMBRE, ZONA
                FROM V_T_PROVINCIAS
                WHERE ID = 0
                """.strip()
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          """
    )
    public void testSelect() {
        assertFalse(
                M_Provincia.select(
                        Provincia.builder().build()
                ).isEmpty(),
                "Lista de provincia vacia."
        );
        assertFalse(
                M_Provincia.select(
                        Provincia
                                .builder()
                                .id(0)
                                .build()
                ).isEmpty(),
                "Registros 0 no encontrado.."
        );
        
        assertEquals(
                M_Provincia.select(
                        Provincia
                                .builder()
                                .build()
                ).size(),
                33,
                "Registros 0 no encontrado.."
        );
    }

}
