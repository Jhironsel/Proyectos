package sur.softsurena.metodos;

import java.util.Calendar;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Antecedente;
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.ControlConsulta;
import static sur.softsurena.metodos.M_ControlConsulta.CONSULTA_MODIFICADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ControlConsulta.CONTROL_CONSULTA_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ControlConsulta.CONTROL__CONSULTA_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ControlConsulta.ERROR_AL_AGREGAR__CONTROL__CONSULTA_AL_SIST;
import static sur.softsurena.metodos.M_ControlConsulta.ERROR_AL_BORRAR_CONTROL_DE_LA_CONSULTA;
import static sur.softsurena.metodos.M_ControlConsulta.ERROR_AL_MODIFICAR_CONSULTA;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init",
        groups = "controlConsulta"
)
public class M_Control_ConsultaNGTest {

    public static Integer idControlConsulta;

    @Test(
            enabled = true,
            alwaysRun = true
    )
    public void testSqlSelect() {

        assertEquals(
                M_ControlConsulta.sqlSelect(
                        ControlConsulta
                                .builder()
                                .build()
                ),
                """
                SELECT ID, USER_NAME, CANTIDAD_PACIENTE, DIA, INICIAL, FINAL,
                      ESTADO
                FROM V_CONTROL_CONSULTA
                """.trim().strip()
        );

        assertEquals(
                M_ControlConsulta.sqlSelect(
                        ControlConsulta
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID, USER_NAME, CANTIDAD_PACIENTE, DIA, INICIAL, FINAL,
                      ESTADO
                FROM V_CONTROL_CONSULTA
                WHERE ID = -1
                """.trim().strip()
        );

        assertEquals(
                M_ControlConsulta.sqlSelect(
                        ControlConsulta
                                .builder()
                                .user_name("Jhironsel")
                                .build()
                ),
                """
                SELECT ID, USER_NAME, CANTIDAD_PACIENTE, DIA, INICIAL, FINAL,
                      ESTADO
                FROM V_CONTROL_CONSULTA
                WHERE USER_NAME STARTING WITH 'Jhironsel'
                """.trim().strip()
        );
    }
//------------------------------------------------------------------------------

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_ControlConsulta.select(
                        ControlConsulta
                                .builder()
                                .build()
                ),
                "Error al consultar los controles de consulta."
        );
    }

    @Test
    public static void testInsert() {
        var listaControlConsulta = M_ControlConsulta.select(
                ControlConsulta
                        .builder()
                        .build()
        );

        if (listaControlConsulta.isEmpty()) {
            Resultado result = M_ControlConsulta.insert(
                    controlConsulta()
            );

            assertEquals(
                    result,
                    Resultado
                            .builder()
                            .mensaje(CONTROL_CONSULTA_AGREGADO_CORRECTAMENTE)
                            .icono(JOptionPane.INFORMATION_MESSAGE)
                            .estado(Boolean.TRUE)
                            .build(),
                    ERROR_AL_AGREGAR__CONTROL__CONSULTA_AL_SIST
            );

            assertTrue(
                    result.getId() > 0,
                    ERROR_AL_AGREGAR__CONTROL__CONSULTA_AL_SIST
            );

            idControlConsulta = result.getId();
        } else {
            M_Consulta.select(
                    Consulta
                            .builder()
                            .build()
            ).stream().forEach(
                    consulta -> {

                        M_Antecedente.select(
                                Antecedente
                                        .builder()
                                        .build()
                        ).stream().forEach(
                                antecedente -> {
                                    M_Antecedente.delete(
                                            Antecedente
                                                    .builder()
                                                    .id(antecedente.getId())
                                                    .build()
                                    );
                                }
                        );

                        M_Consulta.delete(
                                consulta.getId()
                        );
                    }
            );
            listaControlConsulta.stream().forEach(
                    controlConsulta -> {
                        M_ControlConsulta.delete(
                                controlConsulta.getId()
                        );
                    }
            );
            testInsert();
        }

    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {

        Resultado result = M_ControlConsulta.update(
                controlConsulta()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CONSULTA_MODIFICADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_MODIFICAR_CONSULTA
        );
    }

    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public static void testDelete() {
        Resultado result = M_ControlConsulta.delete(
                idControlConsulta
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(CONTROL__CONSULTA_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_CONTROL_DE_LA_CONSULTA
        );
    }

    public static ControlConsulta controlConsulta() {
        Calendar horaInicial = Calendar.getInstance();

        horaInicial.set(
                Calendar.MINUTE,
                -2
        );

        horaInicial.set(
                Calendar.SECOND,
                0
        );

        horaInicial.set(
                Calendar.MILLISECOND,
                0
        );

        Calendar horaFinal = Calendar.getInstance();
        horaFinal.set(
                Calendar.MINUTE,
                10
        );

        horaFinal.set(
                Calendar.SECOND,
                10
        );

        horaFinal.set(
                Calendar.MILLISECOND,
                0
        );

        return ControlConsulta
                .builder()
                .id(idControlConsulta)
                .user_name("SYSDBA")
                .cantidad(3)
                .dia("LU")
                .inicial(
                        new java.sql.Time(
                                horaInicial.getTimeInMillis()
                        )
                )
                .finall(
                        new java.sql.Time(
                                horaFinal.getTimeInMillis()
                        )
                )
                .estado(Boolean.TRUE)
                .build();
    }
}
