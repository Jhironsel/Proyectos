
package sur.softsurena.entidades;

import sur.softsurena.abstracta.Persona;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Deuda{
    private final Integer id;
    private final Integer idCliente;
    private final String concepto;
    private final BigDecimal monto;
    private final Date fecha;
    private final Time hora;
    private final Character estadoDeuda;

    @Override
    public String toString() {
        return id.toString();
    }
}