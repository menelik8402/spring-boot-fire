package com.spring.spring_boot_fire.Service;

import com.spring.spring_boot_fire.Entity.Person;
import com.spring.spring_boot_fire.Entity.PersonOlder;
import com.spring.spring_boot_fire.Repository.PersonOlderRepository;
import com.spring.spring_boot_fire.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonOlderService {

    @Autowired
    private  PersonOlderRepository personOlderRepository;

    public PersonOlderRepository getPersonRepository() {
        return this.personOlderRepository;
    }

    public void setPersonRepository(PersonOlderRepository personOlderRepository) {
        this.personOlderRepository = personOlderRepository;
    }

    public List<PersonOlder> getAllPersonsOlder(){
        return  this.personOlderRepository.findAll();
    }

    public Optional<PersonOlder> getPersonOlderById(String id){
        return this.personOlderRepository.findById(id);
    }

    public void saveOrUpdatePerson(PersonOlder personOlder){
        this.personOlderRepository.save(personOlder);
    }

    public void deletePerson(String id){
        this.personOlderRepository.deleteById(id);
    }
}
