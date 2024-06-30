package com.spring.spring_boot_fire.controller;

import com.spring.spring_boot_fire.entity.Person;
import com.spring.spring_boot_fire.service.PersonService;
import com.spring.spring_boot_fire.model.PersonRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//todo: imports sin limpiar

//todo: el fichero README.md despues se debe hacer, pero de momento deja agregado el link del swagger

@RestController
@RequestMapping(path = "api/v1/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping     //todo: esto no es correcto de ser @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        return this.personService.getAllPersons();
    }

    @PostMapping
    public ResponseEntity<PersonRequest> save(@RequestBody PersonRequest personRequest){
            return this.personService.savePerson(personRequest);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<PersonRequest> Update(@PathVariable(value = "id") Long personId ,@RequestBody PersonRequest personRequest){
        return this.personService.updatePerson(personId,personRequest);
    }


    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable("personId") Long personId){
        return this.personService.deletePerson(personId);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable("personId") Long personId){
        return this.personService.getPersonById(personId);
    }
}
