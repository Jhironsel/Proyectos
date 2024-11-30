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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlturaPeso{");
        sb.append("pesoKG=").append(pesoKG);
        sb.append(", estaturaMetro=").append(estaturaMetro);
        sb.append('}');
        return sb.toString();
    }
    
    
}
