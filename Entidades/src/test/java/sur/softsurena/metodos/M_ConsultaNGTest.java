package sur.softsurena.metodos;

import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Consulta;
import static sur.softsurena.metodos.M_Consulta.CONSULTA_ACTUALIZADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Consulta.CONSULTA_ELIMINADA_CORRECTAMENTE_DEL_SIST;
import static sur.softsurena.metodos.M_Consulta.ERROR_AL_ACTUALIZAR_REGISTRO;
import static sur.softsurena.metodos.M_Consulta.ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = {"controlConsulta", "init"}
)
public class M_ConsultaNGTest {

    public static int idConsulta, idPersona, idControlConsulta;

    @Test
    public static void testSqlSelect() {
        assertEquals(
                M_Consulta.sqlSelect(
                        Consulta.builder().build()
                ),
                """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE,
                    ESTADO
                FROM V_CONSULTAS
                """.strip()
        );

        assertEquals(
                M_Consulta.sqlSelect(
                        Consulta
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE,
                    ESTADO
                FROM V_CONSULTAS
                WHERE ID = -1
                """.strip()
        );

        assertEquals(M_Consulta.sqlSelect(Consulta
                .builder()
                .idControlConsulta(-1)
                .build()
        ),
                """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE,
                    ESTADO
                FROM V_CONSULTAS
                WHERE ID_CONTROL_CONSULTA = -1
                """.strip()
        );

        assertEquals(
                M_Consulta.sqlSelect(
                        Consulta
                                .builder()
                                .idPaciente(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE,
                    ESTADO
                FROM V_CONSULTAS
                WHERE ID_PACIENTE = -1
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public static void testSelect() {
        assertNotNull(
                M_Consulta.select(
                        Consulta
                                .builder()
                                .build()
                ),
                ""
        );

        assertNotNull(
                M_Consulta.select(
                        Consulta
                                .builder()
                                .id(-1)
                                .build()
                ),
                ""
        );

        assertNotNull(
                M_Consulta.select(
                        Consulta
                                .builder()
                                .idControlConsulta(-1)
                                .build()
                ),
                ""
        );

        assertNotNull(
                M_Consulta.select(
                        Consulta
                                .builder()
                                .idPaciente(-1)
                                .build()
                ),
                ""
        );
    }
    
    @Test(
            dependsOnMethods = {"testSelect"}
    )
    public static void testInsert() {
        M_PacienteNGTest.testInsert();
        idPersona = M_PacienteNGTest.idPersona;
        
        M_Control_ConsultaNGTest.testInsert();
        idControlConsulta = M_Control_ConsultaNGTest.idControlConsulta;
        //M_Control_ConsultaNGTest.idControlConsulta = null;
        
        Resultado result = M_Consulta.insert(
                Consulta
                        .builder()
                        .idPaciente(idPersona)
                        .idControlConsulta(
                                idControlConsulta
                        )
                        .linea(0)
                        .fecha(new Date(Calendar.getInstance().getTimeInMillis()))
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(M_Consulta.CONSULTA_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                M_Consulta.ERROR_AL_INSERTAR_CONSULTA
        );

        assertTrue(
                result.getId() > 0,
                "Error en id de la consulta. [CODIGO: %s ]"
                        .formatted(result.getId())
        );

        idConsulta = result.getId();
    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Consulta.update(
                        Consulta
                                .builder()
                                .id(idConsulta)
                                .idPaciente(idPersona)
                                .idControlConsulta(
                                        idControlConsulta
                                )
                                .fecha(new Date(Calendar.getInstance().getTimeInMillis()))
                                .linea(0)
                                .estado(Boolean.FALSE)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(CONSULTA_ACTUALIZADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ACTUALIZAR_REGISTRO
        );
    }

    @Test(
            dependsOnMethods = {"testUpdate"}
    )
    public static void testDelete() {
        assertEquals(
                M_Consulta.delete(idConsulta),
                Resultado
                        .builder()
                        .mensaje(CONSULTA_ELIMINADA_CORRECTAMENTE_DEL_SIST)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA
        );
        
        M_PacienteNGTest.idPersona = idPersona;
        M_PacienteNGTest.testDelete();
        
        M_Control_ConsultaNGTest.idControlConsulta = idControlConsulta;
        M_Control_ConsultaNGTest.testDelete();
        
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }

}
