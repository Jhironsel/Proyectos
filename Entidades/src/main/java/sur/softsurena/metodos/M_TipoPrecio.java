package sur.softsurena.metodos;

import java.util.ArrayList;
import java.util.List;
import sur.softsurena.entidades.TipoPrecio;

/**
 *
 * @author jhironsel
 */
public class M_TipoPrecio {
    public static List<TipoPrecio> getTipoPrecios(){
        List<TipoPrecio> lista = new ArrayList<>();
        
        lista.add(
                TipoPrecio
                        .builder()
                        .id(0)
                        .nombre("Regular")
                        .descripcion("Precio de venta estándar")
                        .build()
        );
        
        lista.add(
                TipoPrecio
                        .builder()
                        .id(1)
                        .nombre("Oferta")
                        .descripcion("Precio promocional por tiempo limitado")
                        .build()
        );
        
        lista.add(
                TipoPrecio
                        .builder()
                        .id(2)
                        .nombre("Mayorista")
                        .descripcion("Precio con descuento para compras al por mayor")
                        .build()
        );
        
        return lista;
        
    }
}
