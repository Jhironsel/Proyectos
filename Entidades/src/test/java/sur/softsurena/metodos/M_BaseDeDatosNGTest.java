package sur.softsurena.metodos;

import java.io.File;
import java.sql.SQLException;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_BaseDeDatosNGTest {

    private String GUID;

    @Test(
            enabled = true,
            priority = 0,
            description = "Permite verificar que se obtiene una ruta a la base de datos."
    )
    public void testPathBaseDeDatos() {
        String result = M_BaseDeDatos.pathBaseDeDatos();

        assertNotNull(
                result,
                "No puede obtenerse la ruta a la base de datos."
        );

        assertFalse(
                result.isBlank(),
                "La ruta se encuentra en blanco."
        );

        File file = new File(result);

        assertTrue(
                file.canRead(),
                "No puede leerse la base de datos."
        );

        assertTrue(
                file.canWrite(),
                "No puede Escribirse en la base de datos."
        );

        assertFalse(
                file.isHidden(),
                "El archivo de la base de datos esta oculto."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testPeriodoMaquina() {
        int result = M_BaseDeDatos.periodoMaquina();
        assertTrue(
                result > 0, 
                "La base de datos cuenta con periodo insuficiente."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testSetLicencia() throws SQLException {
        //TODO 10/05/2025 Analizar el test de la licencia del sistemas.
//        Conexion.getInstance(
//                "Registrador",
//                "123uasd",
//                "registros.db",
//                "40.233.25.79",
//                "3050",
//                "R_REGISTRADOR"
//        );

//        if (Conexion.verificar().getEstado()) {
//            GregorianCalendar gregorianCalendar = new GregorianCalendar();
//            gregorianCalendar.add(Calendar.MONTH, 1);
//            Date fecha = new Date(gregorianCalendar.getTimeInMillis());
//
//            assertTrue(
//                    M_BaseDeDatos.setLicencia(
//                            fecha,
//                            GUID,
//                            "Prueba",
//                            "+1(829) 299-5555",
//                            "Haciendo prueba."
//                    ).getEstado(),
//                    "El registro de la licencia no fue insertado."
//            );
//        }

//        Conexion.getCnn().close();
    }

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testCantidadRegistros() {
        String tabla = "";
        int expResult = 0;
        int result = M_BaseDeDatos.cantidadRegistros(tabla);
        assertEquals(result, expResult);
    }

}
