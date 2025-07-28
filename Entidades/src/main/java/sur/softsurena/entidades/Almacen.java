package sur.softsurena.entidades;

import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Almacen {
    private final Integer id;
    private final String nombre;
    private final String ubicacion;
    private final Boolean estado;
    private final Boolean borrado;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.ubicacion);
        hash = 89 * hash + Objects.hashCode(this.estado);
        hash = 89 * hash + Objects.hashCode(this.borrado);
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
        final Almacen other = (Almacen) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.borrado, other.borrado)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Almacen{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", estado=").append(estado);
        sb.append(", borrado=").append(borrado);
        sb.append('}');
        return sb.toString();
    }

    
}
