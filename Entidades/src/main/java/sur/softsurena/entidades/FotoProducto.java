package sur.softsurena.entidades;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

/**
 * POJO de la tabla FOTO_PERSONA de la base de datos.
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class FotoProducto {
    private final Integer id;
    private final Integer idProducto;
    private final String foto;
    private final Timestamp fechaHoraCreacion;
    private final Boolean actual;
}
