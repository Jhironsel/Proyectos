package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.Usuario;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_EtiquetaNGTest {

    @Test
    public void testGetEtiquetasUsuario() {
        boolean empty = M_Etiqueta.getEtiquetasUsuario("SYSDBA").isEmpty();

        if (empty) {
            var usuario = M_Usuario.select(
                    Usuario
                            .builder()
                            .userName("SYSDBA")
                            .persona(
                                    Persona
                                            .builder()
                                            .build())
                            .build()
            ).getLast();

            M_Usuario.update(
                    Usuario
                            .builder()
                            .persona(
                                    Persona
                                            .builder()
                                            .pnombre(usuario.getPersona().getPnombre())
                                            .snombre(usuario.getPersona().getSnombre())
                                            .apellidos(usuario.getPersona().getApellidos())
                                            .estado(usuario.getPersona().getEstado())
                                            .build()
                            )
                            .userName(usuario.getUserName())
                            .administrador(usuario.getAdministrador())
                            .descripcion(usuario.getDescripcion())
                            .tags("AUTO_ROLE='RDB$ADMIN'")
                            .build()
            );
        }

        assertFalse(
                M_Etiqueta.getEtiquetasUsuario("SYSDBA").isEmpty(),
                "La lista de etiquetas no esta vacia."
        );
    }

}
