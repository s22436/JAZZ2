package pl.domhin.Movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.domhin.Movie.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select m from MOVIES m where m.id = ?1")
    Movie findMovie(Integer id);

    @Query(value = "select * from MOVIES", nativeQuery = true)
    List<Movie> findMovies();

}
