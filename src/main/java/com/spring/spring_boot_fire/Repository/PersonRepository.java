package com.spring.spring_boot_fire.Repository;

import com.spring.spring_boot_fire.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
