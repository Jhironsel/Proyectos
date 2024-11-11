package sur.softsurena.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class TipoImpuesto {
    private final Integer id;
    private final String nombre;
    private final BigDecimal porcentaje;

    @Override
    public String toString() {
        return nombre;
    }
}
