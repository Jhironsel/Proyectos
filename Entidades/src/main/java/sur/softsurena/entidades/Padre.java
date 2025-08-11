package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.metodos.M_Persona;

@Getter
@SuperBuilder
public class Padre {
    private final Integer id;
    
    private final Paginas pagina;

    @Override
    public String toString() {
        return M_Persona.select(
                Persona
                        .builder()
                        .idPersona(id)
                        .build()
        ).toString();
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Padre{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
