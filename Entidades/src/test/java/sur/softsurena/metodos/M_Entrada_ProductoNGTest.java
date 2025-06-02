package sur.softsurena.metodos;

import java.sql.ResultSet;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.EntradaProducto;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_Entrada_ProductoNGTest {

    @Test(
            enabled = false
    )
    public void testAgregarProductoEntrada() {
        EntradaProducto e = null;
        boolean expResult = false;
        Resultado result = M_Entrada_Producto.agregarProductoEntrada(e);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testAgregarProductoSalida() {
        int IDENTRADA_PRODUCTO = 0;
        int numero = 0;
        String cencepto = "";
        String idProducto = "";
        double entrada = 0.0;
        String idUsuario = "";
        M_Entrada_Producto instance = new M_Entrada_Producto();
        boolean expResult = false;
        boolean result = instance.agregarProductoSalida(IDENTRADA_PRODUCTO, numero, cencepto, idProducto, entrada, idUsuario);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testGetEntradaProducto() {
        int mes = 0;
        int year = 0;
        ResultSet expResult = null;
        ResultSet result = M_Entrada_Producto.getEntradaProducto(mes, year);
        assertEquals(result, expResult);
    }
}