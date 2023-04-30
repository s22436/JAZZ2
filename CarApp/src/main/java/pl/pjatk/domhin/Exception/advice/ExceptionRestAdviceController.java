package pl.pjatk.domhin.Exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestAdviceController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> errorHandler(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("AN ERROR OCCURRED: " + ex);
    }
}
