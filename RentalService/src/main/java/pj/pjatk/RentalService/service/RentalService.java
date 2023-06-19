package pj.pjatk.RentalService.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import pj.pjatk.RentalService.model.Movie;

@Service
public class RentalService {
    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Integer id){
        ResponseEntity<Movie> response = restTemplate.getForEntity("http://localhost:8082/movies/" + id, Movie.class);
        if(response.getStatusCode() != HttpStatus.OK){
            throw new ResponseStatusException(response.getStatusCode());
        }
        return response.getBody();
    }

    public void returnMovie(Integer id) {
        Movie someMovie = new Movie();
        someMovie.setAvailable(true);
        HttpEntity<Movie> entity = new HttpEntity<>(someMovie);
        ResponseEntity response = restTemplate.exchange("http://localhost:8082/movies/change-available/" + id, HttpMethod.PUT, entity, Void.class);

        if(response.getStatusCode() != HttpStatus.OK){
            throw new ResponseStatusException(response.getStatusCode());
        }
    }

    public void rentMovie(Integer id) {
        Movie someMovie = new Movie();
        someMovie.setAvailable(false);
        HttpEntity<Movie> entity = new HttpEntity<>(someMovie);
        ResponseEntity response = restTemplate.exchange("http://localhost:8082/movies/change-available/" + id, HttpMethod.PUT, entity, Void.class);

        if(response.getStatusCode() != HttpStatus.OK){
            throw new ResponseStatusException(response.getStatusCode());
        }
    }
}