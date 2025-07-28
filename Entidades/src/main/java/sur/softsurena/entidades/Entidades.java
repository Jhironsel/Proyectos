package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Entidades {
    private final boolean cliente;
    private final boolean empleado;
    private final boolean estudiante;
    private final boolean paciente;
    private final boolean padre;
    private final boolean proveedor;
    
}
