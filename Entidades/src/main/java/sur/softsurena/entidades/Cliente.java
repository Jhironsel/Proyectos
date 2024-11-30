package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstracta.Persona;

@Getter
@SuperBuilder
public class Cliente {
    
    private final Persona persona;
    private final BigDecimal totalFacturado;
    private final BigDecimal totalDeuda;
    private final Integer cantidadFactura;
    private final Date fechaUltimaCompra;
    private final BigDecimal saldo;

    @Override
    public String toString() {
        return persona.toString();
    }
    
    public String getJSON() {
        return "Cliente{" + 
                "persona=" + persona + 
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
        hash = 59 * hash + Objects.hashCode(this.persona);
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
        
        if (!Objects.equals(this.persona, other.persona)) {
            System.out.println("No son iguales en persona.");
            return false;
        }
        if (!Objects.equals(this.totalFacturado, other.totalFacturado)) {
            System.out.println("No son iguales en totalFacturado.");
            return false;
        }
        if (!Objects.equals(this.totalDeuda, other.totalDeuda)) {
            System.out.println("No son iguales en TotalDeuda.");
            return false;
        }
        if (!Objects.equals(this.cantidadFactura, other.cantidadFactura)) {
            System.out.println("No son iguales en CantidadFactura.");
            return false;
        }
        if (!Objects.equals(this.fechaUltimaCompra, other.fechaUltimaCompra)) {
            System.out.println("No son iguales en UltimaCompra.");
            return false;
        }
        return Objects.equals(this.saldo, other.saldo);
    }
}