package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ContactoEmail {
    
    private final Integer id;
    private final Integer idPersona;
    private final String email;
    private final Date fecha;
    private final Boolean estado;
    private final Boolean porDefecto;

    @Override
    public String toString() {
        return email;
    }

}
