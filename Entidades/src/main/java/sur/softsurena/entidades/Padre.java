package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@Getter
@SuperBuilder
public class Padre {
    private final Persona persona;
    private final Asegurado asegurado;

    @Override
    public String toString() {
        return persona.toString();
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Padre{");
        sb.append("persona=").append(persona);
        sb.append(", asegurado=").append(asegurado);
        sb.append('}');
        return sb.toString();
    }
}
