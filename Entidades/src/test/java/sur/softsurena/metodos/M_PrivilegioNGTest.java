package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Privilegio;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = {"init"}
)
public class M_PrivilegioNGTest {

    private final String USER_NAME = "jhironsel";

    @Test
    public void testPrivilegio() {        
        boolean result = M_Privilegio.privilegio(
                Privilegio
                                .builder()
                                .privilegio(
                                        Privilegio.PRIVILEGIO_SELECT
                                )
                                .nombre_relacion("V_PRODUCTOS")
                                .build()
        );
        
        assertTrue(result, "No se tiene acceso a V_PRODUCTOS");
        
        
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_TURNOS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_TURNOS");
        
        
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_PERSONAS_CLIENTES")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_PERSONAS_CLIENTES");
        
        
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_CATEGORIAS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_CATEGORIAS");
        
        
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_M_FACTURAS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_M_FACTURAS");
        
        
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_PRECIOS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_PRECIOS");
        
        
        //----------------------------------------------------------------------
        result = M_Privilegio.privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_TURNOS")
                        .build()
        );
        assertTrue(result, "No se tiene acceso a V_TURNOS");
        //----------------------------------------------------------------------
    }

}
