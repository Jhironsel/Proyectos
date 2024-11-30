package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Cajero extends Usuario{

    private final Integer id;
    private final Integer cantidadFactura;
}
