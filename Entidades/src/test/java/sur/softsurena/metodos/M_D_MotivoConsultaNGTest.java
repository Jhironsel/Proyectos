package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
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

    @Test(
            enabled = false
    )
    public void testAgregarDetallleConsulta() {
        //TODO Se debe crear proceso para agregar una consulta.

        assertEquals(
                M_D_MotivoConsulta.agregarDetallleConsulta(
                        D_Motivo_Consulta
                                .builder()
                                .id_consulta(0)
                                .id_motivo_consulta(0)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(DETALLES_AGREGADOS_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR__DETALLE__CONSULTA
        );
    }

    @Test(
            enabled = true
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
            enabled = false
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
