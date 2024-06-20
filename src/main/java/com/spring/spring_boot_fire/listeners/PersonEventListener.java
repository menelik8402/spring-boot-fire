package com.spring.spring_boot_fire.listeners;

import com.spring.spring_boot_fire.Entity.PersonOlder;
import com.spring.spring_boot_fire.Service.PersonOlderService;
import com.spring.spring_boot_fire.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PersonEventListener {

    @Autowired
    PersonOlderService personOlderService;

    @KafkaListener(topics = "Person-Topics", groupId = "test-")
    public void handleMessageFromKafka(String msg){
        PersonOlder personOlder = JsonUtils.fromJson(msg,PersonOlder.class);
        personOlderService.saveOrUpdatePerson(personOlder);
    }
}
