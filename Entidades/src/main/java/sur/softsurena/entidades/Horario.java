package sur.softsurena.entidades;

import java.sql.Time;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Horario {
    private final Integer id;
    private final String descripcion;
    private final Time hora;
    private final int tolerancia;
    private final Boolean estado;

    @Override
    public String toString() {
        return descripcion;
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Horario{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", hora=").append(hora);
        sb.append(", tolerancia=").append(tolerancia);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
