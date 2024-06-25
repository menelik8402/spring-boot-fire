package com.spring.spring_boot_fire.service;

import com.spring.spring_boot_fire.entity.PersonOlder;
import com.spring.spring_boot_fire.repository.PersonOlderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonOlderService {

   private  PersonOlderRepository personOlderRepository;

    public PersonOlderService(PersonOlderRepository personOlderRepository) {
        this.personOlderRepository = personOlderRepository;
    }

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
