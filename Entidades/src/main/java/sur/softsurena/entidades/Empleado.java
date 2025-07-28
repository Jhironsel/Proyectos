package sur.softsurena.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.metodos.M_Persona;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Empleado {
    private final Integer id;
    private final Integer idDepartamento;
    private final Integer idCargo;
    private final BigDecimal sueldoBruto;
    
    private final Paginas pagina;
    
    @Override
    public String toString() {
        
        return M_Persona.select(
                Persona
                        .builder()
                        .idPersona(id)
                        .build()
        ).getLast().toString();
    }
}
