package sur.softsurena.metodos;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Control_Consulta;
import static sur.softsurena.metodos.M_Control_Consulta.CONSULTA_MODIFICADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Control_Consulta.CONTROL_CONSULTA_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Control_Consulta.CONTROL__CONSULTA_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Control_Consulta.ERROR_AL_AGREGAR__CONTROL__CONSULTA_AL_SIST;
import static sur.softsurena.metodos.M_Control_Consulta.ERROR_AL_BORRAR_CONTROL_DE_LA_CONSULTA;
import static sur.softsurena.metodos.M_Control_Consulta.ERROR_AL_MODIFICAR_CONSULTA;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_Control_ConsultaNGTest {

    private static Integer idControlConsulta;

    public M_Control_ConsultaNGTest() {
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

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Te permite registrar un control de consulta en el 
                          sistema.
                          """
    )
    public void testSelect() {
        assertNotNull(
                M_Control_Consulta.select(
                Control_Consulta
                        .builder()
                        .build()
        ), "Error al consultar los controles de consulta."
                
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSqlSelect() {
        
        assertEquals(
                M_Control_Consulta.sqlSelect(
                        Control_Consulta
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
                M_Control_Consulta.sqlSelect(
                        Control_Consulta
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
                M_Control_Consulta.sqlSelect(
                        Control_Consulta
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
            enabled = true,
            priority = 2,
            description = """
                          Te permite registrar un control de consulta en el 
                          sistema.
                          """
    )
    public static void testInsert() {

        Resultado result = M_Control_Consulta.insert(
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
    }

    @Test(
            enabled = true,
            priority = 3,
            description = ""
    )
    public void testUpdate() {
        
        Resultado result = M_Control_Consulta.update(
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
            enabled = true,
            priority = 4,
            description = "Prueba que elimina una consulta del sistema."
    )
    public static void testDelete() {
        Resultado result = M_Control_Consulta.delete(
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

    public static Control_Consulta controlConsulta() {
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
        
        return Control_Consulta
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
