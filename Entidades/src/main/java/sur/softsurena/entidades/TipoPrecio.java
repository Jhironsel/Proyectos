package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * 
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class TipoPrecio {
    private final Integer id;
    private final String nombre;
    private final String descripcion;

    @Override
    public String toString() {
        return nombre;
    }
}
