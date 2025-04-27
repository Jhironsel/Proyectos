package sur.softsurena.metodos;

import java.io.File;
import javax.swing.JOptionPane;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.FotoProducto;
import sur.softsurena.entidades.Producto;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 *
 * @author jhironsel
 */
public class M_Foto_ProductoNGTest {

    private Integer idfoto;
    private Integer idProducto;

    public M_Foto_ProductoNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
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
                          """
    )
    public void testSqlSelect() {
        assertEquals(
                M_Foto_Producto.sqlSelect(
                        FotoProducto
                                .builder()
                                .build()
                ),
                """
                SELECT ID, ID_PRODUCTO, FOTO, FECHA_HORA_CREACION, ACTUAL
                FROM V_FOTO_PRODUCTO
                """.strip()
        );

        assertEquals(
                M_Foto_Producto.sqlSelect(
                        FotoProducto
                                .builder()
                                .id(0)
                                .build()
                ),
                """
                SELECT ID, ID_PRODUCTO, FOTO, FECHA_HORA_CREACION, ACTUAL
                FROM V_FOTO_PRODUCTO
                WHERE ID = 0
                """.strip()
        );

        assertEquals(
                M_Foto_Producto.sqlSelect(
                        FotoProducto
                                .builder()
                                .idProducto(0)
                                .build()
                ),
                """
                SELECT ID, ID_PRODUCTO, FOTO, FECHA_HORA_CREACION, ACTUAL
                FROM V_FOTO_PRODUCTO
                WHERE ID_PRODUCTO = 0
                """.strip()
        );
    }

    @Test(
            enabled = true,
            priority = 1,
            description = """
                          """,
            dependsOnMethods = "testSqlSelect"
    )
    public void testSelect() {
        assertNotNull(
                M_Foto_Producto.select(
                        FotoProducto
                                .builder()
                                .build()
                ),
                "Error en la consulta de foto del producto."
        );
        
        assertNotNull(
                M_Foto_Producto.select(
                        FotoProducto
                                .builder()
                                .id(0)
                                .build()
                ),
                "Error en la consulta de foto del producto."
        );
        
        assertNotNull(
                M_Foto_Producto.select(
                        FotoProducto
                                .builder()
                                .idProducto(0)
                                .build()
                ),
                "Error en la consulta de foto del producto."
        );
    }

    @Test(
            enabled = true,
            priority = 2,
            description = """
                          """
    )
    public void testInsert() {
        M_ProductoNGTest.testInsert();
        Producto producto = M_ProductoNGTest.producto(Boolean.TRUE);

        Resultado result = M_Foto_Producto.insert(
                FotoProducto
                        .builder()
                        .idProducto(producto.getId())
                        .foto(
                                Utilidades.imagenEncode64(
                                        new File("Imagenes/ImagenPrueba.png")
                                )
                        )
                        .actual(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje("Registro realizado correctamente.!!!")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );

        idfoto = result.getId();
        idProducto = producto.getId();
    }

    @Test(
            enabled = true,
            priority = 3,
            description = """
                          """,
            dependsOnMethods = "testInsert"
    )
    public void testUpdate() {
        Resultado result = M_Foto_Producto.update(
                FotoProducto
                        .builder()
                        .id(idfoto)
                        .idProducto(idProducto)
                        .foto("")
                        .actual(Boolean.TRUE)
                        .build()
        );
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje("Registro actualizado del sistema.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            priority = 4,
            description = """
                          """,
            dependsOnMethods = "testInsert"
    )
    public void testDelete() {
        assertEquals(
                M_Foto_Producto.delete(
                        FotoProducto
                                .builder()
                                .id(idfoto)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje("Registro eliminado del sistema.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            priority = 5,
            description = """
                          """
    )
    public void testDeleteById_persona() {
        assertEquals(
                M_Foto_Producto.deleteById_persona(
                        FotoProducto
                                .builder()
                                .idProducto(idProducto)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje("Registros eliminados del sistema.")
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }
}
