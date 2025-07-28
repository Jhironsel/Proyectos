package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static sur.softsurena.metodos.M_Role.ERROR_AL_ASIGNAR_ROL;
import static sur.softsurena.metodos.M_Role.ERROR_AL_CONSULTAR_LOS_ROLES_DEL_SISTEMA;
import static sur.softsurena.metodos.M_Role.ROL_ASIGNADO_A_USUARIO;
import sur.softsurena.utilidades.Resultado;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_RoleNGTest {

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Permite validar que los roles del sysdba se encuentran
                          activos y disponibles.
                          """
    )
    public void testSelectDisponibles() {
        final String userName = "sysdba";
        
        assertNotNull(
                M_Role.selectDisponibles(userName, true),
                ERROR_AL_CONSULTAR_LOS_ROLES_DEL_SISTEMA
        );
        
        assertNotNull(
                M_Role.selectDisponibles(userName, false), 
                ERROR_AL_CONSULTAR_LOS_ROLES_DEL_SISTEMA
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Test que verifica que la tabla de consulta roles este
                          vacia.
                          """
    )
    public void testGetRoles() {
        assertFalse(
                M_Role.getRoles().isEmpty(),
                "Existen registros de roles en el sistema."
        );
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testSetRole() {
        String i_role = "";
        Resultado expResult = null;
        Resultado result = M_Role.setRole(i_role);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testDropRole() {
        String i_role = "";
        Resultado expResult = null;
        Resultado result = M_Role.dropRole(i_role);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testAsignarRol() {
        String procedimiento = "";
        String rol = "";
        boolean admin = false;
        boolean otorgar = false;
        Resultado expResult = null;
        Resultado result = M_Role.asignarRol(procedimiento, rol, admin, otorgar);
        assertEquals(result, expResult);
    }

    @Test
    public void testAsignarRolUsuario() {
        String rol = "RDB$ADMIN";
        String usuario = "SYSDBA";
        boolean admin = true;
        
        Resultado result = M_Role.asignarRolUsuario(rol, usuario, admin);
        
        assertEquals(
                result, 
                Resultado
                    .builder()
                    .mensaje(ROL_ASIGNADO_A_USUARIO)
                    .icono(JOptionPane.INFORMATION_MESSAGE)
                    .estado(Boolean.TRUE)
                    .build(),
                ERROR_AL_ASIGNAR_ROL
        );
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testQuitarRolUsuario() {
        String rol = "";
        String usuario = "";
        Resultado expResult = null;
        Resultado result = M_Role.quitarRolUsuario(rol, usuario);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testCreateRole() {
        String rolee = "";
        Resultado expResult = null;
        Resultado result = M_Role.createRole(rolee);
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testModificarRol() {
        String actual = "";
        String nuevo = "";
        Resultado expResult = null;
        Resultado result = M_Role.modificarRol(actual, nuevo);
        assertEquals(result, expResult);
    }

}
