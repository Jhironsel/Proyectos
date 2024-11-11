package sur.softsurena.entidades;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class D_Motivo_Consulta {

    private final int id;
    private final int id_consulta;
    private final int id_motivo_consulta;

    @Override
    public String toString() {
        return "D_Motivo_Consulta{" + 
                    "id=" + id + 
                    ", id_consulta=" + id_consulta + 
                    ", id_Motivo_Consulta=" + id_motivo_consulta + 
                '}';
    }
    
    
}
