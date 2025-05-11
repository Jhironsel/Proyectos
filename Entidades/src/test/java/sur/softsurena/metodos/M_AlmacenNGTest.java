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
@Test(
        dependsOnGroups = "init"
)
public class M_AlmacenNGTest {

    private static int idAlmacen, idAlmacen2;

    public M_AlmacenNGTest() {
        System.out.println("sur.softsurena.metodos.M_AlmacenNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {}

    @AfterClass
    public void tearDownClass() throws Exception {}

    @BeforeMethod
    public void setUpMethod() throws Exception {}

    @AfterMethod
    public void tearDownMethod() throws Exception {}

    @Test(
            enabled = true,
            description = "Permite verificar si las tabla estan vacia."
    )
    public static void testSelect() {
        assertTrue(
                M_Almacen.select(
                        Almacen
                                .builder()
                                .id(0)
                                .build()
                ).isEmpty(),
                "La tabla de almacen esta vacia."
        );
    }

    @Test(
            enabled = true,
            description = """
                          """
    )
    public static void testInsertAlmacenGeneral() {
        if (M_Almacen.select(
                Almacen
                        .builder()
                        .id(0)
                        .build()
        ).isEmpty()) {
            M_Almacen.insert(
                    Almacen
                            .builder()
                            .nombre("Almacen general")
                            .ubicacion("Almacen generico del sistema.")
                            .estado(Boolean.TRUE)
                            .build()
            );
        }
    }
    
    @Test(
            enabled = true,
            description = "Realiza el proceso de registro de un almacen de prueba.",
            dependsOnMethods = "testSelect"
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
            description = "Prueba que actualiza el registro de los almacenes del sistema.",
            dependsOnMethods = "testInsert"
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
            dependsOnMethods = {"testInsert", "testUpdate"}
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

        result = M_Almacen.delete(-1);
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
    
    public static Almacen getAlmacen(){
        return Almacen
                .builder()
                .id(idAlmacen)
                .nombre("Almacen generado")
                .ubicacion("Ubicacion generada.")
                .estado(Boolean.TRUE)
                .build();
    }
}
