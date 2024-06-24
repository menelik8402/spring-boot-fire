package com.spring.spring_boot_fire.service;

import com.spring.spring_boot_fire.entity.Person;
import com.spring.spring_boot_fire.entity.PersonOlder;
import com.spring.spring_boot_fire.repository.PersonRepository;
import com.spring.spring_boot_fire.mapper.PersonMapper;
import com.spring.spring_boot_fire.model.PersonRequest;
import com.spring.spring_boot_fire.utils.JsonUtils;
import lombok.Data;
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

    public PersonService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<Person> getAllPersons(){
        return  this.personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return this.personRepository.findById(id);
    }

    @Async
    @EventListener
    public ResponseEntity<Person> savePerson(PersonRequest personRequest){
        if(personRequest.age() > 100){
            //Enviar mensaje al topic de kafka
            PersonOlder personOlder =this.personMapper.personRequestPersonOlder(personRequest);
            this.kafkaTemplate.send("Person-Topics", JsonUtils.toJson(personOlder));
        }

        Person person = this.personMapper.personRequestToPerson(personRequest);
        person = this.personRepository.save(person);
        return ResponseEntity.ok(person);
    }
    public ResponseEntity<Person> UpdatePerson(PersonRequest personRequest){
        Person person = this.personMapper.personRequestToPerson(personRequest);
        person = this.personRepository.save(person);
        return ResponseEntity.ok(person);
    }

    public ResponseEntity<String> deletePerson(Long id){
        this.personRepository.deleteById(id);
        return new ResponseEntity<>("Person was deleted succefully", HttpStatus.OK);
    }
}
