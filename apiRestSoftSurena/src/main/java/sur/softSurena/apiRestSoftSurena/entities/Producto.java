package sur.softSurena.apiRestSoftSurena.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTOS2")
public class Producto{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCategoria;
    private String codigo;
    private String descripcion;
    private BigDecimal existencia;
    private String nota;
    private Date fechaCreacion;
    private Boolean estado;   
}
