package sur.softsurena.entidades;

import java.util.List;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Factura {

    private final Integer id;
    private final M_Factura m_factura;
    private final List<D_Factura> d_factura;

    @Override
    public String toString() {
        return id.toString();
    }

//    public static Factura getFacturaTest() {
//        return Factura
//                .builder()
//                .id(0)
//                .m_factura(//2
//                        M_Factura.getM_FacturaTest()
//                )
//                .d_factura(
//                        D_Factura.getListTest()
//                )
//                .build();
//    }
}
