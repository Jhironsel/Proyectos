package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@Getter
@SuperBuilder
public class Guia_Vigilancia_Desarrollo {
    private final Integer id;
    private final int edad;//La edad es en meses.
    private final String caract_desarr_evaluar;

    @Override
    public String toString() {
        return caract_desarr_evaluar;
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Guia_Vigilancia_Desarrollo{");
        sb.append("id=").append(id);
        sb.append(", edad=").append(edad);
        sb.append(", caract_desarr_evaluar=").append(caract_desarr_evaluar);
        sb.append('}');
        return sb.toString();
    }
    
    
}
