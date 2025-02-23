package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Consulta {
    private final Integer id;
    private final Integer idControlConsulta;
    private final Integer idPaciente;
    private final Date fecha;
    private final Integer linea;
    private final Boolean estado;

    @Override
    public String toString() {
        return id.toString();
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Consulta{");
        sb.append("id=").append(id);
        sb.append(", idControlConsulta=").append(idControlConsulta);
        sb.append(", idPaciente=").append(idPaciente);
        sb.append(", fecha=").append(fecha);
        sb.append(", linea=").append(linea);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
    public static Consulta getConsultaTest(){
        return Consulta
                .builder()
                .id(0)
                .build();
    }
}
