package sur.softsurena.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Dato_Nacimiento {

    private final Integer id;
    private final BigDecimal pesoNacimiento;
    private final BigDecimal altura;
    private final BigDecimal perimetrosCefalico;
    private final Boolean cesarea;
    private final BigDecimal tiempoGestacion;
    private final BigDecimal masaCefalica;
}
