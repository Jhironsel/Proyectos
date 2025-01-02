package sur.softsurena.metodos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Role;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.metodos.M_Usuario.ERROR_AL_AGREGAR__USUARIO;
import static sur.softsurena.metodos.M_Usuario.ERROR_AL_BORRAR_USUARIO;
import static sur.softsurena.metodos.M_Usuario.ERROR_AL_MODIFICAR_USUARIO;
import static sur.softsurena.metodos.M_Usuario.USUARIO_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Usuario.USUARIO_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Usuario.USUARIO_MODIFICADO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

@Getter
public class M_UsuarioNGTest {

    public M_UsuarioNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }
//------------------------------------------------------------------------------

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = "",
            priority = 0
    )
    public void testCambioClave() {
        String usuario = "sysdba";
        String clave = "1";
        boolean result = M_Usuario.cambioClave(usuario, clave);
        assertTrue(
                result,
                "La contraseña no fue cambiada. "
        );
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = true,
            description = """
                          Metodo encargado de registrar a un usuario al sistema.
                          """,
            priority = 1
    )
    public void testInsert() {
        List<Role> roles = new ArrayList();
        roles.add(
                Role
                        .builder()
                        .roleName("CAJERO")
                        .conAdmin(false)
                        .build()
        );
        roles.add(
                Role
                        .builder()
                        .roleName("SECRETARIA")
                        .conAdmin(false)
                        .build()
        );

//------------------------------------------------------------------------------
        Resultado result = M_Usuario.insert(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name("Prueba")
                                        .pnombre("PNombre")
                                        //.snombre("")
                                        .apellidos("Apellidos")
                                        .estado(Boolean.TRUE)
                                        .build()
                        )
                        .clave("1")
                        .administrador(Boolean.FALSE)
                        .descripcion("Es un usuario de prueba.")
                        .tags("PRUEBA='Una prueba del sistema', Otra='4352.4', ultima='234'")
                        .roles(roles)
                        .build()
        );
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(USUARIO_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_AGREGAR__USUARIO
        );

//------------------------------------------------------------------------------
        result = M_Usuario.insert(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name("Jhironsel2")
                                        .pnombre("Jhironsel")
                                        .snombre(null)
                                        .apellidos("Diaz Almonte")
                                        .estado(Boolean.TRUE)
                                        .build()
                        )
                        .clave("1")
                        .administrador(Boolean.FALSE)
                        .descripcion("Es un usuario de prueba para el sistema.")
                        .tags("PRUEBA='Una prueba del sistema', Otra='4352.4', ultima='234'")
                        .roles(roles)
                        .build()
        );
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(USUARIO_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_AGREGAR__USUARIO
        );
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = true,
            description = """
                          Prueba que se encarga de modificar los usuarios del 
                          sistema.
                          """,
            priority = 2
    )
    public void testUpdate() {
        List<Role> roles = new ArrayList();
        roles.add(
                Role
                        .builder()
                        .roleName("CAJERO")
                        .conAdmin(false)
                        .build()
        );
        roles.add(
                Role
                        .builder()
                        .roleName("SECRETARIA")
                        .conAdmin(false)
                        .build()
        );

        Resultado result = M_Usuario.update(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name("JHIRONSEL2")
                                        .pnombre("Jhironsel")
                                        .snombre("Jhadiel")
                                        .apellidos("Diaz Almonte")
                                        .estado(Boolean.TRUE)
                                        .build()
                        )
                        .clave("1")
                        .administrador(Boolean.TRUE)
                        .descripcion("Es un usuario de prueba para el sistema.")
                        .tags("DROP PRUEBA, Otra='432.4', ultima='100'")
                        .roles(roles)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(USUARIO_MODIFICADO_CORRECTAMENTE)
                        .estado(Boolean.TRUE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .build(),
                ERROR_AL_MODIFICAR_USUARIO
        );
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = true,
            description = """
                          Metodo que verifica que las propiedades de nombres y 
                          rol de usuario que hace el test.
                          """,
            priority = 0
    )
    public void testGetUsuarioActual() {
        Usuario expResult = Usuario
                .builder()
                .persona(
                        Persona
                                .builder()
                                .user_name("SYSDBA")
                                .rol("ADMINISTRADOR")
                                .build()
                )
                .build();
        Usuario result = M_Usuario.getUsuarioActual();

        assertEquals(
                result.getPersona().getUser_name(), 
                expResult.getPersona().getUser_name()
        );

        assertEquals(
                result.getPersona().getRol(), 
                expResult.getPersona().getRol()
        );
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testGetUsuario() {
        String userName = "";
        Usuario expResult = null;
        Usuario result = M_Usuario.getUsuario(userName);
        assertEquals(result, expResult);
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testGetUsuarios() {
        List expResult = null;
        List result = M_Usuario.getUsuarios();
        assertEquals(result, expResult);
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testGetNombresUsuarios() {
        List expResult = null;
        List result = M_Usuario.getNombresUsuarios();
        assertEquals(result, expResult);
    }
//------------------------------------------------------------------------------

    @Test(
            enabled = true,
            description = """
                          Metodo que permite eliminar un usuario del sistema.
                          """,
            priority = 3
    )
    public void testDelete() {
        Resultado result = M_Usuario.delete("Prueba");
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(USUARIO_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_USUARIO + " Prueba."
        );
        result = M_Usuario.delete("Jhironsel2");
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(USUARIO_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_USUARIO + " Jhironsel2."
        );
    }
}
