package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Esta clase permite definir los atributos de una mensualidad de un 
 * estudiantes.
 * 
 * 
 * El cual requiere un identificador de la mensualidad y un estdiante.
 * 
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Mensualidad {
    private final Integer id;
    private final Integer idEstudiante;
    private final BigDecimal monto;
    private final Date fecha;
    
}
