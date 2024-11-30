package sur.softsurena.entidades;

import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class TipoSangre {
    private final int id;
    private final String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.descripcion);
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
        final TipoSangre other = (TipoSangre) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }
    
    
}
