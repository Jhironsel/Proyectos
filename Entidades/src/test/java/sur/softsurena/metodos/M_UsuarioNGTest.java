package sur.softsurena.metodos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
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

    @Test
    public void testGetUsuarioActual() {
        Usuario result = M_Usuario.getUsuarioActual();

        assertEquals(
                result.getUserName(),
                "SYSDBA"
        );

        assertEquals(
                result.getPersona().getRol(),
                "ADMINISTRADOR"
        );
    }

    @Test
    public void testCambioClave() {
        String usuario = "sysdba";
        String clave = "1";
        boolean result = M_Usuario.cambioClave(usuario, clave);
        assertTrue(
                result,
                "La contraseña no fue cambiada. "
        );
    }

    @Test
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
                                .userName("SYSDBA")
                                .persona(
                                        Persona
                                                .builder()
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
                                .userName("SYSDBA")
                                .persona(
                                        Persona
                                                .builder()
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

    @Test(
            groups = "usuario.insert"
    )
    public void testInsert() {
        var listaUsuario = M_Usuario.select(
                Usuario
                        .builder()
                        .userName("CAJERO")
                        .persona(
                                Persona
                                        .builder()
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
                            .userName("CAJERO")
                            .persona(
                                    Persona
                                            .builder()
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
                        .userName("ADMINISTRADOR")
                        .persona(
                                Persona
                                        .builder()
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
                            .userName("ADMINISTRADOR")
                            .persona(
                                    Persona
                                            .builder()
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
                        .userName("PRUEBA")
                        .persona(
                                Persona
                                        .builder()
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

    @Test(
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
                        .userName("PRUEBA")
                        .persona(
                                Persona
                                        .builder()
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

    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"},
            groups = "usuario.delete"
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
