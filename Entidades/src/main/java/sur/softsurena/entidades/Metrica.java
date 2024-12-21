package sur.softsurena.entidades;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.swing.ImageIcon;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Metrica {

    private final Integer id;
    private final Consulta consulta;
    private final Timestamp fecha;
    private final BigDecimal pesoKG;
    private final BigDecimal estaturaM;
    private final BigDecimal escefalo;
    private final String enf_detect;
    private final String hallazgosPositivo;
    private final String idDiagnostico;
    private final String tx;
    private final String complemento;
    private final ImageIcon imagen;
    private final File imagenPath;
    private final String usuario;

    @Override
    public String toString() {
        return id.toString();
    }
    
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Metrica{");
        sb.append("id=").append(id);
        sb.append(", consulta=").append(consulta);
        sb.append(", fecha=").append(fecha);
        sb.append(", pesoKG=").append(pesoKG);
        sb.append(", estaturaM=").append(estaturaM);
        sb.append(", escefalo=").append(escefalo);
        sb.append(", enf_detect=").append(enf_detect);
        sb.append(", hallazgosPositivo=").append(hallazgosPositivo);
        sb.append(", idDiagnostico=").append(idDiagnostico);
        sb.append(", tx=").append(tx);
        sb.append(", complemento=").append(complemento);
        sb.append(", imagen=").append(imagen);
        sb.append(", imagenPath=").append(imagenPath);
        sb.append(", usuario=").append(usuario);
        sb.append('}');
        return sb.toString();
    }

    
    
}
