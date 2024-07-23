package com.spring.spring_boot_fire.controller;

import com.spring.spring_boot_fire.entity.Person;
import com.spring.spring_boot_fire.service.PersonService;
import com.spring.spring_boot_fire.model.PersonRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
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

    @GetMapping("/list/country/{country}")
    public ResponseEntity<List<PersonRequest>> getListOfPersonsToTrip(@PathVariable("country") String country){
        return this.personService.getListOfPeopleTripTo(country);
    }

    @GetMapping("/list/category/{category}")
    public ResponseEntity<List<PersonRequest>> getListOfPersonsStayHotelTo(@PathVariable("category") int category){
        return this.personService.getListOfPeopleStayTopHotelTo(category);
    }

    @GetMapping("/list/color/{color}")
    public ResponseEntity<Integer> getCountPeopleBlueHouses(@PathVariable("color") String color){
        return this.personService.getCountBlueHouses(color);
    }

    @GetMapping("/list/bypeople/{country}/{category}/{province}/{yearini}/{yearfinal}")
    public ResponseEntity<List<PersonRequest>> getListOfPeopleTripToStayHotelHouses(
            @PathVariable("country") String country,
            @PathVariable("category") int category,
            @PathVariable("province") String province,
            @PathVariable("yearini") String yearini,
            @PathVariable("yearfinal") String yearfinal){
        return this.personService.getListOfPeopleTripToStayHotelHouses(country,category,province,yearini,yearfinal);
    }


}
