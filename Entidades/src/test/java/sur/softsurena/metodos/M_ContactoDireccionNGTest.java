package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.ContactoDireccion;
import static sur.softsurena.metodos.M_ContactoDireccion.DIRECCION_AGREGADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ContactoDireccion.DIRECCION_DE_CONTACTO_ACTUALIZADA_CORRECT;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_ACTUALIZAR_LA_DIRECCION_DEL_CONT;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_INSERTAR_DIRECCION;
import static sur.softsurena.metodos.M_ContactoDireccion.REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA;
import static sur.softsurena.metodos.M_ContactoDireccion.agregarDireccion;
import static sur.softsurena.metodos.M_ContactoDireccion.getDireccionByID;
import sur.softsurena.utilidades.Resultado;

@Getter
public class M_ContactoDireccionNGTest {

    private int id_direccion;
    private final M_PersonaNGTest persona;

    public M_ContactoDireccionNGTest() {
        persona = new M_PersonaNGTest();
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

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          Metodo que permite agregar un direcion de una persona.
                          """
    )
    public void testAgregarDireccion() {

        persona.testInsert();

        Resultado result = agregarDireccion(ContactoDireccion
                .builder()
                .idPersona(
                        M_PersonaNGTest
                                .persona(Boolean.FALSE)
                                .getIdPersona()
                )
                .idProvincia(0)
                .idMunicipio(0)
                .idDistritoMunicipal(0)
                
                .direccion("Insercion de prueba.")
                .porDefecto(Boolean.TRUE)
                .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(DIRECCION_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_DIRECCION
        );

        assertTrue(
                result.getId() > 0,
                ERROR_AL_INSERTAR_DIRECCION
        );

        id_direccion = result.getId();

    }//FIN

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          Permite consulta las direcciones de una personas del 
                          sistema.
                          """
    )
    public void testGetDireccionByID() {
        int id_persona = 0;
        List result = getDireccionByID(id_persona);
        assertFalse(
                result.isEmpty(),
                "La lista contiene datos"
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = ""
    )
    public void testModificarDireccion() {

        Resultado result = M_ContactoDireccion.modificarDireccion(ContactoDireccion
                .builder()
                .id(id_direccion)
                .idPersona(
                        M_PersonaNGTest
                                .persona(Boolean.FALSE)
                                .getIdPersona()
                )
                .idProvincia(2)
                .idMunicipio(12)
                .idDistritoMunicipal(23)
                .idCodigoPostal(0)
                .direccion("Insercion de prueba 2.")
                .porDefecto(Boolean.TRUE)
                .estado(Boolean.FALSE)
                .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(DIRECCION_DE_CONTACTO_ACTUALIZADA_CORRECT)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ACTUALIZAR_LA_DIRECCION_DEL_CONT
        );
    }

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          Test que realiza la eliminacion de un registros de 
                          direccion de un contacto del sistema.
                          """
    )
    public void testBorrarDireccion() {

        Resultado result = M_ContactoDireccion.borrarDireccion(id_direccion);

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI
        );

        persona.testDelete();
    }
}
