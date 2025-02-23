package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * 
 * 
 * Esta clase esta representada por la tabla de T_GUIA_VIGILANCIA_DESARROLLO.
 * 
 * @author jhironsel
 */
@Getter
@SuperBuilder
public class GuiaVigilanciaDesarrollo {
    private final Integer id;
    private final int edad;//La edad es en meses.
    private final String caract_desarr_evaluar;//Caracteristica del desarrollo a evaluar

    @Override
    public String toString() {
        return caract_desarr_evaluar;
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("GuiaVigilanciaDesarrollo{");
        sb.append("id=").append(id);
        sb.append(", edad=").append(edad);
        sb.append(", caract_desarr_evaluar=").append(caract_desarr_evaluar);
        sb.append('}');
        return sb.toString();
    }
    
    
}
