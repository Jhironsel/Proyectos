package sur.softsurena.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sur.softsurena.abstractas.Persona;

@Getter
@SuperBuilder
public class Cliente extends Persona{
    
    private final BigDecimal totalFacturado;
    private final BigDecimal totalDeuda;
    private final Integer cantidadFactura;
    private final Date fechaUltimaCompra;
    private final BigDecimal saldo;

    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public String getJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("totalFacturado=").append(totalFacturado);
        sb.append(", totalDeuda=").append(totalDeuda);
        sb.append(", cantidadFactura=").append(cantidadFactura);
        sb.append(", fechaUltimaCompra=").append(fechaUltimaCompra);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.totalFacturado);
        hash = 17 * hash + Objects.hashCode(this.totalDeuda);
        hash = 17 * hash + Objects.hashCode(this.cantidadFactura);
        hash = 17 * hash + Objects.hashCode(this.fechaUltimaCompra);
        hash = 17 * hash + Objects.hashCode(this.saldo);
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