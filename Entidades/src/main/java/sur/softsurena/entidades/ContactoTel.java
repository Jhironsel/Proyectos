package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ContactoTel {
    private final Integer id;//Identificador de registro.
    private final Integer idPersona;//Identificador de la persona propietario del numero de telefono. 
    private final String telefono;//Registros de telefono que sera unico para una persona, Dos o mas persona pueden ser propietario de un numero telefonico.
    private final String tipo;//Indica si es un celular movil, residencial, fax, entre otros.
    private final Date fecha;//Fecha de registro consultado.
    private final Boolean estado;//Estado del registro, indicando si es activo o inactivo.
    private final Boolean porDefecto;//Indica cual es el telefono registrado por defecto de la persona.
    
    @Override
    public String toString() {
        return telefono;
    }
}
