 package sur.softSurena.apiRestSoftSurena.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sur.softSurena.apiRestSoftSurena.entities.Producto;
import sur.softSurena.apiRestSoftSurena.repositories.ProductoRepository;

/**
 *
 * @author jhironsel
 */
@Service
public class ProductoServiceImpl implements ProductoService{

    final private ProductoRepository repositorio;

    public ProductoServiceImpl(ProductoRepository repositorio) {
        this.repositorio = repositorio;
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) repositorio.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Producto> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    @Transactional
    public Optional<Producto> delete(Long id) {
        Optional<Producto> opcional = repositorio.findById(id);
        if(opcional.isPresent()){
            repositorio.deleteById(id);
            return opcional;
        }
        return Optional.empty();
    }
    
}
