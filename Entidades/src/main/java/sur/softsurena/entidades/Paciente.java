package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.metodos.M_Persona;

@Getter
@SuperBuilder
public class Paciente{

    private final Integer id;
    private final Boolean cesarea;
    private final Integer tiempoGestacion;
    private final Boolean fumador;

    @Override
    public String toString() {
        return M_Persona.select(
                Persona
                        .builder()
                        .idPersona(id)
                        .build()
        ).getFirst().toString();
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente{");
        sb.append("id=").append(id);
        sb.append(", cesarea=").append(cesarea);
        sb.append(", tiempoGestacion=").append(tiempoGestacion);
        sb.append(", fumador=").append(fumador);
        sb.append('}');
        return sb.toString();
    }
}
    