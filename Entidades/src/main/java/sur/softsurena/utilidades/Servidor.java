package sur.softsurena.utilidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Servidor {
    private final String host;
    private final String puerto;
    private final String pathBaseDatos;
}

