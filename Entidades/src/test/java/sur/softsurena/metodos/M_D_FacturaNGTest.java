package sur.softsurena.metodos;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.D_Factura;
import sur.softsurena.entidades.Factura;
import static sur.softsurena.metodos.M_D_Factura.DETALLE_DE_LA_FACTURA_AGREGADO_CORRECTAME;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = {"init", "gFactura"},
        groups = "gDFactura"
)
public class M_D_FacturaNGTest {
    public static Integer idFactura, idProducto, idProducto2, idPrecio, 
            idPrecio2;

    @Test(
            dependsOnGroups = "gGetIDFacturaNueva"
    )
    public void testInsert() {
        
        Resultado result = M_D_Factura.insert(
                Factura
                        .builder()
                        .d_factura(
                                getListTest()
                        )
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(DETALLE_DE_LA_FACTURA_AGREGADO_CORRECTAME)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testSelect() {

        List<D_Factura> buscarTemporal
                = M_D_Factura.select(idFactura);

        assertFalse(
                buscarTemporal.isEmpty(),
                "La lista de factura Temporales no se encuentra con registros."
        );
    }
    

    @Test(
            dependsOnMethods = "testSelect"
    )
    public void testDelete() {
        
        M_D_Factura.select(idFactura).stream().forEach(
                detalle -> {
                    M_D_Factura.delete(detalle.getId());
                }
        );
        
        assertTrue(
                M_D_Factura.select(idFactura).isEmpty(),
                "Detalle de la factura %d no han sido eliminados.".formatted(
                        idFactura
                )
        );
    }
    
    @Test(
            dependsOnMethods = "testDelete"
    )
    public void testDeleteProducto() {
        M_PrecioNGTest.idPrecio = idPrecio2;
        M_PrecioNGTest.testDelete();
        
        M_PrecioNGTest.idPrecio = idPrecio;
        M_PrecioNGTest.testDelete();
        
        M_ProductoNGTest.idProducto = idProducto2;
        M_ProductoNGTest.testDeleteByID();
        
        M_ProductoNGTest.idProducto = idProducto;
        M_ProductoNGTest.testDeleteByID();
    }

    public static List<D_Factura> getListTest() {
        
        M_M_FacturaNGTest.testInsert();
        idFactura = M_M_FacturaNGTest.idFactura;
        
        
        M_PrecioNGTest.testInsert();
        idPrecio = M_PrecioNGTest.idPrecio;
        idProducto = M_PrecioNGTest.idProducto;
        
        M_PrecioNGTest.testInsert();
        idProducto2 = M_PrecioNGTest.idProducto;
        idPrecio2 = M_PrecioNGTest.idPrecio;
        
        
        return List.of(
                D_Factura
                        .builder()
                        .linea(0)
                        .idFactura(idFactura)
                        .idProducto(idProducto)
                        .idPrecio(idPrecio)
                        .cantidad(BigDecimal.TEN)
                        .build(),
                D_Factura
                        .builder()
                        .linea(1)
                        .idFactura(idFactura)
                        .idProducto(idProducto2)
                        .idPrecio(idPrecio2)
                        .cantidad(BigDecimal.TWO)
                        .build()
        );
    }
}
