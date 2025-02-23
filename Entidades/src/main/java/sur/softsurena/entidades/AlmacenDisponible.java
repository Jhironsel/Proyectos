package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@Getter
@SuperBuilder
public class AlmacenDisponible {

    private final Integer id;
    private final Integer idTurno;
    private final Integer idAlmacen;
    private final String UserName;
    
}
