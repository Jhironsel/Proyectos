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
@Test(
        enabled = true,
        dependsOnGroups = "init",
        groups = "init.usuario"
)
public class M_UsuarioNGTest {

    public M_UsuarioNGTest() {}

    @BeforeClass
    public void setUpClass() throws Exception {}

    @AfterClass
    public void tearDownClass() throws Exception {}

    @BeforeMethod
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    @Test(
            enabled = true,
            description = """
                          Metodo que verifica que las propiedades de nombres y 
                          rol de usuario que hace el test.
                          """,
            priority = 0
    )
    public void testGetUsuarioActual() {
        Usuario result = M_Usuario.getUsuarioActual();

        assertEquals(
                result.getPersona().getUser_name(),
                "SYSDBA"
        );

        assertEquals(
                result.getPersona().getRol(),
                "ADMINISTRADOR"
        );
    }
    
    //--------------------------------------------------------------------------
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
                          """,
            alwaysRun = true
    )
    public void testSqlSelect() {
        assertEquals(
                M_Usuario.sqlSelect(
                        Usuario
                                .builder()
                                .persona(Persona.builder().build())
                                .build()
                ),
                """
                SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO,
                      ADMINISTRADOR, DESCRIPCION
                FROM VS_USUARIOS
                """.strip()
        );

        assertEquals(
                M_Usuario.sqlSelect(
                        Usuario
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .estado(Boolean.TRUE)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO,
                      ADMINISTRADOR, DESCRIPCION
                FROM VS_USUARIOS
                WHERE ESTADO IS TRUE
                """.strip()
        );

        assertEquals(
                M_Usuario.sqlSelect(
                        Usuario
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .estado(Boolean.FALSE)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO,
                      ADMINISTRADOR, DESCRIPCION
                FROM VS_USUARIOS
                WHERE ESTADO IS FALSE
                """.strip()
        );

        assertEquals(
                M_Usuario.sqlSelect(
                        Usuario
                                .builder()
                                .persona(Persona.builder().build())
                                .administrador(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO,
                      ADMINISTRADOR, DESCRIPCION
                FROM VS_USUARIOS
                WHERE ADMINISTRADOR IS TRUE
                """.strip()
        );

        assertEquals(
                M_Usuario.sqlSelect(
                        Usuario
                                .builder()
                                .persona(Persona.builder().build())
                                .administrador(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO,
                      ADMINISTRADOR, DESCRIPCION
                FROM VS_USUARIOS
                WHERE ADMINISTRADOR IS FALSE
                """.strip()
        );

        assertEquals(
                M_Usuario.sqlSelect(
                        Usuario
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .user_name("SYSDBA")
                                                .pnombre("SYSDBA")
                                                .snombre("SYSDBA")
                                                .apellidos("SYSDBA")
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT USERNAME, PNOMBRE, SNOMBRE, APELLIDOS, ESTADO,
                      ADMINISTRADOR, DESCRIPCION
                FROM VS_USUARIOS
                WHERE USERNAME STARTING WITH 'SYSDBA' OR PNOMBRE STARTING WITH 'SYSDBA' OR SNOMBRE STARTING WITH 'SYSDBA' OR APELLIDOS STARTING WITH 'SYSDBA'
                """.strip()
        );
    }

    @Test(
            enabled = true,
            description = """
                          """,
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Usuario.select(
                        Usuario
                                .builder()
                                .persona(Persona.builder().build())
                                .build()
                ),
                "Error al consultar la lista de usuario"
        );

        assertNotNull(
                M_Usuario.select(
                        Usuario
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .estado(Boolean.TRUE)
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de usuario"
        );

        assertNotNull(
                M_Usuario.select(
                        Usuario
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .estado(Boolean.FALSE)
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de usuario"
        );

        assertNotNull(
                M_Usuario.select(
                        Usuario
                                .builder()
                                .persona(Persona.builder().build())
                                .administrador(Boolean.TRUE)
                                .build()
                ),
                "Error al consultar la lista de usuario"
        );

        assertNotNull(
                M_Usuario.select(
                        Usuario
                                .builder()
                                .persona(Persona.builder().build())
                                .administrador(Boolean.FALSE)
                                .build()
                ),
                "Error al consultar la lista de usuario"
        );

        assertNotNull(
                M_Usuario.select(
                        Usuario
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .user_name("SYSDBA")
                                                .pnombre("SYSDBA")
                                                .snombre("SYSDBA")
                                                .apellidos("SYSDBA")
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de usuario"
        );
    }

//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            description = """
                          Metodo encargado de registrar a un usuario al sistema.
                          """,
            priority = 2,
            groups = "usuario.insert"
    )
    public void testInsert() {
        var listaUsuario = M_Usuario.select(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name("CAJERO")
                                        .pnombre("CAJERO")
                                        .snombre("CAJERO")
                                        .apellidos("CAJERO")
                                        .build()
                        )
                        .build()
        );

        Resultado result;
        List<Role> roles = new ArrayList();
        if (listaUsuario.isEmpty()) {

            roles.clear();
            roles.add(
                    Role
                            .builder()
                            .roleName("R_CAJERO")
                            .conAdmin(false)
                            .build()
            );

            result = M_Usuario.insert(
                    Usuario
                            .builder()
                            .persona(
                                    Persona
                                            .builder()
                                            .user_name("CAJERO")
                                            .pnombre("")
                                            .snombre("")
                                            .apellidos("")
                                            .estado(Boolean.TRUE)
                                            .build()
                            )
                            .clave("1")
                            .administrador(Boolean.FALSE)
                            .descripcion("Usuario por defecto que administra las cajas del sistema.")
                            .tags("AUTO_ROLE='R_CAJERO'")
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
        //----------------------------------------------------------------------

        listaUsuario = M_Usuario.select(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name("ADMINISTRADOR")
                                        .pnombre("ADMINISTRADOR")
                                        .snombre("ADMINISTRADOR")
                                        .apellidos("ADMINISTRADOR")
                                        .build()
                        )
                        .build()
        );

        if (listaUsuario.isEmpty()) {

            roles.clear();
            roles.add(
                    Role
                            .builder()
                            .roleName("RDB$ADMIN")
                            .conAdmin(false)
                            .build()
            );

            result = M_Usuario.insert(
                    Usuario
                            .builder()
                            .persona(
                                    Persona
                                            .builder()
                                            .user_name("ADMINISTRADOR")
                                            .pnombre("")
                                            .snombre("")
                                            .apellidos("")
                                            .estado(Boolean.TRUE)
                                            .build()
                            )
                            .clave("1")
                            .administrador(Boolean.TRUE)
                            .descripcion("")
                            .tags("AUTO_ROLE='RDB$ADMIN'")
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

        roles.clear();
        roles.add(
                Role
                        .builder()
                        .roleName("R_CAJERO")
                        .conAdmin(false)
                        .build()
        );

        result = M_Usuario.insert(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name("PRUEBA")
                                        .pnombre("PRUEBA")
                                        .snombre("PRUEBA")
                                        .apellidos("PRUEBA")
                                        .estado(Boolean.TRUE)
                                        .build()
                        )
                        .clave("1")
                        .administrador(Boolean.TRUE)
                        .descripcion("")
                        .tags("")
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
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        List<Role> roles = new ArrayList();
        roles.add(
                Role
                        .builder()
                        .roleName("R_CAJERO")
                        .conAdmin(false)
                        .build()
        );

        Resultado result = M_Usuario.update(
                Usuario
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .user_name("PRUEBA")
                                        .pnombre("")
                                        .snombre("")
                                        .apellidos("")
                                        .estado(Boolean.TRUE)
                                        .build()
                        )
                        .clave("1")
                        .administrador(Boolean.FALSE)
                        .descripcion("Es un usuario de prueba para el sistema.")
                        .tags("")
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
                          Metodo que permite eliminar un usuario del sistema.
                          """,
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public void testDelete() {
        Resultado result = M_Usuario.delete("PRUEBA");
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
    }
}
