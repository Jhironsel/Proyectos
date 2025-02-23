package sur.softsurena.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ConsultaAprobada {
    
    private final Integer id;
    private final String codAutorizacion;
    private final BigDecimal costo;
    private final BigDecimal descuento;
    private final String usuario;
    private final BigDecimal totalCosto;
    
    @Override
    public String toString() {
        return codAutorizacion;
    }
}
