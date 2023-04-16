package pl.pjatk.domhin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class ExampleRestController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld(@RequestParam(required = false) String reqParam){
        if(reqParam != null){
            return ResponseEntity.ok(reqParam);
        }
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> getCustomHelloWorld(@PathVariable String someValue){
        return ResponseEntity.ok(someValue);
    }

    @GetMapping("/model")
    public ResponseEntity<String> getCar(){
        return ResponseEntity.ok(new Car("Corolla", "Toyota", "2323213").toString());
    }

    @PostMapping("/model")
    public ResponseEntity<String> createCar(@RequestBody Car car){
        return ResponseEntity.ok(car.toString());
    }



}
