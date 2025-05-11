package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Municipio;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_MunicipioNGTest {

    public M_MunicipioNGTest() {
        System.out.println("sur.softsurena.metodos.M_MunicipioNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {
//        Conexion.getInstance(
//                "sysdba",
//                "1",
//                "SoftSurena.db",
//                "localhost",
//                "3050",
//                "NONE"
//        );
//        assertTrue(
//                Conexion.verificar().getEstado(),
//                "Error al conectarse..."
//        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
//        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = true,
            description = "",
            priority = 0
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

    @Test(
            enabled = true,
            description = """
                          """,
            alwaysRun = true
    )
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

}
