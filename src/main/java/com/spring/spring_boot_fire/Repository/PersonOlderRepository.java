package com.spring.spring_boot_fire.Repository;

import com.spring.spring_boot_fire.Entity.PersonOlder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonOlderRepository  extends MongoRepository<PersonOlder,String> {
}
