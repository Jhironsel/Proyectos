package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Padre;
import sur.softsurena.entidades.Paginas;
import static sur.softsurena.metodos.M_Padre.BORRADO_DE_REGISTRO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Padre.PADRE__AGREGADO__EXITOSAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_PadreNGTest {

    public M_PadreNGTest() {}

    @BeforeClass
    public void setUpClass() throws Exception {}

    @AfterClass
    public void tearDownClass() throws Exception {}

    @BeforeMethod
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testSelect() {

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .build()
                ),
                "Error al consultar la lista de padres."
        );

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .id(-1)
                                .build()
                ),
                "Error al consultar la lista de padres."
        );

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de padres."
        );

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .id(-1)
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de padres."
        );
    }

    @Test(
            enabled = true,
            alwaysRun = true,
            description = """
                          """
    )
    public void testSqlSelect() {
        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                WHERE ID = -1
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .id(-1)
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                WHERE ID = -1
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );

    }

    @Test(
            enabled = true,
            priority = 1,
            description = ""
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();
        assertEquals(
                M_Padre.insert(
                        Padre
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .getPersona(Boolean.TRUE)
                                                .getIdPersona()
                                )
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(PADRE__AGREGADO__EXITOSAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            priority = 2,
            description = ""
    )
    public void testDelete() {

        assertEquals(
                M_Padre.delete(
                        M_PersonaNGTest
                                .getPersona(Boolean.TRUE)
                                .getIdPersona()
                ),
                Resultado
                        .builder()
                        .mensaje(BORRADO_DE_REGISTRO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        M_PersonaNGTest.testDelete();
    }
}
