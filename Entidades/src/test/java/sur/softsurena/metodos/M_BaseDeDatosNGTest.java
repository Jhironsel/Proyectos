package sur.softsurena.metodos;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_BaseDeDatosNGTest {

    public M_BaseDeDatosNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "RRR_SOFTSURENA"
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
        //TODO Se debe verificar si el equipo esta registrado.
        assertTrue(result > 0, "La base de datos cuenta con periodo insuficiente.");
    }

    @Test(
            enabled = true,
            priority = 0,
            description = ""
    )
    public void testSetLicencia() throws SQLException {
        Conexion.getInstance(
                "Registrador",
                "123uasd",
                "registros.db",
                "localhost",
                "3050"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
        Date fecha = new Date(new GregorianCalendar().getTimeInMillis());
        String idMaquina = "Registro de prueba";
        assertTrue(
                M_BaseDeDatos.setLicencia(
                        fecha, 
                        idMaquina, 
                        "Prueba", 
                        "+1(829) 299-5555", 
                        "Haciendo prueba."
                ).getEstado(), 
                "El registro de la licencia no fue insertado."
        );
        Conexion.getCnn().close();
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