package sur.softsurena.entidades;

import java.sql.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Persona {
    
    private final Integer idPersona;
    private final Character persona;
    private final String pnombre;
    private final String snombre;
    private final String apellidos;
    private final Character sexo;
    private final Date fecha_nacimiento;
    private final Date fecha_ingreso;
    private final Date fecha_hora_ultima_update;
    private final Boolean estado;
    private final String rol;
    private final Paginas pagina;

    @Override
    public String toString() {
        StringBuilder nombre = new StringBuilder();
        
        nombre
                .append(pnombre)
                .append(" ")
                .append(Objects.isNull(snombre) ? "" : snombre)
                .append(Objects.isNull(snombre) ? "" : " ")
                .append(apellidos);

        return nombre.toString();
    }

    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append(", persona=").append(persona);
        sb.append(", pnombre=").append(pnombre);
        sb.append(", snombre=").append(snombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", sexo=").append(sexo);
        sb.append(", fecha_nacimiento=").append(fecha_nacimiento);
        sb.append(", fecha_ingreso=").append(fecha_ingreso);
        sb.append(", fecha_hora_ultima_update=").append(fecha_hora_ultima_update);
        sb.append(", estado=").append(estado);
        sb.append(", rol=").append(rol);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idPersona);
        hash = 47 * hash + Objects.hashCode(this.persona);
        hash = 47 * hash + Objects.hashCode(this.pnombre);
        hash = 47 * hash + Objects.hashCode(this.snombre);
        hash = 47 * hash + Objects.hashCode(this.apellidos);
        hash = 47 * hash + Objects.hashCode(this.sexo);
        hash = 47 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 47 * hash + Objects.hashCode(this.fecha_ingreso);
        hash = 47 * hash + Objects.hashCode(this.fecha_hora_ultima_update);
        hash = 47 * hash + Objects.hashCode(this.estado);
        hash = 47 * hash + Objects.hashCode(this.rol);
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
        final Persona other = (Persona) obj;

        if (!Objects.equals(this.pnombre, other.pnombre)) {
            return false;
        }
        if (!Objects.equals(this.snombre, other.snombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }

        if (!Objects.equals(this.idPersona, other.idPersona)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }
}
