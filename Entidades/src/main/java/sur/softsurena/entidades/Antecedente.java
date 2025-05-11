package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Antecedente {

    private final Integer id;
    private final Integer idConsulta;
    private final String descripcion;
}
