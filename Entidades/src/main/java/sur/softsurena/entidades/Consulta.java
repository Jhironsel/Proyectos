package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Consulta {
    private final Integer id;
    private final Paciente paciente;
    private final Control_Consulta controlConsulta;
    private final Date fecha;
    private final Integer turno;
    private final Boolean estado;
    private final String usuario;

    @Override
    public String toString() {
        return turno.toString();
    }
    
    
}
