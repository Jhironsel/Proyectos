package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Estudiante;
import static sur.softsurena.metodos.M_Estudiante.ESTUDIANTE__AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Estudiante.ESTUDIANTE__MODIFICADO__CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_EstudianteNGTest {

    public M_EstudianteNGTest() {
        System.out.println("sur.softsurena.metodos.M_EstudianteNGTest.<init>()");
    }

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
            description = """
                          """,
            alwaysRun = true
    )
    public void testSqlSelect() {
        assertEquals(
                M_Estudiante.sqlSelect(
                        Estudiante
                                .builder()
                                .build()
                ),
                """
                SELECT ID, MATRICULA
                FROM V_PERSONAS_ESTUDIANTES_ATR
                """.strip()
        );
        assertEquals(
                M_Estudiante.sqlSelect(
                        Estudiante
                                .builder()
                                .matricula("00")
                                .build()
                ),
                """
                SELECT ID, MATRICULA
                FROM V_PERSONAS_ESTUDIANTES_ATR
                WHERE MATRICULA STARTING WITH '00'
                """.strip()
        );
    }

    @Test(
            enabled = true,
            description = """
                          """,
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Estudiante.select(
                        Estudiante
                                .builder()
                                .build()
                ),
                "Error en la consulta de la tabla de V_PERSONAS_ESTUDIANTES_ATR."
        );
        assertNotNull(
                M_Estudiante.select(
                        Estudiante
                                .builder()
                                .matricula("000")
                                .build()
                ),
                "Error en la consulta de la tabla de V_PERSONAS_ESTUDIANTES_ATR."
        );
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          """,
            dependsOnMethods = "testSelect"
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();
        assertEquals(
                M_Estudiante.insert(
                        Estudiante
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .getPersona(
                                                        Boolean.TRUE
                                                )
                                                .getIdPersona()
                                )
                                .matricula(
                                        M_ContactoTel
                                                .generarTelMovil()
                                                .substring(8, 16))
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(ESTUDIANTE__AGREGADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          """,
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Estudiante.update(
                        Estudiante
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .getPersona(
                                                        Boolean.TRUE
                                                )
                                                .getIdPersona()
                                )
                                .matricula("UPDATE_PRUEBA")
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(ESTUDIANTE__MODIFICADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            dependsOnMethods = {
                "testInsert", 
                "testUpdate"
            },
            description = """
                          """
    )
    public void testDelete() {
        assertEquals(
                M_Estudiante.delete(
                        Estudiante
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .getPersona(
                                                        Boolean.TRUE
                                                )
                                                .getIdPersona()
                                )
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje("Estudiante borrado correctamente.!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        M_PersonaNGTest.testDelete();
    }

}
