package sur.softsurena.JPA_Firebird.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import sur.softsurena.JPA_Firebird.modelos.Movie;

/**
 *
 * @author jhironsel
 */
public interface MovieRepositorio extends JpaRepository<Movie, Long>{
    
}
