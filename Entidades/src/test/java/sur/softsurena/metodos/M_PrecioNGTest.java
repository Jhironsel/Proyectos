package sur.softsurena.metodos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Precio;
import static sur.softsurena.metodos.M_Precio.PRECIO_ELIMINADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Precio.PRECIO_ESTABLECIDO_CON_EXITO;
import sur.softsurena.utilidades.Resultado;

@Test(
        dependsOnGroups = "init"
)
public class M_PrecioNGTest {

    public static Integer idPrecio, idProducto;

    @Test
    public void testSelect() {
        assertTrue(
                M_Precio.select(
                        Precio
                                .builder()
                                .build()
                ).isEmpty(),
                "Lista de precio contiene precios registrados."
        );
        assertTrue(
                M_Precio.select(
                        Precio
                                .builder()
                                .idProducto(0)
                                .build()
                ).isEmpty(),
                "Error al consultar la lista de precio por idProducto."
        );
    }

    @Test(
            dependsOnMethods = "testSelect"
    )
    public static void testInsert() {
        M_ProductoNGTest.testInsert();
        idProducto = M_ProductoNGTest.idProducto;
        
        Resultado resultado = M_Precio.insert(getPrecio());
        
        assertEquals(
                resultado,
                Resultado
                        .builder()
                        .mensaje(PRECIO_ESTABLECIDO_CON_EXITO)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        
        idPrecio = resultado.getId();
    }

    @Test(
            dependsOnMethods = {"testInsert"}
    )
    public static void testUpdate() {
        assertEquals(
                M_Precio.update(getPrecio()),
                Resultado
                        .builder()
                        .mensaje(PRECIO_ESTABLECIDO_CON_EXITO)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = {"testInsert","testUpdate"}
    )
    public static void testDelete() {
        assertEquals(
                M_Precio.delete(getPrecio()), 
                Resultado
                    .builder()
                    .mensaje(PRECIO_ELIMINADO_CORRECTAMENTE)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build()
        );
    }
    
    @Test(
            dependsOnMethods = "testDelete"
    )
    public static void testDelete2(){
        M_ProductoNGTest.idProducto = idProducto;
        M_ProductoNGTest.testDeleteByID();
    }

    public static Precio getPrecio() {
        
        
        var tiempo = GregorianCalendar.getInstance();
        tiempo.add(Calendar.DAY_OF_MONTH, 15);
        tiempo.add(Calendar.MONTH, 4);
        tiempo.add(Calendar.YEAR, 2025);

        var fechaInicio = new Date(0);

        return Precio
                .builder()
                .id(idPrecio)
                .idProducto(idProducto)
                .idTipoPrecio(0)
                .idTipoImpusto(1)
                .precio(BigDecimal.TEN)
                .moneda("DOP")
                .fechaInicio(fechaInicio)
                .fechaFin(null)
                .descuento(BigDecimal.ZERO)
                .costoEnvio(BigDecimal.ZERO)
                .estado(Boolean.TRUE)
                .build();
    }

}
