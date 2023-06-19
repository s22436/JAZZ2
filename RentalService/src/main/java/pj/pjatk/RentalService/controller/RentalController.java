package pj.pjatk.RentalService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pj.pjatk.RentalService.model.Movie;
import pj.pjatk.RentalService.service.RentalService;

@RestController
@RequestMapping("/rental")
public class RentalController {

    private final RentalService rentalService;


    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id){
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PostMapping(value = "/return/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable Integer id){
        rentalService.returnMovie(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "/rent/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable Integer id){
        rentalService.rentMovie(id);
        return ResponseEntity.ok(null);
    }

}
