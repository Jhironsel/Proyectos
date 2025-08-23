package sur.softsurena.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstractas.Persona;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Empleado extends Persona{
    
    private final Integer idDepartamento;
    private final Integer idCargo;
    private final BigDecimal sueldoBruto;
    
    @Override
    public String toString() {
        
        return super.toString();
    }
}
