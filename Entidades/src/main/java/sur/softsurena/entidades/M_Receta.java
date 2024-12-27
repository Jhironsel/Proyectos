package sur.softsurena.entidades;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class M_Receta {

    private final Integer id;
    private final Consulta consulta;
    private final Timestamp fecha;
}
