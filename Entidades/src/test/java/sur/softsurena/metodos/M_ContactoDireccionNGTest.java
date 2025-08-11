package sur.softsurena.metodos;

import javax.swing.JOptionPane;
import lombok.Getter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import sur.softsurena.entidades.ContactoDireccion;
import sur.softsurena.entidades.Persona;
import static sur.softsurena.metodos.M_ContactoDireccion.DIRECCION_AGREGADA_CORRECTAMENTE;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI;
import static sur.softsurena.metodos.M_ContactoDireccion.ERROR_AL_INSERTAR_DIRECCION;
import static sur.softsurena.metodos.M_ContactoDireccion.REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.javaDateToSqlDate;
import static sur.softsurena.utilidades.Utilidades.stringToDate;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_ContactoDireccionNGTest {

    private int idDireccion, idPersona;

    @Test(
            groups = "M_ContactoDireccionNGTest.testUpdateOrInsert"
    )
    public void testUpdateOrInsert() {

        Resultado result;
        if (M_ContactoDireccion
                .selectByID(0)
                .stream()
                .filter(dir -> dir.getId() == 0)
                .findFirst()
                .isEmpty()) {
            result = M_ContactoDireccion.insert(
                    ContactoDireccion
                            .builder()
                            .idPersona(0)
                            .idProvincia(0)
                            .idMunicipio(0)
                            .idDistritoMunicipal(0)
                            .direccion("Direccion de GENERICA.")
                            .estado(Boolean.TRUE)
                            .porDefecto(Boolean.TRUE)
                            .build()
            );

            assertTrue(
                    result.getEstado(),
                    "No puede insertarse la direccion generica."
            );
        }

        M_PersonaNGTest.persona = Persona
                .builder()
                .persona('J')
                .pnombre("MContactoDireccion")
                .snombre("MContactoDireccion")
                .apellidos("MContactoDireccion")
                .sexo('M')
                .fecha_nacimiento(
                        javaDateToSqlDate(
                                stringToDate("23.06.2017", "dd.MM.yyyy")
                        )
                )
                .estado(Boolean.TRUE)
                .build();
        
        M_PersonaNGTest.testInsert();
        idPersona = M_PersonaNGTest.idPersona;

        result = M_ContactoDireccion.insert(
                ContactoDireccion
                        .builder()
                        .idPersona(idPersona)
                        .idProvincia(0)
                        .idMunicipio(0)
                        .idDistritoMunicipal(0)
                        .direccion("Insercion de prueba.")
                        .estado(Boolean.TRUE)
                        .porDefecto(Boolean.TRUE)
                        .build()
        );

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(DIRECCION_AGREGADA_CORRECTAMENTE)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_INSERTAR_DIRECCION
        );

        assertTrue(
                result.getId() > 0,
                ERROR_AL_INSERTAR_DIRECCION
        );

        idDireccion = result.getId();
    }//----------------------------------------------------------------------FIN

    @Test(
            dependsOnMethods = "testUpdateOrInsert"
    )
    public void testSelectByID() {
        assertNotNull(
                M_ContactoDireccion.selectByID(idPersona),
                "La lista contiene datos"
        );
    }//----------------------------------------------------------------------FIN

    @Test(
            dependsOnMethods = {"testUpdateOrInsert"}
    )
    public void testDelete() {

        Resultado result = M_ContactoDireccion.delete(idDireccion);

        assertEquals(
                result,
                Resultado
                        .builder()
                        .mensaje(REGISTRO_DE_LA_DIRECCION_BORRADO_CORRECTA)
                        .icono(JOptionPane.INFORMATION_MESSAGE)
                        .estado(Boolean.TRUE)
                        .build(),
                ERROR_AL_BORRAR_EL_REGISTRO_DE_LA_DIRECCI
        );

        M_PersonaNGTest.idPersona = idPersona;
        M_PersonaNGTest.testDelete();
    }
}
