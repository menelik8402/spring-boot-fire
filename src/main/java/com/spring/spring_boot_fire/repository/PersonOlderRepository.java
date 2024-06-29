package com.spring.spring_boot_fire.repository;

import com.spring.spring_boot_fire.entity.PersonOlder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonOlderRepository  extends MongoRepository<PersonOlder,String> {
}
