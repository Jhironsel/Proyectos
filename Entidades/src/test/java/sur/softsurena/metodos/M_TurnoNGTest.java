package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.M_Factura;
import sur.softsurena.entidades.Turno;
import static sur.softsurena.metodos.M_Turno.TURNO_CERRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Turno.TURNO_ELIMINADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Turno.TURNO_HABILITADO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init",
        groups = "gTurno"
)
public class M_TurnoNGTest {

    public static Integer idTurno;

    @Test
    public void testSqlSelect() {

        assertEquals(
                M_Turno.sqlSelect(
                        Turno
                                .builder()
                                .build()
                ),
                """
                SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL,
                ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO
                FROM V_TURNOS
                """.strip()
        );
        //----------------------------------------------------------------------

        assertEquals(
                M_Turno.sqlSelect(
                        Turno
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL,
                ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO
                FROM V_TURNOS
                WHERE ESTADO
                """.strip()
        );
        //----------------------------------------------------------------------

        assertEquals(
                M_Turno.sqlSelect(
                        Turno
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL,
                ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO
                FROM V_TURNOS
                WHERE ESTADO IS FALSE
                """.strip()
        );

        //----------------------------------------------------------------------
        assertEquals(
                M_Turno.sqlSelect(
                        Turno
                                .builder()
                                .estado(Boolean.TRUE)
                                .turno_usuario("JHIRONSEL")
                                .build()
                ),
                """
                SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL,
                ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO
                FROM V_TURNOS
                WHERE ESTADO AND UPPER(TRIM(TURNO_USUARIO)) LIKE UPPER(TRIM('JHIRONSEL'));
                """.strip()
        );

//------------------------------------------------------------------------------
        assertEquals(
                M_Turno.sqlSelect(
                        Turno
                                .builder()
                                .estado(Boolean.FALSE)
                                .turno_usuario("JHIRONSEL")
                                .build()
                ),
                """
                SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL,
                ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO
                FROM V_TURNOS
                WHERE ESTADO IS FALSE AND UPPER(TRIM(TURNO_USUARIO)) LIKE UPPER(TRIM('JHIRONSEL'));
                """.strip()
        );
    }

    @Test(
            groups = "turno.select",
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Turno.select(
                        Turno
                                .builder()
                                .build()
                ),
                "Error al consultar los turnos del sistema."
        );

        assertNotNull(
                M_Turno.select(
                        Turno
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                "Error al consultar los turnos ACTIVOS del sistema."
        );

        assertNotNull(
                M_Turno.select(
                        Turno
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                "Error al consultar los turnos INACTIVOS del sistema."
        );

        assertNotNull(
                M_Turno.select(
                        Turno
                                .builder()
                                .estado(Boolean.TRUE)
                                .turno_usuario("CAJERO")
                                .build()
                ),
                "Error al consultar los turnos ACTIVOS del CAJERO del sistema."
        );

        assertNotNull(
                M_Turno.select(
                        Turno
                                .builder()
                                .estado(Boolean.FALSE)
                                .turno_usuario("JHIRONSEL")
                                .build()
                ),
                "Error al consultar los turnos INACTIVOS del CAJERO del sistema."
        );
    }

    @Test(
            groups = "turno.insert",
            dependsOnGroups = {"usuario.insert"}
    )
    public static void testInsert() {
        var listaTurno = M_Turno.select(
                Turno
                        .builder()
                        .estado(Boolean.TRUE)
                        .turno_usuario("CAJERO")
                        .build()
        );

        if (listaTurno.isEmpty()) {
            var resultado = M_Turno.insert("CAJERO");

            assertEquals(
                    resultado,
                    Resultado
                            .builder()
                            .estado(Boolean.TRUE)
                            .mensaje(TURNO_HABILITADO_CORRECTAMENTE)
                            .icono(JOptionPane.INFORMATION_MESSAGE)
                            .build()
            );

            idTurno = resultado.getId();
        } else {

            idTurno = listaTurno.getFirst().getId();
            assertTrue(
                    idTurno > 0,
                    "Error al consultar los turnos del sistema."
            );
        }

    }

    @Test(
            dependsOnMethods = "testInsert",
            groups = "turno.update"
    )
    public void testUpdate() {
        assertEquals(
                M_Turno.update(idTurno),
                Resultado
                        .builder()
                        .mensaje(TURNO_CERRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public synchronized static void testDelete() {
        M_M_Factura.select(
                M_Factura
                        .builder()
                        .idTurno(idTurno)
                        .build()
        ).stream().forEach(
                factura -> {

                    M_M_FacturaNGTest.idFactura = factura.getId();

                    M_M_FacturaNGTest.testDelete();
                }
        );

        assertEquals(
                M_Turno.delete(idTurno),
                Resultado
                        .builder()
                        .mensaje(TURNO_ELIMINADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }
}
