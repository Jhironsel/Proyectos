package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_TurnoNGTest {

    public M_TurnoNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
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

    @Test(//TODO 24/11/2024 Esperando por este Test y demas.
            enabled = false,
            priority = 0,
            description = """
                          
                          """
    )
    public void testHabilitarTurno() {
        String idUsuario = "";
        Resultado expResult = null;
        Resultado result = M_Turno.habilitarTurno(idUsuario);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testCerrarTurno() {
        Integer idTurno = null;
        boolean expResult = false;
        boolean result = M_Turno.cerrarTurno(idTurno);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetTurnos() {
        List expResult = null;
        List result = M_Turno.getTurnos(
                FiltroBusqueda
                .builder()
                .build()
        );
        assertEquals(result, expResult);
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testSqlGetTurnos() {
        String expResult = """
                           SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, 
                           ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO 
                           FROM V_TURNOS 
                           WHERE ESTADO
                           """;
        String result = M_Turno.sqlGetTurnos(
                FiltroBusqueda
                        .builder()
                        .estado(Boolean.TRUE)
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.trim().strip());
        
//------------------------------------------------------------------------------
        expResult = """
                           SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, 
                           ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO 
                           FROM V_TURNOS 
                           WHERE ESTADO IS FALSE
                           """;
        result = M_Turno.sqlGetTurnos(
                FiltroBusqueda
                        .builder()
                        .estado(Boolean.FALSE)
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.trim().strip());

//------------------------------------------------------------------------------
        expResult = """
                           SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, 
                           ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO 
                           FROM V_TURNOS 
                           WHERE ESTADO AND UPPER(TRIM(TURNO_USUARIO)) LIKE UPPER(TRIM('JHIRONSEL'));
                           """;
        result = M_Turno.sqlGetTurnos(
                FiltroBusqueda
                        .builder()
                        .estado(Boolean.TRUE)
                        .criterioBusqueda("JHIRONSEL")
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.trim().strip());
        
//------------------------------------------------------------------------------
        expResult = """
                           SELECT ID, TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, 
                           ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, MONTO_CREDITO 
                           FROM V_TURNOS 
                           WHERE ESTADO IS FALSE AND UPPER(TRIM(TURNO_USUARIO)) LIKE UPPER(TRIM('JHIRONSEL'));
                           """;
        result = M_Turno.sqlGetTurnos(
                FiltroBusqueda
                        .builder()
                        .estado(Boolean.FALSE)
                        .criterioBusqueda("JHIRONSEL")
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.trim().strip());
    }
}
