package sur.softSurena.apiRestSoftSurena.service;

import java.util.List;
import java.util.Optional;
import sur.softSurena.apiRestSoftSurena.entities.Producto;

/**
 *
 * @author jhironsel
 */
public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Optional<Producto> delete(Long id);
}
