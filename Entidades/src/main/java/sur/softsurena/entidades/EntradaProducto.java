package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class EntradaProducto {
    
    private final Integer id;
    private final Integer idProveedor; //Identificador del proveedor
    private final Integer idAlmacen;
    private final String cod_factura; //Encabezado de la factura.
    private final Date fechaEntrada;
    private final Character estado;

    @Override
    public String toString() {
        return cod_factura;
    }
    
    
}
