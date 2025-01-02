package sur.softsurena.metodos;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.Control_Consulta;
import sur.softsurena.entidades.Paciente;
import static sur.softsurena.metodos.M_Consulta.CONSULTA_ELIMINADA_CORRECTAMENTE_DEL_SIST;
import static sur.softsurena.metodos.M_Consulta.ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA;
import sur.softsurena.utilidades.Resultado;

/**
 * 
 * @author jhironsel
 */
public class M_ConsultaNGTest {
    
    private static Integer idConsulta;

    public static Integer getIdConsulta() {
        return idConsulta;
    }
    
    public M_ConsultaNGTest() {
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
            priority = 0,
            description = """
                          Test que permite agregar una consulta al sistema.
                          esta crea el paciente y el control de la consulta.
                          """
    )
    public static void testInsert() {
        M_PacienteNGTest.testInsert();
        M_Control_ConsultaNGTest.testInsert();
        
        Resultado result = M_Consulta.insert(
                Consulta
                        .builder()
                        .paciente(
                                M_PacienteNGTest.generarPaciente()
                        )
                        .controlConsulta(
                                Control_Consulta
                                        .builder()
                                        .id(M_Control_ConsultaNGTest.controlConsulta().getId())
                                        .build()
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
            enabled = false,
            priority = 5,
            description = """
                          
                          """
    )
    public static void testSelect() {
        Consulta consulta = null;
        List expResult = null;
        List result = M_Consulta.select(consulta);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          
                          """
    )
    public static void testSqlSelect() {
        assertEquals(
                M_Consulta.sqlSelect(
                        Consulta.builder().build()
                ),
                """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE, 
                    ESTADO
                FROM CONSULTAS
                """.trim().strip()
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
                FROM CONSULTAS
                WHERE ID = -1
                """.trim().strip()
        );
        
        assertEquals(
                M_Consulta.sqlSelect(
                        Consulta
                                .builder()
                                .controlConsulta(
                                        Control_Consulta
                                                .builder()
                                                .id(-1)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE, 
                    ESTADO
                FROM CONSULTAS
                WHERE ID_CONTROL_CONSULTA = -1
                """.trim().strip()
        );
        
        assertEquals(
                M_Consulta.sqlSelect(
                        Consulta
                                .builder()
                                .paciente(
                                        Paciente
                                                .builder()
                                                .persona(
                                                        Persona
                                                                .builder()
                                                                .id_persona(-1)
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT ID, ID_CONTROL_CONSULTA, FECHA, LINEA, ID_PACIENTE, 
                    ESTADO
                FROM CONSULTAS
                WHERE ID_PACIENTE = -1
                """.trim().strip()
        );
    }

    @Test(
            enabled = true,
            priority = 5,
            description = """
                          Test que permite eliminar una consulta ya programada.
                          Tambien, elimina el control de la consulta creada y 
                          el paciente creado recientemente.
                          """
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
        
        
        M_PacienteNGTest.testDelete();
        M_Control_ConsultaNGTest.testDelete();
    }
}