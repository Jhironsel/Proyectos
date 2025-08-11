package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.metodos.M_Persona;

@Getter
@SuperBuilder
public class Cliente {
    
    private final Integer id;
    private final BigDecimal totalFacturado;
    private final BigDecimal totalDeuda;
    private final Integer cantidadFactura;
    private final Date fechaUltimaCompra;
    private final BigDecimal saldo;
    
    private final Paginas pagina;

    @Override
    public String toString() {
        
        return M_Persona.select(
                Persona
                        .builder()
                        .idPersona(id)
                        .build()
        ).getFirst().toString();
    }
    
    public String getJSON() {
        return "Cliente{" + 
                "Id=" + id.toString() + 
                ", totalFacturado=" + totalFacturado + 
                ", totalDeuda=" + totalDeuda + 
                ", cantidadFactura=" + cantidadFactura + 
                ", fechaUltimaCompra=" + fechaUltimaCompra + 
                ", saldo=" + saldo + 
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.totalFacturado);
        hash = 59 * hash + Objects.hashCode(this.totalDeuda);
        hash = 59 * hash + Objects.hashCode(this.cantidadFactura);
        hash = 59 * hash + Objects.hashCode(this.fechaUltimaCompra);
        hash = 59 * hash + Objects.hashCode(this.saldo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.totalFacturado, other.totalFacturado)) {
            return false;
        }
        if (!Objects.equals(this.totalDeuda, other.totalDeuda)) {
            return false;
        }
        if (!Objects.equals(this.cantidadFactura, other.cantidadFactura)) {
            return false;
        }
        if (!Objects.equals(this.fechaUltimaCompra, other.fechaUltimaCompra)) {
            return false;
        }
        return Objects.equals(this.saldo, other.saldo);
    }
}