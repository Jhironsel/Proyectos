package sur.softsurena.JPA_Firebird.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sur.softsurena.JPA_Firebird.modelos.Movie;
import sur.softsurena.JPA_Firebird.repositorios.MovieRepositorio;

/**
 *
 * @author jhironsel
 */
@RestController
@RequestMapping("/api/movies/")
public class MovieController {
    
    @Autowired
    private MovieRepositorio movieRepositorio;
    
    @CrossOrigin
    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepositorio.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        
        Optional<Movie> movie = movieRepositorio.findById(id);
        
        return movie.map(
                ResponseEntity::ok
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }
    
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie saveMovie = movieRepositorio.save(movie);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(saveMovie);
        
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        if(!movieRepositorio.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        movieRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(
        @PathVariable Long id, @RequestBody Movie updateMovie
    ){
        if(!movieRepositorio.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        
        updateMovie.setId(id);
        
        Movie save = movieRepositorio.save(updateMovie);
        
        return ResponseEntity.ok(save);
    }
    
    @CrossOrigin
    @PutMapping("/vote/{id}/{rating}")
    public ResponseEntity<Movie> voteMovie(
            @PathVariable Long id, @PathVariable double rating
    ){
        if(!movieRepositorio.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        
        Optional<Movie> findById = movieRepositorio.findById(id);
        
        Movie movie = findById.get();
        
        double newRating = ((movie.getVotes() * movie.getRating())+rating)/(movie.getVotes()+1);
        
        movie.setVotes(movie.getVotes() + 1);
        movie.setRating(newRating);
        
        Movie save = movieRepositorio.save(movie);
        
        return ResponseEntity.ok(save);
    }
}
