package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Almacen;
import static sur.softsurena.metodos.M_Almacen.ALMACEN_ACTUALIZADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Almacen.ALMACEN_AGREGADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Almacen.ALMACEN_ELIMINADO_CORRECTAMENTE;
import static sur.softsurena.metodos.M_Almacen.ERROR_AL_ELIMINAR_ALMACEN;
import sur.softsurena.utilidades.Resultado;

@Getter
public class M_AlmacenNGTest {

    private static int idAlmacen, idAlmacen2;

    public M_AlmacenNGTest() {
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
            description = "Realiza el proceso de registro de un almacen de prueba.",
            priority = 1
    )
    public static void testInsert() {
        Resultado result = M_Almacen.insert(
                Almacen
                        .builder()
                        .nombre("Registro prueba")
                        .ubicacion("Debe de describir la ubicacion del almacen.")
                        .estado(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ALMACEN_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                M_Almacen.ERROR_AL_INSERTAR__ALMACEN
        );
        
        assertTrue(
                result.getId() > 0,
                "Error al insertar almacen."
        );

        idAlmacen = result.getId();
//------------------------------------------------------------------------------

        result = M_Almacen.insert(
                Almacen
                        .builder()
                        .nombre("Texto de prueba")
                        .ubicacion("Debe de describir la ubicacion del almacen.")
                        .estado(Boolean.FALSE)
                        .build()
        );

        assertEquals(
                result, 
                Resultado
                        .builder()
                        .mensaje(ALMACEN_AGREGADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                M_Almacen.ERROR_AL_INSERTAR__ALMACEN
        );

        assertTrue(
                result.getId() > 0,
                "Error al insertar almacen2."
        );
        
        idAlmacen2 = result.getId();
    }

    @Test(
            enabled = true,
            description = "Permite verificar si las tabla estan vacia.",
            priority = 2
    )
    public static void testSelect() {
        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(-1)
                                .nombre("^+-*/")
                                .build()
                ),
                "La tabla de almacen NO esta vacia."
        );
        
        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(idAlmacen)
                                .nombre("^+-*/")
                                .build()
                ),
                "La tabla de almacen NO esta vacia."
        );

        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(idAlmacen2)
                                .nombre("Seleccione")
                                .build()
                ),
                "La tabla de almacen NO esta vacia."
        );

        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(-1)
                                .nombre("Registro")
                                .build()
                ),
                "La tabla de almacen NO esta vacia."
        );

        assertNotNull(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(-1)
                                .nombre("Texto")
                                .build()
                ),
                "La tabla de almacen NO esta vacia."
        );
    }

    @Test(
            enabled = true,
            description = "Prueba que actualiza el registro de los almacenes del sistema.",
            priority = 3
    )
    public static void testUpdate() {
        Resultado result = M_Almacen.update(
                Almacen
                        .builder()
                        .id(idAlmacen)
                        .nombre("Registro ha sido actualizado")
                        .ubicacion("Ha sido movido.")
                        .estado(Boolean.FALSE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ALMACEN_ACTUALIZADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ELIMINAR_ALMACEN
        );
    }

    @Test(
            enabled = true,
            description = "Prueba que elimina el registro de los almacenes del sistema.",
            priority = 4
    )
    public static void testDelete() {
        Resultado result = M_Almacen.delete(idAlmacen);
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ALMACEN_ELIMINADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ELIMINAR_ALMACEN
        );

        result = M_Almacen.delete(idAlmacen2);
        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(ALMACEN_ELIMINADO_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_ELIMINAR_ALMACEN
        );
    }
}
