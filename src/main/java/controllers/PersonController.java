package controllers;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.PersonRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/people")
    public Person createPerson(@RequestBody Person p) {
        return personRepository.save(p);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        personRepository.findOne(id);
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        personRepository.findAll();
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable long id) {
            return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id) {
        personRepository.delete(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }
}
