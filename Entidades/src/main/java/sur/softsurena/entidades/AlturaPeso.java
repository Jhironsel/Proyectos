package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class AlturaPeso {
    private final Float pesoKG;
    private final Float estaturaMetro;
}
