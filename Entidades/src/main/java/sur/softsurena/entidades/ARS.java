package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ARS {
    private final Integer id;
    private final String descripcion;
    private final BigDecimal covertura;
    private final Boolean estado;
    private final Integer cantidad_registro;

    @Override
    public String toString() {
        return descripcion;
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("ARS{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", covertura=").append(covertura);
        sb.append(", estado=").append(estado);
        sb.append(", cantidad_registro=").append(cantidad_registro);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        hash = 29 * hash + Objects.hashCode(this.covertura);
        hash = 29 * hash + Objects.hashCode(this.estado);
        hash = 29 * hash + Objects.hashCode(this.cantidad_registro);
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
        final ARS other = (ARS) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.covertura, other.covertura)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return Objects.equals(this.cantidad_registro, other.cantidad_registro);
    }
    
    
}
