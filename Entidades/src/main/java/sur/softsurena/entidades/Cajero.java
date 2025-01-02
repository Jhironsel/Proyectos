package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@Getter
@SuperBuilder
public class Cajero{

    private final Integer id;
    private final Integer cantidadFactura;
    private final Usuario usuario;
}
