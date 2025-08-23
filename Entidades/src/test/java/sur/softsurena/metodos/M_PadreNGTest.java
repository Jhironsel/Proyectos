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
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_PadreNGTest {

    public static Integer idPersona;

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
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                     FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                     ESTADO, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_PERSONAS_PADRES_GEN
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .idPersona(-1)
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                     FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                     ESTADO, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_PERSONAS_PADRES_GEN
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
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, 
                     FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, 
                     ESTADO, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_PERSONAS_PADRES_GEN
                ROWS (1 - 1) * 20 + 1 TO (1 + (1 - 1)) * 20;
                """.strip().trim()
        );

        assertEquals(
                M_Padre.sqlSelect(
                        Padre
                                .builder()
                                .idPersona(-1)
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
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                     FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE,
                     ESTADO, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL
                FROM V_PERSONAS_PADRES_GEN
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
                                .idPersona(-1)
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
                                .idPersona(-1)
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
        M_PersonaNGTest.persona = Padre
                .builder()
                .persona('J')
                .pnombre("MPadre")
                .snombre("MPadre")
                .apellidos("MPadre")
                .sexo('M')
                .fecha_nacimiento(
                        javaDateToSqlDate(
                                stringToDate("23.06.2017", "dd.MM.yyyy")
                        )
                )
                .estado(Boolean.TRUE)
                .build();

        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;

        assertEquals(
                M_Padre.insert(
                        Padre
                                .builder()
                                .idPersona(idPersona)
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
                        Padre.builder().idPersona(idPersona).build()
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
