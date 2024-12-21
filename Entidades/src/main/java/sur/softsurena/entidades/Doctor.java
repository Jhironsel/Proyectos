package sur.softsurena.entidades;

import sur.softsurena.abstracta.Persona;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Doctor {
    
    private final Persona persona;
    private final String especialidad;
    private final String execuatur;

    @Override
    public String toString() {
        return persona.toString();
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Doctor{");
        sb.append("persona=").append(persona);
        sb.append(", especialidad=").append(especialidad);
        sb.append(", execuatur=").append(execuatur);
        sb.append('}');
        return sb.toString();
    }
}
