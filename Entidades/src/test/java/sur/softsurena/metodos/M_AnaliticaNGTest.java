package sur.softsurena.metodos;

import lombok.Getter;
import org.testng.annotations.Test;
import sur.softsurena.entidades.Analitica;

@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_AnaliticaNGTest {
    private static int idAnalitica, idDoctor, idPaciente;
    
    public static Analitica getAnalitica(){
        return Analitica
                .builder()
                .id(idAnalitica)
                .id_doctor(idDoctor) //TODO 10/05/2025 traer el id del doctor.
                .id_paciente(idPaciente) //TODO 10/05/2025 traer el id del paciente.
                .T_BHCG(Boolean.TRUE)
                .T_EMB_ORINA(Boolean.TRUE)
                .T_EMB_SANGRE(Boolean.TRUE)
                .build();
    }
}
