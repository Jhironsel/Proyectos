package sur.softsurena.entidades;

import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Asegurado {

    private final Integer id;
    private final Integer idPersona;
    private final Integer idArs;
    private final String no_nss;
    private final Boolean estado;

    @Override
    public String toString() {
        return no_nss;
    }
}
