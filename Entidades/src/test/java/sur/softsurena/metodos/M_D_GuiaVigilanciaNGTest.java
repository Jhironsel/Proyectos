package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.D_GuiaVigilancia;
import static sur.softsurena.metodos.M_D_GuiaVigilancia.GUIA_DE__DESARROLLO_AGREGADA_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_D_GuiaVigilanciaNGTest {

    private Integer idRegistro;

    public M_D_GuiaVigilanciaNGTest() {

    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "None"
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
        Resultado result = M_D_GuiaVigilancia.insert(D_GuiaVigilancia
                .builder()
                .idPaciente(0)
                .idGuiaVigilanciaDesarrollo(1)
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
        Resultado agregarGuiaVigilancia = M_D_GuiaVigilancia.update(D_GuiaVigilancia
                .builder()
                .id(idRegistro)
                .idPaciente(idPaciente)
                .idGuiaVigilanciaDesarrollo(idGVD)
                .build()
        );
        assertEquals(
                agregarGuiaVigilancia,
                Resultado
                        .builder()
                        .mensaje(
                                M_D_GuiaVigilancia.GUIA_DE__DESARROLLO_ACTUALIZADA_CORRECTAMENTE
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
        Resultado agregarGuiaVigilancia = M_D_GuiaVigilancia.delete(D_GuiaVigilancia
                .builder()
                .id(idRegistro)
                .build()
        );
        assertEquals(
                agregarGuiaVigilancia,
                Resultado
                        .builder()
                        .mensaje(
                                M_D_GuiaVigilancia.GUIA_DE_DESARROLLO_ELIMINADA_CORRECTAMENTE
                        )
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }
}
