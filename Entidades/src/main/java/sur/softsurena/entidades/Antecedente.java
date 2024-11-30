package sur.softsurena.entidades;

import sur.softsurena.abstracta.Persona;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Antecedente {

    private final int id;
    private final int id_consulta;
    private final String descripcion;
    

}
