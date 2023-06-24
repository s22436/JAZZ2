package pl.domhin.Movie.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.domhin.Movie.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select * from MOVIES where id = ?1", nativeQuery = true)
    Movie findMovie(Integer id);

    @Query(value = "select * from MOVIES", nativeQuery = true)
    List<Movie> findMovies();

    @Query(value = "INSERT INTO MOVIES(NAZWA, KATEGORIA, isAvailable) VALUES(?1, ?2, 0)", nativeQuery = true)
    @Transactional
    @Modifying
    void addMovie(String name, String category);

    @Query(value = "UPDATE MOVIES SET NAZWA=?1, KATEGORIA=?2 WHERE id = ?3", nativeQuery = true)
    @Transactional
    @Modifying
    void updateMovie(String name, String category, Integer id);

    @Query(value = "UPDATE MOVIES SET isAvailable=?1 WHERE id = ?2", nativeQuery = true)
    @Transactional
    @Modifying
    void updateMovieAvailable(boolean isAvailable, Integer id);
}
