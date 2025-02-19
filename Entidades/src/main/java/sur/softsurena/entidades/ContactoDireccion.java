package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ContactoDireccion {
    private final Integer id;
    private final Integer idPersona;
    private final Integer idProvincia;
    private final Integer idMunicipio;
    private final Integer idDistritoMunicipal;
    private final Integer idCodigoPostal;
    private final String direccion;
    private final Date fecha;
    private final Boolean estado;
    private final Boolean porDefecto;
    private final Character accion;
   

    @Override
    public String toString() {
        return direccion;
    }
}