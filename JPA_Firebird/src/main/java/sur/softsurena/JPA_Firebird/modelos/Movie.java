package sur.softsurena.JPA_Firebird.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author jhironsel
 */
@Entity
@Table(name = "movies")
@Data
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, length = 300, nullable = false)
    private String title;
    
    @Column(name="year_", nullable = false)
    private int year;
    
    private int votes;
    private double rating;
    
    @Column(name = "image_url", nullable = true)
    private String imageUrl;
    
}
