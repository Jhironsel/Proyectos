package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@Getter
@SuperBuilder
public class Estudiante {

    private final Persona persona;
    private final String matricula;
    
    @Override
    public String toString() {
        return persona.toString();
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante{");
        sb.append("persona=").append(persona);
        sb.append(", matricula=").append(matricula);
        sb.append('}');
        return sb.toString();
    }

    
}
