package sur.softsurena.metodos;

import java.sql.SQLException;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Proveedor;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_ProveedorNGTest {

    public M_ProveedorNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws SQLException {
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
    public void tearDownClass() throws SQLException {
        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
//------------------------------------------------------------------------------
    @Test(
            enabled = true,
            priority = 1,
            description = """
                          """
    )
    public void testSelect() {
        assertNotNull(
                M_Proveedor.select(), 
                "Error a consultar la lista de proveedores."
        );
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 2,
            description = ""
    )
    public void testInsert() {
        String expResult = "";
        Resultado result = M_Proveedor.insert(
                Proveedor
                        .builder()
                        .id(-1)
                        .codigoProveedor("")
                        .build()
        );
        assertEquals(result, expResult);
    }
    
//------------------------------------------------------------------------------
    @Test(
            enabled = false,
            priority = 3,
            description = ""
    )
    public void testUpdate() {
        Proveedor p = null;
        String expResult = "";
        Resultado result = M_Proveedor.update(p);
        assertEquals(result, expResult);
    }
    
//------------------------------------------------------------------------------
    /**
     * Test of delete method, of class M_Proveedor.
     */
    @Test(
            enabled = false,
            priority = 4,
            description = """
                          """
    )
    public void testDelete() {
        Proveedor proveedor = null;
        Resultado expResult = null;
        Resultado result = M_Proveedor.delete(proveedor);
        assertEquals(result, expResult);
    }

}