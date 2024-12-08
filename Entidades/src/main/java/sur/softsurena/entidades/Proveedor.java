package sur.softsurena.entidades;

import sur.softsurena.abstracta.Persona;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Proveedor {

    private final Persona persona;
    private final String codigoProveedor;

    @Override
    public String toString() {
        return super.toString();
    }
}
