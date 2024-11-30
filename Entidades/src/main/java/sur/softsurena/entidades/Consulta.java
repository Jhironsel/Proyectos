package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Consulta {
    private final Integer id;
    private final Control_Consulta controlConsulta;
    private final Date fecha;
    private final Integer linea;
    private final Paciente paciente;
    private final Boolean estado;
    private final String usuario;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Consulta{");
        sb.append("id=").append(id);
        sb.append(", controlConsulta=").append(controlConsulta);
        sb.append(", fecha=").append(fecha);
        sb.append(", linea=").append(linea);
        sb.append(", paciente=").append(paciente);
        sb.append(", estado=").append(estado);
        sb.append(", usuario=").append(usuario);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        
    }
    
    public static Consulta getConsultaTest(){
        return Consulta.builder().build();
    }
}
