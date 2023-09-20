package demo.mssql;

import demo.mssql.db.Animal;
import demo.mssql.db.AnimalRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private AnimalRepository animalRepository;

    public TestController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Animal>> testDb(){
        animalRepository.findAll().iterator().forEachRemaining(System.out::println);
        return ResponseEntity.ok(animalRepository.findAll());
    }
}
