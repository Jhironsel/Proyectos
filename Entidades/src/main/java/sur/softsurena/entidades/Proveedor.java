package sur.softsurena.entidades;

import sur.softsurena.abstractas.Persona;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Proveedor extends Persona{

    private final String codigoProveedor;
}
