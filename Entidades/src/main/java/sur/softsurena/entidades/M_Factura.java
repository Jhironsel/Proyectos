package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

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

    public static M_Factura getM_FacturaTest() {
        return M_Factura
                .builder()
                .id(0)
                .idCliente(0)
                .idContactoTel(0)
                .idContactoDir(0)
                .idContactoEmail(0)
                .idTurno(0)
                .fechaHora(
                        new Timestamp(
                                new GregorianCalendar()
                                        .getTimeInMillis()
                        )
                )
                .estadoFactura('n')
                .nombreTemporal("")
                .build();
    }
}

