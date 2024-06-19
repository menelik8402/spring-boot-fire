package com.spring.spring_boot_fire.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.spring.spring_boot_fire.Entity.Person;
import com.spring.spring_boot_fire.Entity.PersonOlder;
import com.spring.spring_boot_fire.model.PersonRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person personRequestToPerson(PersonRequest personRequest){
        Person person = new Person();
            person.setName(personRequest.name());
            person.setCi(personRequest.ci());
            person.setAge(personRequest.age());
        return person;
    }

    public  PersonOlder personRequestPersonOlder (PersonRequest personRequest){
         PersonOlder personOlder =new PersonOlder();
         personOlder.setCi(personRequest.ci());
         personOlder.setAge(personRequest.age());
         if(personRequest.address() !=null )
             personOlder.setAddress(personRequest.address());
         if(personRequest.picture() !=null )
            personOlder.setPicture(personRequest.picture());

         return personOlder;
    }

}
