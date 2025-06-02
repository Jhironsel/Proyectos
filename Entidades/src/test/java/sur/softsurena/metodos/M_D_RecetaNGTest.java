package sur.softsurena.metodos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.testng.annotations.Test;
import sur.softsurena.entidades.D_Receta;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_D_RecetaNGTest {

    
    @Test(
            enabled = false
    )
    public void testAgregarRecetaDetalle() {
        List<D_Receta> dr = new ArrayList<>();
        
        dr.add(
                D_Receta
                        .builder()
                        .linea(1)
                        .id_receta(0)
                        .id_Medicamento(0)
                        .cantidad(BigDecimal.ONE)
                        .detalleDosis("X cucharadas.")
                        .build()
        );
        
        M_D_Receta.agregarRecetaDetalle(dr);
    }

}