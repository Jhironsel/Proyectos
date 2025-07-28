package sur.softsurena.jpaFirebird.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import sur.softsurena.jpaFirebird.modelos.Movie;

/**
 *
 * @author jhironsel
 */
public interface MovieRepositorio extends JpaRepository<Movie, Long>{
    
}
