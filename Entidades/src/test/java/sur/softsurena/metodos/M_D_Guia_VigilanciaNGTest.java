package sur.softsurena.metodos;

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
import sur.softsurena.entidades.D_Guia_Vigilancia;
import sur.softsurena.entidades.Guia_Vigilancia_Desarrollo;
import sur.softsurena.entidades.Paciente;
import static sur.softsurena.metodos.M_D_Guia_Vigilancia.GUIA_DE__DESARROLLO_AGREGADA_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_D_Guia_VigilanciaNGTest {

    private Integer idRegistro;

    public M_D_Guia_VigilanciaNGTest() {

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
                          """
    )
    public void testInsert() {
        Resultado result = M_D_Guia_Vigilancia.insert(
                D_Guia_Vigilancia
                        .builder()
                        .paciente(
                                Paciente
                                        .builder()
                                        .persona(
                                                Persona
                                                        .builder()
                                                        .id_persona(0)
                                                        .build()
                                        )
                                        .build()
                        )
                        .gvd(
                                Guia_Vigilancia_Desarrollo
                                        .builder()
                                        .id(1)
                                        .build()
                        )
                        .build()
        );
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(GUIA_DE__DESARROLLO_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        idRegistro = result.getId();
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          """
    )
    public void testUpdate() {
        int idGVD = 0;
        int idPaciente = 0;
        Resultado agregarGuiaVigilancia = M_D_Guia_Vigilancia.update(
                D_Guia_Vigilancia
                        .builder()
                        .id(idRegistro)
                        .paciente(
                                Paciente
                                        .builder()
                                        .persona(
                                                Persona
                                                        .builder()
                                                        .id_persona(idPaciente)
                                                        .build()
                                        )
                                        .build()
                        )
                        .gvd(
                                Guia_Vigilancia_Desarrollo
                                        .builder()
                                        .id(idGVD)
                                        .build()
                        )
                        .build()
        );
        assertEquals(
                agregarGuiaVigilancia,
                Resultado
                        .builder()
                        .mensaje(
                                M_D_Guia_Vigilancia.GUIA_DE__DESARROLLO_ACTUALIZADA_CORRECTAMENTE
                        )
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }
    
    @Test(
            enabled = true,
            priority = 2,
            description = """
                          """
    )
    public void testDelete() {
        Resultado agregarGuiaVigilancia = M_D_Guia_Vigilancia.delete(
                D_Guia_Vigilancia
                        .builder()
                        .id(idRegistro)
                        .build()
        );
        assertEquals(
                agregarGuiaVigilancia,
                Resultado
                        .builder()
                        .mensaje(
                                M_D_Guia_Vigilancia.GUIA_DE_DESARROLLO_ELIMINADA_CORRECTAMENTE
                        )
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }
}
