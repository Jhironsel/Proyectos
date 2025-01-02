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
        return persona.toString();
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proveedor{");
        sb.append("persona=").append(persona);
        sb.append(", codigoProveedor=").append(codigoProveedor);
        sb.append('}');
        return sb.toString();
    }
}
