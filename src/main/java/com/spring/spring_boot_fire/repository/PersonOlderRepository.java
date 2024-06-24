package com.spring.spring_boot_fire.repository;

import com.spring.spring_boot_fire.entity.PersonOlder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonOlderRepository  extends MongoRepository<PersonOlder,String> {
}
