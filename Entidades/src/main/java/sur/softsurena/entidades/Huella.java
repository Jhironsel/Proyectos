package sur.softsurena.entidades;

import java.io.File;
import javax.swing.ImageIcon;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Huella {
    private final Integer id;
    private final Integer idPersona;
    private final String tipoDedo;
    private final File pathImagen;
    private final ImageIcon imagen;
}
