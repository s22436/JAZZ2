package pl.pjatk.domhin.Exception.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exception")
public class ExceptionRestController {

    @GetMapping(value = {"","/"})
    public ResponseEntity<String> someEndpoint(){
        throw new RuntimeException();
    }


}
