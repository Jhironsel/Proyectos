package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Provincia;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ProvinciaNGTest {

    public M_ProvinciaNGTest() {
        System.out.println("sur.softsurena.metodos.M_ProvinciaNGTest.<init>()");
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
