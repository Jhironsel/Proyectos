package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Turno;
import static sur.softsurena.metodos.M_Turno.TURNO_CERRADO_CORRECTAMENTE;
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
        Resultado result = M_Turno.insert(idUsuario);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testUpdate() {
        Integer idTurno = null;
        
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
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testGetTurnos() {
        List expResult = null;
        List result = M_Turno.select(
                Turno.builder().build()
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
        String result = M_Turno.sqlSelect(
                Turno
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
        result = M_Turno.sqlSelect(
                Turno
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
        result = M_Turno.sqlSelect(
                Turno
                        .builder()
                        .estado(Boolean.TRUE)
                        .turno_usuario("JHIRONSEL")
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
        result = M_Turno.sqlSelect(
                Turno
                        .builder()
                        .estado(Boolean.FALSE)
                        .turno_usuario("JHIRONSEL")
                        .build()
        );
        assertEquals(result.trim().strip(), expResult.trim().strip());
    }
}
