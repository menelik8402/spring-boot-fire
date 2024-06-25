package com.spring.spring_boot_fire.listeners;

import com.spring.spring_boot_fire.entity.PersonOlder;
import com.spring.spring_boot_fire.service.PersonOlderService;
import com.spring.spring_boot_fire.utils.JsonUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PersonEventListener {


    PersonOlderService personOlderService;

    public PersonEventListener(PersonOlderService personOlderService) {
        this.personOlderService = personOlderService;
    }

    @KafkaListener(topics = "Person-Topics", groupId = "test-")
    public void handleMessageFromKafka(String msg){
        PersonOlder personOlder = JsonUtils.fromJson(msg,PersonOlder.class);
        personOlderService.saveOrUpdatePerson(personOlder);
    }


}
