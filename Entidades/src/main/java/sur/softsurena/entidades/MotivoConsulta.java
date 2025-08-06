package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MotivoConsulta {
    private final int id;
    private final String descripcion;
}
