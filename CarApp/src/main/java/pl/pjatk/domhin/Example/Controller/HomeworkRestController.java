package pl.pjatk.domhin.Example.Controller;


import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/homework")
public class HomeworkRestController {


    @GetMapping("/{somePath}")
    public ResponseEntity<String> genericPingPathReturn(@PathVariable(required = false) String somePath){
        return ResponseEntity.ok(somePath);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<String> genericPingParamReturn(@RequestParam Map<String,String> allParams){
        return ResponseEntity.ok(allParams.entrySet().toString());
    }

    @PutMapping("/{somePath}")
    public ResponseEntity<String> genericPutReturn(@PathVariable String somePath, @RequestBody String params){
        return ResponseEntity.ok("Have put withing the path: " + somePath + ", an object of: " + params);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<String> genericPostReturn(@RequestBody String params){
        return ResponseEntity.ok("Have posted params: " + params);
    }

    @DeleteMapping("/{somePath}")
    public ResponseEntity<Void> genericDeleteReturn(@PathVariable String somePath){
        return ResponseEntity.status(200).build();
    }
}
