package sur.softsurena.entidades;

import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Carton_Bingo {

    private final Integer id;
    private final Integer carton_hash;
    private final Date fecha_creacion;
    private final List<Integer> matriz_obj;
    private final Boolean estado;
}
