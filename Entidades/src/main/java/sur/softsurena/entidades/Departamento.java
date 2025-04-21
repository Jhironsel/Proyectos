package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Departamento {
    private final Integer id;
    private final String nombre;
    private final String descripcion;
    private final Boolean estado;
}
