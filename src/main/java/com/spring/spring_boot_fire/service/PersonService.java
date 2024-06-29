package com.spring.spring_boot_fire.service;

import com.spring.spring_boot_fire.entity.Person;
import com.spring.spring_boot_fire.entity.PersonOlder;
import com.spring.spring_boot_fire.repository.PersonRepository;
import com.spring.spring_boot_fire.mapper.PersonMapper;
import com.spring.spring_boot_fire.model.PersonRequest;
import com.spring.spring_boot_fire.utils.JsonUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data

@Service
public class PersonService {

    private PersonRepository personRepository;

    private PersonMapper personMapper ;

    private final KafkaTemplate<String,String> kafkaTemplate;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper, KafkaTemplate<String, String> kafkaTemplate) {
       this.personRepository = personRepository;
       this.personMapper = personMapper;
       this.kafkaTemplate = kafkaTemplate;
    }



    public ResponseEntity<List<Person>> getAllPersons(){
        //return  this.personRepository.findAll();
        return new ResponseEntity<List<Person>>(this.personRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Person> getPersonById(Long id){
        //return this.personRepository.findById(id);
        if(this.personRepository.findById(id).isPresent())
            return new ResponseEntity<Person>(this.personRepository.findById(id).get(), HttpStatus.OK);
        else
            return new ResponseEntity<Person>(new Person(),HttpStatus.BAD_REQUEST);
    }

    @Async
    @EventListener
    public ResponseEntity<PersonRequest> savePerson(PersonRequest personRequest){
        PersonOlder personOlder =this.personMapper.personRequestPersonOlder(personRequest);
        if(personRequest.age() > 100){
            //Enviar mensaje al topic de kafka
            this.kafkaTemplate.send("Person-Topics", JsonUtils.toJson(personOlder));
        }
        Person person = this.personMapper.personRequestToPerson(personRequest);
        person = this.personRepository.save(person);
        return new ResponseEntity<PersonRequest>(this.personMapper.buildPersonRequest(person,personOlder),null,HttpStatus.CREATED);
    }

    public ResponseEntity<PersonRequest> updatePerson(Long personId,PersonRequest personRequest){
        Optional<Person> findPerson = this.personRepository.findById(personId);
        Person person = this.personMapper.personRequestToPerson(personRequest);
        PersonOlder personOlder =this.personMapper.personRequestPersonOlder(personRequest);
        if (findPerson.isPresent()) {
            person.setIdPerson(findPerson.get().getIdPerson());
            person = this.personRepository.save(person);
            return new ResponseEntity<PersonRequest>(this.personMapper.buildPersonRequest(person,personOlder),null,HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<String> deletePerson(Long id){
        this.personRepository.deleteById(id);
        return new ResponseEntity<>("Person was deleted succefully", HttpStatus.OK);
    }
}
