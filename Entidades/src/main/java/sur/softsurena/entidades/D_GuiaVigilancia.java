package sur.softsurena.entidades;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class D_GuiaVigilancia {

    private final Integer id;
    private final int idGuiaVigilanciaDesarrollo;
    private final int idPaciente;
    private final Timestamp fecha;

    @Override
    public String toString() {
        return id.toString();
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("D_Guia_Vigilancia{");
        sb.append("id=").append(id);
        sb.append(", idGuiaVigilanciaDesarrollo=").append(idGuiaVigilanciaDesarrollo);
        sb.append(", idPaciente=").append(idPaciente);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
}
