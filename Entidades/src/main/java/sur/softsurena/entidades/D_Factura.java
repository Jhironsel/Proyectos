package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class D_Factura {

    private final Integer id;
    private final Integer linea;
    private final Integer idFactura;
    private final Integer idProducto;
    private final Integer idPrecio;
    private final BigDecimal cantidad;

    @Override
    public String toString() {
        return id.toString();
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.linea);
        hash = 59 * hash + Objects.hashCode(this.idFactura);
        hash = 59 * hash + Objects.hashCode(this.idProducto);
        hash = 59 * hash + Objects.hashCode(this.idPrecio);
        hash = 59 * hash + Objects.hashCode(this.cantidad);
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
        final D_Factura other = (D_Factura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.linea, other.linea)) {
            return false;
        }
        if (!Objects.equals(this.idFactura, other.idFactura)) {
            return false;
        }
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        if (!Objects.equals(this.idPrecio, other.idPrecio)) {
            return false;
        }
        return Objects.equals(this.cantidad, other.cantidad);
    }
}
