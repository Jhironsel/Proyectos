package sur.softsurena.metodos;

import java.sql.Date;
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

    private int idPersona;

    public M_ProveedorNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws SQLException {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "NONE"
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
            enabled = true,
            priority = 2,
            description = """
                          
                          """
    )
    public void testInsert() {
        Resultado persona = M_Persona.insert(
                Persona
                        .builder()
                        .pnombre("Proveedor Prueba")
                        .snombre("")
                        .apellidos("Test del sistema")
                        .persona('F')
                        .sexo('m')
                        .fecha_nacimiento(new Date(0))
                        .estado(Boolean.TRUE)
                        .build()
        );

        idPersona = persona.getId();

        Resultado result = M_Proveedor.insert(
                Proveedor
                        .builder()
                        .id(idPersona)
                        .codigoProveedor(M_ContactoTel.generarTelMovil())
                        .build()
        );

        assertTrue(
                result.getEstado(),
                ""
        );
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
        assertTrue(
                M_Proveedor.delete(
                        Proveedor
                                .builder()
                                .id(idPersona)
                                .build()
                ).getEstado(),
                "Error al eliminar el proveedor."
        );

        assertTrue(
                M_Persona.delete(idPersona).getEstado(),
                "Error al eliminar la persona."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSelectATR() {
        assertNotNull(
                M_Proveedor.selectATR(
                        Proveedor
                                .builder()
                                .build()
                ),
                "Error al consultar los proveedores."
        );

        assertNotNull(
                M_Proveedor.selectATR(
                        Proveedor
                                .builder()
                                .id(0)
                                .build()
                ),
                "Error al consultar los proveedores."
        );

        assertNotNull(
                M_Proveedor.selectATR(
                        Proveedor
                                .builder()
                                .codigoProveedor("000-0000")
                                .build()
                ),
                "Error al consultar los proveedores."
        );
    }

    @Test(
            enabled = true,
            priority = 0,
            description = """
                          """
    )
    public void testSqlProveedor() {
        assertEquals(
                M_Proveedor.sqlProveedor(Proveedor.builder().build()),
                """
                SELECT ID, CODIGO
                FROM V_PERSONAS_PROVEEDORES_ATR"""
        );
        assertEquals(
                M_Proveedor.sqlProveedor(Proveedor.builder().id(-1).build()),
                """
                SELECT ID, CODIGO
                FROM V_PERSONAS_PROVEEDORES_ATR
                WHERE ID = -1"""
        );
        assertEquals(
                M_Proveedor.sqlProveedor(Proveedor.builder().codigoProveedor("000-0000").build()),
                """
                SELECT ID, CODIGO
                FROM V_PERSONAS_PROVEEDORES_ATR
                WHERE CODIGO STARTING WITH '000-0000'"""
        );
    }

}
