package sur.softsurena.entidades;

import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@SuperBuilder
@Getter
public class Asegurado {

    private final Integer id;
    private final ARS ars;
    private final Persona persona;
    private final String no_nss;
    private final Boolean estado;

    @Override
    public String toString() {
        return no_nss;
    }
}
