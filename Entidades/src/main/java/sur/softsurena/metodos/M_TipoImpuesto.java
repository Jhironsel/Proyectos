package sur.softsurena.metodos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import sur.softsurena.entidades.TipoImpuesto;

/**
 *
 * @author jhironsel
 */
public class M_TipoImpuesto {
    public static List<TipoImpuesto> getTipoImpuesto(){
        List<TipoImpuesto> lista = new ArrayList<>();
        
        lista.add(
                TipoImpuesto
                        .builder()
                        .id(1)
                        .nombre("General")
                        .porcentaje(new BigDecimal("18,00"))
                        .build()
        );
        
        lista.add(
                TipoImpuesto
                        .builder()
                        .id(2)
                        .nombre("Reducido")
                        .porcentaje(new BigDecimal("16,00"))
                        .build()
        );
        
        lista.add(
                TipoImpuesto
                        .builder()
                        .id(1)
                        .nombre("Excentos")
                        .porcentaje(BigDecimal.ZERO)
                        .build()
        );
        
        return lista;
    }
}
