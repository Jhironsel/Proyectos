package sur.softsurena.metodos;

import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;

@Getter
public class M_CajeroNGTest {
    
    public M_CajeroNGTest() {
    }

    @BeforeClass(description = "Contiene lo necesario para conectarse en la base de datos.")
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

    @AfterClass(description = "Contiene el metodo necesario para cerrar la base de datos.")
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
            description = "Nos permite tener los atributos de los cajeros del sistema.",
            priority = 0
    )
    public void testGetCajeros() {
        List result = M_Cajero.select();
        assertFalse(
                result.isEmpty(), 
                "La tabla de cajero NO contiene usuarios"
        );
    }
}
