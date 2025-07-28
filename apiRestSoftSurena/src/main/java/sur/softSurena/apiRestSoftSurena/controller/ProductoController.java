package sur.softSurena.apiRestSoftSurena.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sur.softSurena.apiRestSoftSurena.entities.Producto;
import sur.softSurena.apiRestSoftSurena.service.ProductoService;

/**
 *
 * @author jhironsel
 */
@RestController
public class ProductoController {
    final private ProductoService servicio;

    public ProductoController(ProductoService servicio) {
        this.servicio = servicio;
    }
    
    @GetMapping
    public ResponseEntity<List<Producto>> list(){
        return ResponseEntity.ok(servicio.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long id){
        Optional<Producto> optional = servicio.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.orElseThrow());
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(producto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Long id){
        Optional<Producto> optional = servicio.findById(id);
        
        if(optional.isPresent()){
            Producto productoDB = optional.orElseThrow();
            
            productoDB.setId(producto.getId());
            productoDB.setIdCategoria(producto.getIdCategoria());
            productoDB.setCodigo(producto.getCodigo());
            productoDB.setDescripcion(producto.getDescripcion());
            productoDB.setExistencia(producto.getExistencia());
            productoDB.setNota(producto.getNota());
            productoDB.setFechaCreacion(producto.getFechaCreacion());
            productoDB.setEstado(producto.getEstado());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(productoDB));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> delete(@PathVariable Long id){
         Optional<Producto> optional = servicio.delete(id);
        
        if(optional.isPresent()){
            Producto productoDB = optional.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(productoDB);
        }
        return ResponseEntity.notFound().build();
    }
}
