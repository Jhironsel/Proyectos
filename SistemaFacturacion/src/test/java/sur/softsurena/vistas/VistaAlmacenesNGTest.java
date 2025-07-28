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

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Verifica que se puede realizar una instancia de frmAlmacenes.
                          """
    )
    public void testGetInstance() {
        assertNotNull(new VistaAlmacenes(),
                "Error al obtener la instancia de frmAlmacenes"
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Test para verrificar las consultas a la base de datos
                          de los registros de almacenes registrados.
                          """
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