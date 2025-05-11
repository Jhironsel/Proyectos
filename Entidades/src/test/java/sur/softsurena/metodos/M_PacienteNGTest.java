package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Paciente;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_BORRAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_INSERTAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_MODIFICAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_MODIFICADO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_PacienteNGTest {

    private static Integer idPaciente;

    public M_PacienteNGTest() {}

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
                          """
    )
    public void testSqlSelect() {

        assertEquals(
                M_Paciente.sqlSelect(
                        Paciente
                                .builder()
                                .build()
                ),
                """
                SELECT ID, CESAREA, TIEMPO_GESTACION, FUMADOR
                FROM V_PERSONAS_PACIENTES_ATR
                """.strip()
        );

        assertEquals(
                M_Paciente.sqlSelect(
                        Paciente
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID, CESAREA, TIEMPO_GESTACION, FUMADOR
                FROM V_PERSONAS_PACIENTES_ATR
                WHERE ID = -1
                """.strip()
        );
    }
    
    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public static void testSelect() {
        assertNotNull(
                M_Paciente.select(
                        Paciente
                                .builder()
                                .build()
                ),
                "Error en la consulta de pacientes."
        );

        assertNotNull(
                M_Paciente.select(
                        Paciente
                                .builder()
                                .id(-1)
                                .build()
                ),
                "Error en la consulta de pacientes."
        );
    }

    @Test(
            enabled = true,
            description = """
                          Test que realiza el ingreso de un paciente al sistema.
                          """
    )
    public static void testInsert() {
        M_PersonaNGTest.testInsert();
        idPaciente = M_PersonaNGTest.getPersona(Boolean.TRUE).getIdPersona();
        
        Resultado result = M_Paciente.insert(generarPaciente());

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PACIENTE_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_PACIENTE
        );
        
        

        assertTrue(
                M_PersonaNGTest.getPersona(Boolean.FALSE).getIdPersona() > 0,
                ERROR_AL_INSERTAR_PACIENTE
        );
    }

    @Test(
            enabled = true,
            description = "",
            dependsOnMethods = "testInsert"
    )
    public static void testUpdate() {
        Resultado result = M_Paciente.update(generarPaciente());

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PACIENTE_MODIFICADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_MODIFICAR_PACIENTE
        );
    }

    @Test(
            enabled = true,
            description = "Test que permite eliminar un paciente ya creado.",
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        assertEquals(
                M_Paciente.delete(
                        Paciente
                                .builder()
                                .id(
                                        M_PersonaNGTest
                                                .getPersona(Boolean.FALSE)
                                                .getIdPersona()
                                )
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(PACIENTE_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_PACIENTE.formatted(
                        M_PersonaNGTest.getPersona(Boolean.FALSE).getIdPersona()
                )
        );

        M_PersonaNGTest.testDelete();
    }

    public static Paciente generarPaciente() {
        return Paciente
                .builder()
                .id(idPaciente)
                .cesarea(Boolean.FALSE)
                .tiempoGestacion(8)
                .fumador(Boolean.FALSE)
                .build();
    }
}
