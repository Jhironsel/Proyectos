package sur.softsurena.vistas;

import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Almacen;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init2"
)
public class VistaAlmacenesNGTest {

    @Test
    public void testGetInstance() {
        assertNotNull(
                new VistaAlmacenes(),
                "Error al obtener la instancia de frmAlmacenes"
        );
    }

    @Test(
            dependsOnMethods = "testGetInstance"
    )
    public void testLlenarTabla() {
        JTable tabla = VistaAlmacenes.llenarTabla(
                Almacen
                        .builder()
                        .build()
        );
        
        assertNotNull(
                tabla,
                "La tabla de almacenes no contiene datos."
        );
    }

}