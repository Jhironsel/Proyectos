package sur.softsurena.metodos;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Horario;
import static sur.softsurena.metodos.M_Horario.AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Horario.HORARIO_ELIMINADO__CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init"
)
public class M_HorarioNGTest {

    private static Integer idHorario;

    @Test
    public void testSqlSelect() {

        assertEquals(
                M_Horario.sqlSelect(
                        Horario
                                .builder()
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO
                FROM HORARIOS
                """.strip()
        );

        assertEquals(
                M_Horario.sqlSelect(
                        Horario
                                .builder()
                                .id(-2)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO
                FROM HORARIOS
                WHERE ID = -2
                """.strip()
        );

        assertEquals(
                M_Horario.sqlSelect(
                        Horario
                                .builder()
                                .descripcion("Entrada")
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO
                FROM HORARIOS
                WHERE DESCRIPCION STARTING WITH 'Entrada'
                """.strip()
        );

        assertEquals(
                M_Horario.sqlSelect(
                        Horario
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO
                FROM HORARIOS
                WHERE ESTADO
                """.strip()
        );

        assertEquals(
                M_Horario.sqlSelect(
                        Horario
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, HORA, TOLERANCIA, ESTADO
                FROM HORARIOS
                WHERE ESTADO IS FALSE
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Horario.select(Horario.builder().build()),
                "Error en la consultade horario."
        );
        assertNotNull(
                M_Horario.select(
                        Horario
                                .builder()
                                .id(-2)
                                .build()
                ),
                "Error en la consultade horario."
        );
        assertNotNull(
                M_Horario.select(
                        Horario
                                .builder()
                                .descripcion("Entrada")
                                .build()
                ),
                "Error en la consultade horario."
        );

        assertNotNull(
                M_Horario.select(
                        Horario
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                "Error en la consultade horario."
        );

        assertNotNull(
                M_Horario.select(
                        Horario
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                "Error en la consultade horario."
        );
    }

    @Test
    public void testInsert() {
        var hora = GregorianCalendar.getInstance();
        hora.set(Calendar.HOUR_OF_DAY, 14);
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);

        var resultado = M_Horario.insert(
                Horario
                        .builder()
                        .descripcion("Horario de prueba.!!!")
                        .hora(new Time(hora.getTimeInMillis()))
                        .tolerancia(10)
                        .estado(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                resultado,
                Resultado
                        .builder()
                        .mensaje(AGREGADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );

        idHorario = resultado.getId();
    }

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          """
    )
    public void testDelete() {
        assertEquals(
                M_Horario.delete(
                        Horario
                                .builder()
                                .id(idHorario)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(HORARIO_ELIMINADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

}
