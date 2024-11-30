package sur.softsurena.entidades;

import java.sql.Time;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Control_Consulta {

    private final int id;
    private final String user_name;
    private final int cantidad;
    private final String dia;
    private final Time inicial;
    private final Time finall;
    private final Boolean estado;

    @Override
    public String toString() {
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
