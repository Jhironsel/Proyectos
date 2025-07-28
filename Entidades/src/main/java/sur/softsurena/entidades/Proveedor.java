package sur.softsurena.entidades;

import sur.softsurena.abstracta.Persona;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.metodos.M_Persona;

@Getter
@SuperBuilder
public class Proveedor {

    private final Integer id;
    private final String codigoProveedor;
    
    private final Paginas pagina;

    @Override
    public String toString() {
        return M_Persona.select(
                Persona
                        .builder()
                        .idPersona(id)
                        .build()
        ).getLast().toString();
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
