package com.spring.spring_boot_fire.controller;

import com.spring.spring_boot_fire.entity.Person;
import com.spring.spring_boot_fire.service.PersonService;
import com.spring.spring_boot_fire.model.PersonRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/personas")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping
    public List<Person> getAll(){
        return this.personService.getAllPersons();
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody PersonRequest personRequest){
            return this.personService.savePerson(personRequest);
    }

    @PutMapping
    public ResponseEntity<Person> Update(@RequestBody PersonRequest personRequest){
        return this.personService.UpdatePerson(personRequest);
    }


    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable("personId") Long personId){
        return this.personService.deletePerson(personId);
    }

    @GetMapping("/{personId}")
    public Optional<Person> getPersonById(@PathVariable("personId") Long personId){
        return this.personService.getPersonById(personId);
    }
}
