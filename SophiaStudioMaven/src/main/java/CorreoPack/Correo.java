package CorreoPack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Correo {
    private final String usuarioCorreo;
    private final String contrasena;
    private final String rutaArchivo;
    private final String nombreArchivo;
    private final String destino;
    private final String asunto;
    private final String mensaje;
}
