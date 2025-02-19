package sur.softsurena.entidades;

import java.sql.Time;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ControlConsulta {

    private final Integer id;
    private final String user_name;
    private final Integer cantidad;
    private final String dia;
    private final Time inicial;
    private final Time finall;
    private final Boolean estado;
    
    @Override
    public String toString() {
        return user_name;
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Control_Consulta{");
        sb.append("id=").append(id);
        sb.append(", user_name=").append(user_name);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", dia=").append(dia);
        sb.append(", inicial=").append(inicial);
        sb.append(", finall=").append(finall);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
}
