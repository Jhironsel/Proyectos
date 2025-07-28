package sur.softSurena.apiRestSoftSurena.repositories;

import org.springframework.data.repository.CrudRepository;
import sur.softSurena.apiRestSoftSurena.entities.Producto;
/**
 *
 * @author jhironsel
 */
public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
}
