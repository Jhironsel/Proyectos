package sur.softsurena.entidades;

import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Generales{
    
    private final Integer id;
    private final Integer idPersona;
    private final Integer idTipoSangre;
    private final String cedula;
    private final Character estado_civil;

    @Override
    public String toString() {
        return cedula;
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Generales{");
        sb.append("id=").append(id);
        sb.append(", idPersona=").append(idPersona);
        sb.append(", idTipoSangre=").append(idTipoSangre);
        sb.append(", cedula=").append(cedula);
        sb.append(", estado_civil=").append(estado_civil);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.idPersona);
        hash = 59 * hash + Objects.hashCode(this.idTipoSangre);
        hash = 59 * hash + Objects.hashCode(this.cedula);
        hash = 59 * hash + Objects.hashCode(this.estado_civil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Generales other = (Generales) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idPersona, other.idPersona)) {
            return false;
        }
        if (!Objects.equals(this.idTipoSangre, other.idTipoSangre)) {
            return false;
        }
        return Objects.equals(this.estado_civil, other.estado_civil);
    }
    
    
}
