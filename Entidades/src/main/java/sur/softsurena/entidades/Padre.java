package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@Getter
@SuperBuilder
public class Padre {
    private final Persona persona;
    private final Asegurado asegurado;
}
