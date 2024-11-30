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
    private final Cliente cliente;
    private final ContactoTel contactoTel;
    private final Direccion direccion;
    private final ContactoEmail contactoEmail;
    private final Turno turno;
    private final Timestamp fechaHora;
    private final Character estadoFactura;
    private final String nombreTemporal;
    private final String userName;

    @Override
    public String toString() {
        return cliente.toString();
    }

    public static M_Factura getM_FacturaTest() {
        return M_Factura
                .builder()
                .id(0)
                .contactoTel(
                        ContactoTel
                                .builder()
                                .id(0)
                                .build()
                )
                .contactoEmail(
                        ContactoEmail
                                .builder()
                                .id(0)
                                .build()
                )
                .direccion(
                        Direccion
                                .builder()
                                .id(0)
                                .build()
                )
                .turno(//1
                        Turno
                                .builder()
                                .id(0)
                                .build()
                )
                .fechaHora(
                        new Timestamp(
                                new GregorianCalendar()
                                        .getTimeInMillis()
                        )
                )
                .estadoFactura('e')
                .build();
    }
}

