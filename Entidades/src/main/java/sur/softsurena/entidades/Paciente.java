package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstractas.Persona;

@Getter
@SuperBuilder
public class Paciente extends Persona{

    private final Boolean cesarea;
    private final Integer tiempoGestacion;
    private final Boolean fumador;
    

    @Override
    public String toString() {
        return super.toString();
    }
}
    