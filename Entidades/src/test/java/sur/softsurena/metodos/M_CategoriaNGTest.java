package sur.softsurena.metodos;

import java.io.File;
import java.util.List;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Categoria;
import static sur.softsurena.metodos.M_Categoria.OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__CA;
import static sur.softsurena.metodos.M_Producto.generarCodigoBarra;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_CategoriaNGTest {

    public static int idCategoria1, idCategoria2;
    public static String descripcion1, descripcion2;

    public M_CategoriaNGTest() {
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
            description = "Permite registrar una categoria al sistema.",
            priority = 0
    )
    public static void testInsert() {
        Resultado result = M_Categoria.insert(
                Categoria
                        .builder()
                        .descripcion(generarCodigoBarra())
                        .pathImage(new File("Imagenes/ImagenPrueba.png"))
                        .estado(Boolean.TRUE)
                        .build()
        );

        assertTrue(
                result.getEstado(),
                "Problemas en el registro de la categoria."
        );
        idCategoria1 = result.getId();

        result = M_Categoria.insert(
                Categoria
                        .builder()
                        .descripcion(generarCodigoBarra())
                        .pathImage(null)
                        .estado(Boolean.FALSE)
                        .build()
        );

        assertTrue(
                result.getEstado(),
                "Problemas en el registro de la categoria."
        );

        idCategoria2 = result.getId();
    }

    @Test(
            enabled = true,
            description = "Permite modificar una categoria del sistema.",
            priority = 1
    )
    public void testUpdate() {
        descripcion1 = generarCodigoBarra();
        Resultado result = M_Categoria.update(
                Categoria
                        .builder()
                        .id_categoria(idCategoria1)
                        .descripcion(descripcion1)
                        .pathImage(null)
                        .estado(Boolean.FALSE)
                        .build()
        );
        assertTrue(
                result.getEstado(),
                "No pudo ser modificado el registro de las categorias."
        );

        descripcion2 = generarCodigoBarra();
        result = M_Categoria.update(
                Categoria
                        .builder()
                        .id_categoria(idCategoria2)
                        .descripcion(descripcion2)
                        .pathImage(new File("Imagenes/ImagenPrueba.png"))
                        .estado(Boolean.TRUE)
                        .build()
        );
        assertTrue(
                result.getEstado(),
                "No pudo ser modificado el registro de las categorias."
        );
    }

    @Test(
            enabled = true,
            description = "Pruebas de consultas a las categorias con o sin fotos.",
            priority = 2
    )
    public void testSqlSelect() {
        Categoria categoria = null;
        String expResult = "";
        String result = M_Categoria.sqlSelect(categoria);
        assertEquals(result, expResult);
    }
    
    @Test(
            enabled = true,
            description = "Pruebas de consultas a las categorias con o sin fotos.",
            priority = 2
    )
    public void testSelect() {
        List result = M_Categoria.select(
                Categoria
                        .builder()
                        .estado(Boolean.TRUE)
                        .build()
        );
        assertNotNull(
                result,
                "Error al obtener todas las categorias con fotos."
        );

        result = M_Categoria.select(
                Categoria
                        .builder()
                        .estado(Boolean.FALSE)
                        .build()
        );
        assertNotNull(
                result,
                "Error al obtener todas las categorias sin fotos."
        );

    }

    @Test(
            enabled = true,
            description = "Permite verificar que una categoria esta registrada en el sistema.",
            priority = 4
    )
    public static void testExist() {

        Boolean result = M_Categoria.exist(descripcion1);
        assertTrue(
                result,
                "No existe registros de pruebas en la consulta."
        );

        result = M_Categoria.exist(descripcion2);
        assertTrue(
                result,
                "No existe registros de pruebas en la consulta."
        );
    }

    @Test(
            enabled = true,
            description = "Permite eliminar una gategoria del sistema.",
            priority = 5
    )
    public static void testDelete() {
        Resultado result = M_Categoria.delete(idCategoria1);
        assertTrue(
                result.getEstado(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__CA.formatted(idCategoria1)
        );

        result = M_Categoria.delete(idCategoria2);
        assertTrue(
                result.getEstado(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__CA.formatted(idCategoria2)
        );
    }
}
