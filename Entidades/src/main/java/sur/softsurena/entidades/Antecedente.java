package sur.softsurena.entidades;

import sur.softsurena.abstracta.Persona;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Antecedente {

    private final Integer id;
    private final Consulta consulta;
    private final String descripcion;
    

}
