package sur.softsurena.entidades;

import java.sql.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public final class Categoria implements Comparable<Object> {
    
    private final Integer id_categoria;
    private final String descripcion;
    private final Date fecha_creacion;
    private final Boolean estado;

    @Override
    public String toString() {
        return descripcion;
    }

    @Override
    public int compareTo(Object o) {
        Categoria c = (Categoria) o;

        return this.id_categoria.compareTo(c.id_categoria);
    }

}
