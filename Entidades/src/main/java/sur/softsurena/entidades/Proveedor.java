package sur.softsurena.entidades;

import sur.softsurena.abstracta.Persona;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Proveedor {

    private final Integer id;
    private final String codigoProveedor;

    @Override
    public String toString() {
        return id.toString();
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proveedor{");
        sb.append("id=").append(id);
        sb.append(", codigoProveedor=").append(codigoProveedor);
        sb.append('}');
        return sb.toString();
    }
}
