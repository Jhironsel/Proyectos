package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Paginas {
    private final Integer nPaginaNro;
    private final Integer nCantidadFilas;
}
