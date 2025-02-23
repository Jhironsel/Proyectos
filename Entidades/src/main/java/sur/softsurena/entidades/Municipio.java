package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Municipio {


    private final Integer id;
    private final Integer idProvincia;
    private final String nombre;

    

    @Override
    public String toString() {
        return nombre;
    }

}
