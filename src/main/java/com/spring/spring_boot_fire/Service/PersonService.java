package com.spring.spring_boot_fire.Service;

import com.spring.spring_boot_fire.Entity.Person;
import com.spring.spring_boot_fire.Repository.PersonRepository;
//import com.spring.spring_boot_fire.event.PersonPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

//    @Autowired
//    PersonPublisher personPublisher;

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

    public void saveOrUpdatePerson(Person person){
//        if(person.getAge() > 100 ){
//            PersonRegisteredEvent personRegisteredEvent = new PersonRegisteredEvent(
//                    person.getCi(),
//                    person.getAge(),
//                    person.getAddress()!= null ? person.getAddress() : null,
//                    person.getPicture()!= null ? person.getPicture() : null
//            );
//            personPublisher.publisherPersonRegisteredEvent(personRegisteredEvent);
//        }
        this.personRepository.save(person);
    }

    public void deletePerson(Long id){
        this.personRepository.deleteById(id);
    }
}
