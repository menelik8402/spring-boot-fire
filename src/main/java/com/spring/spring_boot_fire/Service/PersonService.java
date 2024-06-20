package com.spring.spring_boot_fire.Service;

import com.spring.spring_boot_fire.Entity.Person;
import com.spring.spring_boot_fire.Entity.PersonOlder;
import com.spring.spring_boot_fire.Repository.PersonRepository;
import com.spring.spring_boot_fire.mapper.PersonMapper;
import com.spring.spring_boot_fire.model.PersonRequest;
import com.spring.spring_boot_fire.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper ;

    private final KafkaTemplate<String,String> kafkaTemplate;

    public PersonService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public PersonRepository getPersonRepository() {
        return this.personRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return  this.personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return this.personRepository.findById(id);
    }

    @Async
    @EventListener
    public void saveOrUpdatePerson(PersonRequest personRequest){
        if(personRequest.age() > 100){
            //Enviar mensaje al topic de kafka
            PersonOlder personOlder =this.personMapper.personRequestPersonOlder(personRequest);
            this.kafkaTemplate.send("Person-Topics", JsonUtils.toJson(personOlder));
        }

        Person person = this.personMapper.personRequestToPerson(personRequest);
        this.personRepository.save(person);
    }

    public void deletePerson(Long id){
        this.personRepository.deleteById(id);
    }
}
