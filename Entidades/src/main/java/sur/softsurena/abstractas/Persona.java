package sur.softsurena.abstractas;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Paginas;

@Getter
@SuperBuilder
public abstract class Persona {
    
    private final Integer idPersona;
    private final Character persona;
    private final String pnombre;
    private final String snombre;
    private final String apellidos;
    private final Character sexo;
    private final Date fecha_nacimiento;
    private final Date fecha_ingreso;
    private final Timestamp fecha_hora_ultima_update;
    private final Boolean estado;
    private final String rol;
    
    private final Generales generales;
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
        sb.append(", pagina=").append(pagina);
        sb.append(", generales=").append(generales);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.idPersona);
        hash = 83 * hash + Objects.hashCode(this.persona);
        hash = 83 * hash + Objects.hashCode(this.pnombre);
        hash = 83 * hash + Objects.hashCode(this.snombre);
        hash = 83 * hash + Objects.hashCode(this.apellidos);
        hash = 83 * hash + Objects.hashCode(this.sexo);
        hash = 83 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 83 * hash + Objects.hashCode(this.fecha_ingreso);
        hash = 83 * hash + Objects.hashCode(this.fecha_hora_ultima_update);
        hash = 83 * hash + Objects.hashCode(this.estado);
        hash = 83 * hash + Objects.hashCode(this.rol);
        hash = 83 * hash + Objects.hashCode(this.pagina);
        hash = 83 * hash + Objects.hashCode(this.generales);
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
        if (!Objects.equals(this.rol, other.rol)) {
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
        if (!Objects.equals(this.fecha_ingreso, other.fecha_ingreso)) {
            return false;
        }
        if (!Objects.equals(this.fecha_hora_ultima_update, other.fecha_hora_ultima_update)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.pagina, other.pagina)) {
            return false;
        }
        return Objects.equals(this.generales, other.generales);
    }

    
}
