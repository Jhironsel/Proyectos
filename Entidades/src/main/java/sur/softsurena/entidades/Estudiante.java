package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@Getter
@SuperBuilder
public class Estudiante {

    private final Integer id;
    private final String matricula;
    
    private final Paginas pagina;
    
    @Override
    public String toString() {
        return id.toString();
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante{");
        sb.append("id=").append(id);
        sb.append(", matricula=").append(matricula);
        sb.append('}');
        return sb.toString();
    }

    
}
