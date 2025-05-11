package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        groups = "turno"
)
public class M_TurnoNGTest {

    public static Integer idTurno;

    public M_TurnoNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
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
            enabled = true,
            dependsOnMethods = "testSqlSelect",
            groups = "turno.select",
            description = """
                          """
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
            enabled = true,
            priority = 0,
            description = """
                          """,
            groups = "turno.insert",
            dependsOnGroups = {"usuario.insert"}
    )
    public void testInsert() {
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
        }else{
            idTurno = listaTurno.getLast().getId();
            assertTrue(
                    idTurno >= 0, 
                    "Error al consultar los turnos del sistema."
            );
        }

    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """,
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

    /**
     * Test of delete method, of class M_Turno.
     */
    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """,
            dependsOnMethods = {"testInsert", "testUpdate"},
            groups = "turno.delete"
    )
    public void testDelete() {
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
