package com.javatechie;

import com.javatechie.Entity.Person;
import com.javatechie.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController()
public class JavaTechieApplication {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/get/{personId}")
    public Person getPersonById(@PathVariable String personId) {
        return repository.getPersonById(personId);
    }

    @PostMapping("/save")
    public Person savePerson(@RequestBody  Person person) {
        return repository.save(person);
    }

    @DeleteMapping("/delete/{personId}")
    public String deletePerson(@PathVariable String personId) {
        return repository.deletePerson(personId);
    }

    @PutMapping("/update")
    public String updatePerson(@RequestBody Person person) {
        return repository.updatePerson(person);
    }
    public static void main(String[] args) {
        SpringApplication.run(JavaTechieApplication.class, args);
    }

}
