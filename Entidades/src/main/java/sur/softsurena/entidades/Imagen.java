package sur.softsurena.entidades;

import java.io.File;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Imagen {
    private final int id;
    private final File path;
    private final String imagen64;
    
}
