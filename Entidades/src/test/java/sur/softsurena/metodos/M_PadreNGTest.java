package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Padre;
import sur.softsurena.entidades.Paginas;
import static sur.softsurena.metodos.M_Padre.BORRADO_DE_REGISTRO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Padre.PADRE__AGREGADO__EXITOSAMENTE;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_PadreNGTest {

    private static Integer idPersona;

    @Test(
            enabled = true,
            alwaysRun = true
    )
    public void testSqlSelect() {
        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .id(-1)
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                WHERE ID = -1
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .id(-1)
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                """
                SELECT ID
                FROM PERSONAS_PADRES
                WHERE ID = -1
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );

    }
    
    @Test(
            enabled = true, 
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .build()
                ),
                "Error al consultar la lista de padres."
        );

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .id(-1)
                                .build()
                ),
                "Error al consultar la lista de padres."
        );

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de padres."
        );

        assertNotNull(
                M_Padre.select(
                        Padre
                                .builder()
                                .id(-1)
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ),
                "Error al consultar la lista de padres."
        );
    }

    @Test(
            enabled = true
    )
    public void testInsert() {
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;
        
        assertEquals(
                M_Padre.insert(
                        Padre
                                .builder()
                                .id(idPersona)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(PADRE__AGREGADO__EXITOSAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            dependsOnMethods = "testInsert"
    )
    public void testDelete() {

        assertEquals(
                M_Padre.delete(
                        Padre.builder().id(idPersona).build()
                ),
                Resultado
                        .builder()
                        .mensaje(BORRADO_DE_REGISTRO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );

        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }
}
