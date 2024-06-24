package com.spring.spring_boot_fire.repository;

import com.spring.spring_boot_fire.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Long> {

}
