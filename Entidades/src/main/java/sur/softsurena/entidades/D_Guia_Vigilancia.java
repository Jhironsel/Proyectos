package sur.softsurena.entidades;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class D_Guia_Vigilancia {

    private final Integer id;
    private final Guia_Vigilancia_Desarrollo gvd;
    private final Paciente paciente;
    private final Timestamp fecha;

    @Override
    public String toString() {
        return paciente.toString();
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("D_Guia_Vigilancia{");
        sb.append("id=").append(id);
        sb.append(", gvd=").append(gvd);
        sb.append(", paciente=").append(paciente);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
}
