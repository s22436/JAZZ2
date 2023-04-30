package pl.domhin.Movie.service;

import org.springframework.stereotype.Service;
import pl.domhin.Movie.model.Movie;

import java.util.ArrayList;

@Service
public class MovieService {
    private ArrayList<Movie> movies;

    public MovieService(){
        movies = new ArrayList<>();
        movies.add(new Movie("Billie", "123", "Action"));
        movies.add(new Movie("Jones", "133", "Adventure"));

    }


    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public Movie getMovie(String id){
        for(Movie movie: movies){
            if(movie.getId().equals(id)){
                return movie;
            }
        }

        return null;
    }

    public void addMovie(Movie movie){
        movie.setId(String.valueOf(Math.random()));
        movies.add(movie);
    }

    public void removeMovie(String id){
        for(Movie movie: movies){
            if(movie.getId().equals(id)){
                movies.remove(movie);
            }
        }
    }

}

