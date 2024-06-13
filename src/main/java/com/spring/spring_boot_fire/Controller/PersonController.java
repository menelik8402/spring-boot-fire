package com.spring.spring_boot_fire.Controller;

import com.spring.spring_boot_fire.Entity.Person;
import com.spring.spring_boot_fire.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping
    public List<Person> getAll(){
        return this.personService.getAllPersons();
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody Person person){
        this.personService.saveOrUpdatePerson(person);
    }
    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable("personId") Long personId){
        this.personService.deletePerson(personId);
    }
    @GetMapping("/{personId}")
    public Optional<Person> getPersonById(@PathVariable("personId") Long personId){
        return this.personService.getPersonById(personId);
    }
}
