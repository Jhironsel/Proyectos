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
import sur.softsurena.entidades.D_Motivo_Consulta;
import static sur.softsurena.metodos.M_D_MotivoConsulta.DETALLES_AGREGADOS_CORRECTAMENTE;
import static sur.softsurena.metodos.M_D_MotivoConsulta.ERROR_AL_ELIMINAR_DETALLE_DE_MOTIVO_DE_LA;
import static sur.softsurena.metodos.M_D_MotivoConsulta.ERROR_AL_INSERTAR__DETALLE__CONSULTA;
import static sur.softsurena.metodos.M_D_MotivoConsulta.borrarDetalleMotivoConsulta;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_D_MotivoConsultaNGTest {

    public M_D_MotivoConsultaNGTest() {
        System.out.println("sur.softsurena.metodos.M_D_MotivoConsultaNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {
//        Conexion.getInstance(
//                "sysdba",
//                "1",
//                "SoftSurena.db",
//                "localhost",
//                "3050",
//                "NONE"
//        );
//        assertTrue(
//                Conexion.verificar().getEstado(),
//                "Error al conectarse..."
//        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
//        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testAgregarDetallleConsulta() {
        //TODO Se debe crear proceso para agregar una consulta.
        Resultado result = M_D_MotivoConsulta.agregarDetallleConsulta(
                D_Motivo_Consulta
                        .builder()
                        .id_consulta(0)
                        .id_motivo_consulta(0)
                        .build()
        );
        
        assertTrue(
                result.getEstado(),
                ERROR_AL_INSERTAR__DETALLE__CONSULTA
        );

        assertEquals(
                result.getMensaje(),
                DETALLES_AGREGADOS_CORRECTAMENTE,
                ERROR_AL_INSERTAR__DETALLE__CONSULTA
        );

        assertEquals(
                result.getIcono(),
                JOptionPane.INFORMATION_MESSAGE,
                ERROR_AL_INSERTAR__DETALLE__CONSULTA
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Consulta los motivos que una consulta fue realizada.
                          """
    )
    public void testGetDetalleMotivo() {
        
        int idConsulta = 0;
        
        List<D_Motivo_Consulta> lista = M_D_MotivoConsulta.getDetalleMotivo(
                idConsulta
        );
        
        assertTrue(
                lista.isEmpty(),
                "Por el momento la lista no puede contener registros."
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testBorrarDetalleMotivoConsulta() {
        Resultado result = borrarDetalleMotivoConsulta(D_Motivo_Consulta.builder().build()
        );
        assertTrue(
                result.getEstado(),
                ERROR_AL_ELIMINAR_DETALLE_DE_MOTIVO_DE_LA
        );
    }
}
