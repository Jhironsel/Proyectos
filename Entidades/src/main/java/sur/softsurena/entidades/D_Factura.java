package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class D_Factura {

    private final Integer id;
    private final Integer linea;
    private final M_Factura m_factura;
    private final Producto producto;
    private final Precio precio;
    private final BigDecimal cantidad;

    @Override
    public String toString() {
        return "D_Factura{"
                + " id=" + id
                + ", linea=" + linea
                + ", m_factura=" + m_factura
                + ", producto=" + producto
                + ", precio=" + precio
                + ", cantidad=" + cantidad
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.linea);
        hash = 97 * hash + Objects.hashCode(this.m_factura);
        hash = 97 * hash + Objects.hashCode(this.producto);
        hash = 97 * hash + Objects.hashCode(this.precio);
        hash = 97 * hash + Objects.hashCode(this.cantidad);
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
        if (!Objects.equals(this.m_factura, other.m_factura)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        return Objects.equals(this.cantidad, other.cantidad);
    }
    
    

    public static List<D_Factura> getListTest() {
        return List.of(
                D_Factura
                        .builder()
                        .linea(0)
                        .m_factura(
                                M_Factura.getM_FacturaTest()
                        )
                        .producto(
                                Producto
                                        .builder()
                                        .id(0)
                                        .build()
                        )
                        .precio(
                                Precio
                                        .builder()
                                        .id(0)
                                        .build()
                        )
                        .cantidad(BigDecimal.TEN)
                        .build(),
                D_Factura
                        .builder()
                        .linea(1)
                        .m_factura(
                                M_Factura.getM_FacturaTest()
                        )
                        .producto(
                                Producto
                                        .builder()
                                        .id(0)
                                        .build()
                        )
                        .precio(
                                Precio
                                        .builder()
                                        .id(0)
                                        .build()
                        )
                        .cantidad(BigDecimal.TEN)
                        .build(),
                D_Factura
                        .builder()
                        .linea(2)
                        .m_factura(
                                M_Factura.getM_FacturaTest()
                        )
                        .producto(
                                Producto
                                        .builder()
                                        .id(0)
                                        .build()
                        )
                        .precio(
                                Precio
                                        .builder()
                                        .id(0)
                                        .build()
                        )
                        .cantidad(BigDecimal.TEN)
                        .build()
        );
    }
}
