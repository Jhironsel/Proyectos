package sur.softsurena.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@Getter
@SuperBuilder
public class Paciente{

    private final Persona persona;
    private final BigDecimal pesoNacimiento;
    private final BigDecimal altura;
    private final BigDecimal perimetroCefalico;
    private final Boolean cesarea;
    private final Integer tiempoGestacion;
    private final BigDecimal masaCefalica;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente{");
        sb.append("persona=").append(persona);
        sb.append(", pesoNacimiento=").append(pesoNacimiento);
        sb.append(", altura=").append(altura);
        sb.append(", perimetroCefalico=").append(perimetroCefalico);
        sb.append(", cesarea=").append(cesarea);
        sb.append(", tiempoGestacion=").append(tiempoGestacion);
        sb.append(", masaCefalica=").append(masaCefalica);
        sb.append('}');
        return sb.toString();
    }
    
    
}
    