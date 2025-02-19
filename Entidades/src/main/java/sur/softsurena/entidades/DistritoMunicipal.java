package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class DistritoMunicipal {

    private final Integer id;
    private final Integer idMunicipio;
    private final String nombre;

    @Override
    public String toString() {
        return nombre;
    }
}
