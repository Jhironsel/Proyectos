package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Estudiante;
import static sur.softsurena.metodos.M_Estudiante.ESTUDIANTE__AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Estudiante.ESTUDIANTE__MODIFICADO__CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_EstudianteNGTest {

    public M_EstudianteNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "NONE"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
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

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
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

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = ""
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();
        assertEquals(
                M_Estudiante.insert(
                        Estudiante
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .persona(
                                                        Boolean.TRUE
                                                )
                                                .getIdPersona()
                                )
                                .matricula("INSERT_PRUEBA")
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
            description = ""
    )
    public void testUpdate() {
        assertEquals(
                M_Estudiante.update(
                        Estudiante
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .persona(
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
            priority = 3,
            description = ""
    )
    public void testDelete() {
        assertEquals(
                M_Estudiante.delete(
                        Estudiante
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .persona(
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
