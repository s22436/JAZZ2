package pl.domhin.Movie.service;

import org.springframework.stereotype.Service;
import pl.domhin.Movie.model.Movie;
import pl.domhin.Movie.repositories.MovieRepository;

import java.util.ArrayList;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public ArrayList<Movie> getMovies() {
        return new ArrayList<>(movieRepository.findMovies());
    }

    public Movie getMovie(Integer id){
        Movie foundMovie = movieRepository.findMovie(id);
//                .orElseThrow(RuntimeException::new);
        return foundMovie;
    }

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie.getName(), movie.getCategory());

    }

    public void changeMovieAvailable(Integer id, Boolean newValue){
        movieRepository.updateMovieAvailable(newValue, id);
    }

    public void updateMovie(Movie oldMovie, Movie newMovie){
        movieRepository.updateMovie(
                newMovie.getName() != null ? newMovie.getName() : oldMovie.getName(),
                newMovie.getCategory() != null ? newMovie.getCategory() : oldMovie.getCategory(),
                oldMovie.getId());
    }

    public void removeMovie(String id){

    }

}

