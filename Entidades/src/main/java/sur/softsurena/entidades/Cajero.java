package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Cajero extends Usuario{

    private final Integer cantidadFactura;
    
    
    @Override
    public String toString() {
        return super.toString();
    }
}
