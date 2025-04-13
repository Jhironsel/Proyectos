package sur.softsurena.metodos;

import java.util.List;
import javax.swing.JOptionPane;
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
import static sur.softsurena.metodos.M_Categoria.SE_MODIFICO_LA_CATEGORIA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Producto.generarCodigoBarra;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 */
@Getter
public class M_CategoriaNGTest {

    public static int idCategoria;
    public static String descripcion;

    public M_CategoriaNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050",
                "None"
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
                        .estado(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(M_Categoria.CATEGORIA_AGREGADA_CON_EXITO)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                "Problemas en el registro de la categoria."
        );
        
        assertTrue(
                result.getId() > 0,
                "Identificador de la categoria es menor que cero!!!"
                );
        
        idCategoria = result.getId();
    }

    @Test(
            enabled = true,
            description = "Permite modificar una categoria del sistema.",
            priority = 1
    )
    public void testUpdate() {
        descripcion = generarCodigoBarra();
        assertEquals(
                M_Categoria.update(
                        Categoria
                                .builder()
                                .id_categoria(idCategoria)
                                .descripcion(descripcion)
                                .estado(Boolean.FALSE)
                                .build()
                ),
                Resultado
                        .builder()
                        .mensaje(SE_MODIFICO_LA_CATEGORIA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build()
        );
    }

    @Test(
            enabled = true,
            description = "Pruebas de consultas a las categorias con o sin fotos.",
            priority = 2
    )
    public void testSqlSelect() {
        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO, COALESCE(IMAGEN_TEXTO,'') IMAGEN_TEXTO
                FROM V_CATEGORIAS
                ORDER BY 1;
                """.trim().strip()
        );

        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .id_categoria(0)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO, COALESCE(IMAGEN_TEXTO,'') IMAGEN_TEXTO
                FROM V_CATEGORIAS
                WHERE ID = 0 
                ORDER BY 1;
                """.trim().strip()
        );

        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .estado(Boolean.TRUE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO, COALESCE(IMAGEN_TEXTO,'') IMAGEN_TEXTO
                FROM V_CATEGORIAS
                WHERE ESTADO
                ORDER BY 1;
                """.trim().strip()
        );

        assertEquals(
                M_Categoria.sqlSelect(
                        Categoria
                                .builder()
                                .estado(Boolean.FALSE)
                                .build()
                ),
                """
                SELECT ID, DESCRIPCION, FECHA_CREACION, ESTADO, COALESCE(IMAGEN_TEXTO,'') IMAGEN_TEXTO
                FROM V_CATEGORIAS
                WHERE ESTADO IS FALSE
                ORDER BY 1;
                """.trim().strip()
        );
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

        Boolean result = M_Categoria.exist(descripcion);
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
        Resultado result = M_Categoria.delete(idCategoria);
        assertTrue(
                result.getEstado(),
                OCURRIO_UN_ERROR_AL_INTENTAR_BORRAR_LA__CA.formatted(idCategoria)
        );
    }
}
