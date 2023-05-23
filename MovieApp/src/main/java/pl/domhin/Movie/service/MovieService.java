package pl.domhin.Movie.service;

import org.springframework.stereotype.Service;
import pl.domhin.Movie.model.Movie;
import pl.domhin.Movie.repositories.MovieRepository;

import java.util.ArrayList;

@Service
public class MovieService {
    private ArrayList<Movie> movies;
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        movies = new ArrayList<>();
        movies.add(new Movie("Billie", "Action"));
        movies.add(new Movie("Jones", "Adventure"));

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
//        movie.setId(String.valueOf(Math.random()));
        movies.add(movie);

    }

    public Movie changeMovieAvailable(Integer id, Boolean newValue){
        Movie foundMovie = movieRepository.findMovie(id);
        foundMovie.setAvailable(newValue);
        movieRepository.save(foundMovie);

        return foundMovie;
    }

    public void removeMovie(String id){
        for(Movie movie: movies){
            if(movie.getId().equals(id)){
                movies.remove(movie);
            }
        }
    }

}

