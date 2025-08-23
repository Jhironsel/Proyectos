package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstractas.Persona;

@Getter
@SuperBuilder
public class Estudiante extends Persona{

    private final String matricula;
    
    @Override
    public String toString() {
        return super.toString();
    }
}
