package sur.softsurena.metodos;

import java.math.BigDecimal;
import java.util.List;
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
import sur.softsurena.entidades.Paciente;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_BORRAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_CONSULTAR_EL_SEXO_DE_UN_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_CONSULTAR_LA_CEDULA_DEL_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_INSERTAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.ERROR_AL_MODIFICAR_PACIENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_BORRADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Paciente.PACIENTE_MODIFICADO_CORRECTAMENTE;
import sur.softsurena.utilidades.Resultado;

@Getter
public class M_PacienteNGTest {

    private final M_PersonaNGTest persona;

    public M_PacienteNGTest() {
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
                          Test que realiza el ingreso de un paciente al sistema.
                          """
    )
    public void testInsert() {
        persona.testInsert();

        Resultado result = M_Paciente.insert(generarPaciente());

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PACIENTE_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_PACIENTE
        );

        assertTrue(
                M_PersonaNGTest.persona(Boolean.FALSE).getId_persona() > 0,
                ERROR_AL_INSERTAR_PACIENTE
        );
    }

    @Test(
            enabled = true,
            description = "",
            priority = 1
    )
    public void testUpdate() {
        Resultado result = M_Paciente.update(generarPaciente());

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PACIENTE_MODIFICADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_MODIFICAR_PACIENTE
        );
    }

//    @Test(
//            enabled = true,
//            priority = 2,
//            description = """
//                          Test que verifica que la tabla de paciente contiene 
//                          registros en el sistema.
//                          """
//    )
//    public void testGetListEntidad() {
//        List<Paciente> result = getListEntidad();
//        assertFalse(
//                result.isEmpty(),
//                "Se encuentra registros en la lista de paciente."
//        );
//    }
    @Test(
            enabled = true,
            description = """
                          Metodo encargado de consultar los sexo de los 
                          pacientes.
                          """,
            priority = 2
    )
    public void testGetSexoPaciente() {
        assertTrue(
                M_Paciente.getSexoPaciente(
                        M_PersonaNGTest.persona(Boolean.FALSE).getId_persona()
                ).equals("M"),
                ERROR_AL_CONSULTAR_EL_SEXO_DE_UN_PACIENTE
        );
    }

    @Test(
            enabled = false,
            description = "",
            priority = 2
    )
    public void testExistePaciente() {

        Resultado result = M_Paciente.existePaciente("");

        assertTrue(
                result.getEstado(),
                ERROR_AL_CONSULTAR_LA_CEDULA_DEL_PACIENTE
        );
    }

//    @Test(
//            enabled = false,
//            description = "",
//            priority = 2
//    )
//    public void testGetPacienteActivo_boolean() {
//        boolean estado = false;
//        ResultSet expResult = null;
//        ResultSet result = M_Paciente.getPacienteActivo(estado);
//        assertEquals(result, expResult);
//    }
//
//    @Test(
//            enabled = false,
//            description = "",
//            priority = 2
//    )
//    public void testGetPacienteActivo_3args() {
//        String filtro = "";
//        String fecha = "";
//        int idControlConsulta = 0;
//        ResultSet expResult = null;
//        ResultSet result = M_Paciente.getPacienteActivo(filtro, fecha, idControlConsulta);
//        assertEquals(result, expResult);
//    }
//
//    @Test(
//            enabled = false,
//            description = "",
//            priority = 2
//    )
//    public void testGetPacienteActivo2() {
//        String filtro = "";
//        String fecha = "";
//        int idControlConsulta = 0;
//        ResultSet expResult = null;
//        ResultSet result = M_Paciente.getPacienteActivo2(filtro, fecha, idControlConsulta);
//        assertEquals(result, expResult);
//    }
//
//    @Test(
//            enabled = false,
//            description = "",
//            priority = 2
//    )
//    public void testGetPacienteActivo3() {
//        String filtro = "";
//        String fecha = "";
//        int idControlConsulta = 0;
//        ResultSet expResult = null;
//        ResultSet result = M_Paciente.getPacienteActivo3(filtro, fecha, idControlConsulta);
//        assertEquals(result, expResult);
//    }
    @Test(
            enabled = true,
            description = "Test que permite eliminar un paciente ya creado.",
            priority = 3
    )
    public void testDelete() {
        Resultado result = M_Paciente.delete(
                M_PersonaNGTest.persona(Boolean.FALSE).getId_persona()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(PACIENTE_BORRADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_PACIENTE.formatted(
                        M_PersonaNGTest.persona(Boolean.FALSE).getId_persona()
                )
        );

        persona.testDelete();
    }

    public synchronized Paciente generarPaciente() {
        return Paciente
                .builder()
                .persona(
                        Persona
                                .builder()
                                .id_persona(
                                        M_PersonaNGTest.persona(Boolean.FALSE).getId_persona()
                                )
                                .build()
                )
                .pesoNacimiento(BigDecimal.TEN)
                .altura(new BigDecimal("14.98"))
                .perimetroCefalico(new BigDecimal(8.5d))
                .cesarea(Boolean.FALSE)
                .tiempoGestacion(8)
                .build();
    }

    @Test
    public void testGetList() {

        List result = M_Paciente.getList(
                Paciente
                        .builder()
                        .persona(
                                Persona
                                        .builder()
                                        .build()
                        )
                        .build()
        );

        assertFalse(
                result.isEmpty(),
                "La lista de paciente esta vacia."
        );
    }

    @Test
    public void testSqlGetList() {
        String expResult = """
                           SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO,
                               FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, ESTADO,
                               PESO_NACIMIENTO_KG, ALTURA, PERIMETRO_CEFALICO,
                               CESAREA, TIEMPO_GESTACION, MASA_CEFALICA
                           FROM GET_PACIENTES
                           """;

        assertEquals(
                M_Paciente.sqlGetList(
                        Paciente
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .build()
                                )
                                .build()
                ),
                expResult.strip().trim()
        );

        expResult = """
                    SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO,
                        FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, ESTADO,
                        PESO_NACIMIENTO_KG, ALTURA, PERIMETRO_CEFALICO,
                        CESAREA, TIEMPO_GESTACION, MASA_CEFALICA
                    FROM GET_PACIENTES
                    WHERE ESTADO
                    """;

        assertEquals(
                M_Paciente.sqlGetList(
                        Paciente
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .estado(Boolean.TRUE)
                                                .build()
                                )
                                .build()
                ),
                expResult.strip().trim()
        );

        expResult = """
                    SELECT ID, PNOMBRE, SNOMBRE, APELLIDOS, SEXO, FECHA_NACIMIENTO,
                        FECHA_INGRESO, FECHA_HORA_ULTIMO_UPDATE, ESTADO,
                        PESO_NACIMIENTO_KG, ALTURA, PERIMETRO_CEFALICO,
                        CESAREA, TIEMPO_GESTACION, MASA_CEFALICA
                    FROM GET_PACIENTES
                    WHERE ESTADO IS FALSE
                    """;

        assertEquals(
                M_Paciente.sqlGetList(
                        Paciente
                                .builder()
                                .persona(
                                        Persona
                                                .builder()
                                                .estado(Boolean.FALSE)
                                                .build()
                                )
                                .build()
                ),
                expResult.strip().trim()
        );
    }
}
