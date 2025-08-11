package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.entidades.Persona;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_BORRAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_INSERTAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_MODIFICAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_MODIFICADO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_PacienteNGTest {

    public static int idPersona;

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

    @Test
    public static void testInsert() {
        M_PersonaNGTest.persona = Persona
                .builder()
                .persona('J')
                .pnombre("MPaciente")
                .snombre("MPaciente")
                .apellidos("MPaciente").sexo('M')
                .fecha_nacimiento(
                        javaDateToSqlDate(
                                stringToDate("23.06.2017", "dd.MM.yyyy")
                        )
                )
                .estado(Boolean.TRUE)
                .build();

        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;

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
                idPersona > 0,
                ERROR_AL_INSERTAR_PACIENTE
        );
    }

    @Test(
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
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        assertEquals(
                M_Paciente.delete(
                        Paciente
                                .builder()
                                .id(idPersona)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(PACIENTE_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_PACIENTE.formatted(idPersona)
        );

        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
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
