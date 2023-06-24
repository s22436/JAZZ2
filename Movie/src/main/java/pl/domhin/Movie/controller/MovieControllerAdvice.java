package pl.domhin.Movie.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> errorNullHandler(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("AN ERROR OCCURRED: " + ex);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> errorRuntimeHandler(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AN ERROR OCCURRED: " + ex);
    }
}

