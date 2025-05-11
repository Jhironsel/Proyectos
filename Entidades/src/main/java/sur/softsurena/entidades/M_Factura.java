package sur.softsurena.entidades;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class M_Factura {

    private final Integer id;
    private final Integer idCliente;
    private final Integer idContactoTel;
    private final Integer idContactoDir;
    private final Integer idContactoEmail;
    private final Integer idTurno;
    private final Timestamp fechaHora;
    private final Character estadoFactura;
    private final String nombreTemporal;
    private final String userName;
    
    private final Paginas pagina;

    @Override
    public String toString() {
        return id.toString();
    }
}

