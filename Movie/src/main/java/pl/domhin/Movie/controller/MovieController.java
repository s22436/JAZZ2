package pl.domhin.Movie.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.domhin.Movie.model.AvailableMovieUpdateRequest;
import pl.domhin.Movie.model.Movie;
import pl.domhin.Movie.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Movie>>getMovies(){
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id){
        Movie movie = movieService.getMovie(id);
        if(movie == null){
            throw new NullPointerException("MOVIE NOT FOUND");
        }
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createMovie(@RequestBody Movie movie) {
        if(movie.getCategory() == null || movie.getName() == null){
            throw new NullPointerException("INVALID INPUT FIELDS");
        }
        movieService.addMovie(movie);

        return ResponseEntity.ok(null);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
        Movie oldMovie = movieService.getMovie(id);
        if(oldMovie == null){
            throw new RuntimeException("MOVIE NOT FOUND");
        }

        movieService.updateMovie(oldMovie, movie);

        return ResponseEntity.ok(null);

    }

    @PutMapping("/change-available/{id}")
    public ResponseEntity<Void> updateMoveAvailable(@RequestBody Movie updatedMovie, @PathVariable Integer id) {
        movieService.changeMovieAvailable(id, updatedMovie.isAvailable());

        return ResponseEntity.ok(null);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Movie movieToUpdate = movieService.getMovie(id);
        if(movieToUpdate == null){
            throw new RuntimeException("MOVIE NOT FOUND");
        }

//        movieService.removeMovie(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
