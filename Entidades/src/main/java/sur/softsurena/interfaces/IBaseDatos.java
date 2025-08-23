package sur.softsurena.interfaces;

import java.util.List;
import sur.softsurena.utilidades.Resultado;

/**
 *
 * @author jhironsel
 * 
 * @param <T>
 */
public interface IBaseDatos<T> {

    /**
     *
     * @param entidad
     * @return
     */
    List<T> select(T entidad);

    /**
     *
     * @param entidad
     * @return
     */
    T selectById(T entidad);

    /**
     *
     * @param entidad
     * @return
     */
    Resultado insert(T entidad);

    /**
     *
     * @param entidad
     * @return
     */
    Resultado update(T entidad);

    /**
     *
     * @param entidad
     * @return
     */
    Resultado delete(T entidad);
}
