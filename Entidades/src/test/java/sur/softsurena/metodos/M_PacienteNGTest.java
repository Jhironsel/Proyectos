package sur.softsurena.metodos;

import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Paciente;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_BORRAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_INSERTAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_MODIFICAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_MODIFICADO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

@Getter
public class M_PacienteNGTest {

    private static Integer idPersona;

    public M_PacienteNGTest() {
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
                          Test que realiza el ingreso de un paciente al sistema.
                          """
    )
    public static void testInsert() {
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.persona(Boolean.TRUE).getIdPersona();
        
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
                M_PersonaNGTest.persona(Boolean.FALSE).getIdPersona() > 0,
                ERROR_AL_INSERTAR_PACIENTE
        );
    }

    @Test(
            enabled = true,
            description = "",
            priority = 1
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
            priority = 3
    )
    public static void testDelete() {
        assertEquals(
                M_Paciente.delete(
                        Paciente
                                .builder()
                                .id(M_PersonaNGTest.persona(Boolean.FALSE).getIdPersona())
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(PACIENTE_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_PACIENTE.formatted(
                        M_PersonaNGTest.persona(Boolean.FALSE).getIdPersona()
                )
        );

        M_PersonaNGTest.testDelete();
    }

    @Test
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

    @Test
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

    public static Paciente generarPaciente() {
        return Paciente
                .builder()
                .id(idPersona)
                .cesarea(Boolean.FALSE)
                .tiempoGestacion(8)
                .fumador(Boolean.FALSE)
                .build();
    }
}
