package sur.softsurena.metodos;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
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
import sur.softsurena.entidades.Consulta;
import sur.softsurena.entidades.Control_Consulta;
import static sur.softsurena.metodos.M_Consulta.CONSULTA_ELIMINADA_CORRECTAMENTE_DEL_SIST;
import static sur.softsurena.metodos.M_Consulta.ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA;
import sur.softsurena.utilidades.Resultado;

@Getter
public class M_ConsultaNGTest {

    private final M_PacienteNGTest paciente;
    private final M_Control_ConsultaNGTest controlConsulta;
    private int idConsulta;

    public M_ConsultaNGTest() {
        paciente = new M_PacienteNGTest();
        controlConsulta = new M_Control_ConsultaNGTest();
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
    public void testInsert() {
        paciente.testInsert();
        controlConsulta.testAgregarControlConsulta();
        
        Resultado result = M_Consulta.insert(
                Consulta
                        .builder()
                        .paciente(
                                paciente.generarPaciente()
                        )
                        .controlConsulta(
                                Control_Consulta
                                        .builder()
                                        .id(controlConsulta.getIdControlConsulta())
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
            description = "",
            priority = 0
    )
    public void testGetConsulta() {
        String fecha = "";
        ResultSet expResult = null;
        List<Consulta> result = M_Consulta.getConsulta(new Date(0));
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testGetControlConsulta() {
        String fecha = "";
        boolean expResult = false;
        boolean result = M_Consulta.getControlConsulta(fecha);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Test que permite eliminar una consulta ya programada.
                          Tambien, elimina el control de la consulta creada y 
                          el paciente creado recientemente.
                          """
    )
    public void testEliminarConsulta() {
        assertEquals(
                M_Consulta.eliminarConsulta(idConsulta), 
                Resultado
                        .builder()
                        .mensaje(CONSULTA_ELIMINADA_CORRECTAMENTE_DEL_SIST)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(), 
                ERROR_AL_ELIMINAR_LA_CONSULTA_DEL_SISTEMA
        );
        
        
        controlConsulta.testBorrarControlConsulta();
        paciente.testDelete();
    }
}