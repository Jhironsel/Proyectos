package sur.softsurena.interfaces;

import java.util.List;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;

public interface Operaciones<T> {
    T getEntity(FiltroBusqueda filtro);
    List<T> getEntities(FiltroBusqueda filtro);
    Resultado setEntity(T object);
    Resultado putEntity(T object);
    Resultado delEntity(int id);
}
