package sur.softsurena.metodos;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Empleado;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init"
)
public class M_EmpleadoNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSelect() {
        assertNotNull(
                M_Empleado.select(
                        Empleado
                                .builder()
                                .build()
                ), 
                "Error al consultar la lista de empleados."
        );
    }
    
}
