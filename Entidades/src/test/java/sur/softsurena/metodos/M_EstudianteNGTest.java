package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Estudiante;
import static sur.softsurena.metodos.M_Estudiante.ESTUDIANTE__AGREGADO__CORRECTAMENTE;
import static sur.softsurena.metodos.M_Estudiante.ESTUDIANTE__MODIFICADO__CORRECTAMENTE;
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
public class M_EstudianteNGTest {

    public static Integer idPersona;

    @Test
    public void testSqlSelect() {
        assertEquals(
                M_Estudiante.sqlSelect(
                        Estudiante
                                .builder()
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                     FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE,
                     ESTADO, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL, MATRICULA
                FROM V_PERSONAS_ESTUDIANTES_GEN
                """.strip()
        );
        assertEquals(
                M_Estudiante.sqlSelect(
                        Estudiante
                                .builder()
                                .matricula("00")
                                .build()
                ),
                """
                SELECT ID, PERSONA, PNOMBRE, SNOMBRE, APELLIDOS, SEXO,
                     FECHA_NACIMIENTO, FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE,
                     ESTADO, ID_TIPO_SANGRE, CEDULA, ESTADO_CIVIL, MATRICULA
                FROM V_PERSONAS_ESTUDIANTES_GEN
                WHERE MATRICULA STARTING WITH '00'
                """.strip()
        );
    }

    @Test(
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Estudiante.select(
                        Estudiante
                                .builder()
                                .build()
                ),
                "Error en la consulta de la tabla de V_PERSONAS_ESTUDIANTES_ATR."
        );
        assertNotNull(
                M_Estudiante.select(
                        Estudiante
                                .builder()
                                .matricula("000")
                                .build()
                ),
                "Error en la consulta de la tabla de V_PERSONAS_ESTUDIANTES_ATR."
        );
    }

//------------------------------------------------------------------------------
    @Test(
            dependsOnMethods = "testSelect"
    )
    public void testInsert() {
        M_PersonaNGTest.persona = Estudiante
                .builder()
                .persona('J')
                .pnombre("MEstudiante")
                .snombre("MEstudiante")
                .apellidos("MEstudiante")
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

        assertEquals(M_Estudiante.insert(Estudiante
                .builder()
                .idPersona(idPersona)
                .matricula(
                        M_ContactoTel
                                .generarTelMovil()
                                .substring(8, 16))
                .build()
        ),
                Resultado
                        .builder()
                        .mensaje(ESTUDIANTE__AGREGADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        assertEquals(
                M_Estudiante.update(
                        Estudiante
                                .builder()
                                .idPersona(idPersona)
                                .matricula(M_Generales.generarCedula().substring(0, 8))
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(ESTUDIANTE__MODIFICADO__CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            dependsOnMethods = {
                "testInsert",
                "testUpdate"
            }
    )
    public void testDelete() {
        assertEquals(
                M_Estudiante.delete(
                        Estudiante
                                .builder()
                                .idPersona(idPersona)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje("Estudiante borrado correctamente.!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }
}
