package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.D_GuiaVigilancia;
import static sur.softsurena.metodos.M_D_GuiaVigilancia.GUIA_DE__DESARROLLO_AGREGADA_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_D_GuiaVigilanciaNGTest {

    private Integer idRegistro;

    @Test
    public void testInsert() {
        Resultado result = M_D_GuiaVigilancia.insert(D_GuiaVigilancia
                .builder()
                .idPaciente(0)
                .idGuiaVigilanciaDesarrollo(1)
                .build()
        );
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(GUIA_DE__DESARROLLO_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        idRegistro = result.getId();
    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        int idGVD = 0;
        int idPaciente = 0;
        Resultado agregarGuiaVigilancia = M_D_GuiaVigilancia.update(D_GuiaVigilancia
                .builder()
                .id(idRegistro)
                .idPaciente(idPaciente)
                .idGuiaVigilanciaDesarrollo(idGVD)
                .build()
        );
        assertEquals(
                agregarGuiaVigilancia,
                Resultado
                        .builder()
                        .mensaje(
                                M_D_GuiaVigilancia.GUIA_DE__DESARROLLO_ACTUALIZADA_CORRECTAMENTE
                        )
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public void testDelete() {
        
        assertEquals(
                M_D_GuiaVigilancia.delete(D_GuiaVigilancia
                .builder()
                .id(idRegistro)
                .build()
        ),
                Resultado
                        .builder()
                        .mensaje(
                                M_D_GuiaVigilancia.GUIA_DE_DESARROLLO_ELIMINADA_CORRECTAMENTE
                        )
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }
}
