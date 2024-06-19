package com.spring.spring_boot_fire.Controller;

import com.spring.spring_boot_fire.Entity.Person;
import com.spring.spring_boot_fire.Entity.PersonOlder;
import com.spring.spring_boot_fire.Service.PersonOlderService;
import com.spring.spring_boot_fire.Service.PersonService;
import com.spring.spring_boot_fire.mapper.PersonMapper;
import com.spring.spring_boot_fire.model.PersonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonOlderService personOlderService;

    @Autowired
    private  PersonMapper personMapper ;

    @RequestMapping
    public List<Person> getAll(){
        return this.personService.getAllPersons();
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody PersonRequest personRequest){
        Person person = this.personMapper.personRequestToPerson(personRequest);
        if(person.getAge() > 100){
            PersonOlder personOlder = this.personMapper.personRequestPersonOlder(personRequest);
            this.personOlderService.saveOrUpdatePerson(personOlder);
        }
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
