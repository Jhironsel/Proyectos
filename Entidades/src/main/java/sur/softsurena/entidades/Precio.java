package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author jhironsel
 */
@SuperBuilder
@Getter
public class Precio {
    private final Integer id;
    private final Integer idProducto;
    private final Integer idTipoPrecio;
    private final Integer idTipoImpusto;
    private final BigDecimal precio;
    private final String moneda;
    private final Date fechaInicio;
    private final Date fechaFin;
    private final BigDecimal descuento;
    private final BigDecimal costoEnvio;
    private final Boolean estado;

    @Override
    public String toString() {
        return id.toString();
    }
}
