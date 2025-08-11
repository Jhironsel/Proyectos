package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Antecedente;
import static sur.softsurena.metodos.M_Antecedente.ANTECEDENTE_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Antecedente.ANTECEDENTE_MODIFICADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Antecedente.BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Antecedente.ERROR_AL_BORRAR_PACIENTE;
import static sur.softsurena.metodos.M_Antecedente.ERROR_AL_MODIFICAR_ANTECEDENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Test(
        dependsOnGroups = "init"
)
public class M_AntecedenteNGTest {

    private static Integer idAntecedente, idConsulta;

    @Test
    public void testSqlSelect() {

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_CONSULTA, DESCRIPCION
                FROM V_ANTECEDENTES
                """.strip()
        );

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CONSULTA, DESCRIPCION
                FROM V_ANTECEDENTES
                WHERE ID = -1
                """.strip()
        );

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .idConsulta(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CONSULTA, DESCRIPCION
                FROM V_ANTECEDENTES
                WHERE ID_CONSULTA = -1
                """.strip()
        );

        assertEquals(
                M_Antecedente.sqlSelect(
                        Antecedente
                                .builder()
                                .id(-1)
                                .idConsulta(-1)
                                .build()
                ),
                """
                SELECT ID, ID_CONSULTA, DESCRIPCION
                FROM V_ANTECEDENTES
                WHERE ID = -1 AND ID_CONSULTA = -1
                """.strip()
        );
    }

    //--------------------------------------------------------------------------
    @Test
    public void testInsert() {
        M_ConsultaNGTest.testInsert();
        idConsulta = M_ConsultaNGTest.idConsulta;
        
        Resultado result = M_Antecedente.insert(
                Antecedente
                        .builder()
                        .idConsulta(idConsulta)
                        .descripcion("Prueba de antecendetes")
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ANTECEDENTE_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                "No puede ser agregado el registro."
        );

        assertTrue(
                result.getId() > 0,
                result.getMensaje()
        );

        idAntecedente = result.getId();
    }
    
    @Test(
            dependsOnMethods = {"testSqlSelect", "testInsert"}
    )
    public void testSelect() {
        int idPadre = -1;
        List<Antecedente> result = M_Antecedente.select(
                Antecedente
                        .builder()
                        .id(idPadre)
                        .build()
        );

        assertTrue(
                result.isEmpty(),
                "La tabla de antecedentes contiene informacion."
        );

        //Consultado el registro
        List<Antecedente> lista = M_Antecedente.select(
                Antecedente
                        .builder()
                        .id(idAntecedente)
                        .build()
        );

        assertNotNull(
                lista,
                "La tabla de antecedentes NO contiene informacion."
        );
    }

    //--------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Antecedente.update(
                        Antecedente
                                .builder()
                                .id(idAntecedente)
                                .descripcion("Actualizado")
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(ANTECEDENTE_MODIFICADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_MODIFICAR_ANTECEDENTE
        );
    }
//------------------------------------------------------------------------------

    @Test(
            dependsOnMethods = {"testInsert", "testUpdate"}
    )
    public void testDelete() {
        assertEquals(
                M_Antecedente.delete(
                        Antecedente
                                .builder()
                                .id(idAntecedente)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_PACIENTE
        );
    }
    
    @Test(
            dependsOnMethods = "testDelete"
    )
    public void testDelete2() {
        M_ConsultaNGTest.idConsulta = idConsulta;
        M_ConsultaNGTest.testDelete();
    }
    
    public static Antecedente getAntecedente(){
        return Antecedente
                .builder()
                .id(idAntecedente)
                .idConsulta(idConsulta)
                .build();
    }
}
