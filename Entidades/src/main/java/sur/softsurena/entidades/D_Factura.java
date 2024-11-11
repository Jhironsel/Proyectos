package sur.softsurena.entidades;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class D_Factura {

    private final Integer idLinea;
    private final Producto producto;
    private final BigDecimal precio;
    private final BigDecimal cantidad;
    
    @Override
    public String toString() {
        return "DetalleFactura{"
                + "idLinea=" + idLinea
                + ", idProducto=" + producto.getId()
                + ", descripcion=" + producto.getDescripcion()
                + ", precio=" + precio.doubleValue()
                + ", cantidad=" + cantidad
                + '}';
    }
}
