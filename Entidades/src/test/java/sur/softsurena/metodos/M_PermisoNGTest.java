package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_PermisoNGTest {

    @Test(
            enabled = false
    )
    public void testGetPermisosAsignados() {
        String rol = "";
        List expResult = null;
        List result = M_Permiso.getPermisosAsignados(rol);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testGetPermisosDisponibles() {
        String rol = "";
        List expResult = null;
        List result = M_Permiso.getPermisosDisponibles(rol);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testQuitarPermisoAdminRole() {
        String rol = "";
        String usuario = "";
        Resultado expResult = null;
        Resultado result = M_Permiso.quitarPermisoAdminRole(rol, usuario);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testQuitarPermisoAdminProcedimiento() {
        String procedimiento = "";
        String rol = "";
        Resultado expResult = null;
        Resultado result = M_Permiso.quitarPermisoAdminProcedimiento(procedimiento, rol);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testAgregarPermisoAdminProcedimiento() {
        String procedimiento = "";
        String rol = "";
        Resultado expResult = null;
        Resultado result = M_Permiso.agregarPermisoAdminProcedimiento(procedimiento, rol);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testAgregarPermisoAdminRole() {
        String role = "";
        String usuario = "";
        Resultado expResult = null;
        Resultado result = M_Permiso.agregarPermisoAdminRole(role, usuario);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false
    )
    public void testBorrarPermisoAdminProcedimiento() {
        String procedimiento = "";
        String rol = "";
        Resultado expResult = null;
        Resultado result = M_Permiso.borrarPermisoAdminProcedimiento(procedimiento, rol);
        assertEquals(result, expResult);
    }
}