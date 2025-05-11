package sur.softsurena.metodos;

import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
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
    
    public M_EtiquetaNGTest() {
        System.out.println("sur.softsurena.metodos.M_EtiquetaNGTest.<init>()");
    }
    
    @BeforeClass
    public void setUpClass() throws Exception {
//        Conexion.getInstance(
//                "sysdba",
//                "1",
//                "SoftSurena.db",
//                "localhost",
//                "3050",
//                "NONE"
//        );
//        assertTrue(
//                Conexion.verificar().getEstado(),
//                "Error al conectarse..."
//        );
    }
    
    @AfterClass
    public void tearDownClass() throws Exception {
//        Conexion.getCnn().close();
    }
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
    
    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void testGetEtiquetasUsuario() {
        boolean empty = M_Etiqueta.getEtiquetasUsuario("SYSDBA").isEmpty();
        
        if (empty) {
            var usuario = M_Usuario.select(
                    Usuario
                            .builder()
                            .persona(
                                    Persona
                                            .builder()
                                            .user_name("SYSDBA")
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
                                            .user_name(usuario.getPersona().getUser_name())
                                            .build()
                            )
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
