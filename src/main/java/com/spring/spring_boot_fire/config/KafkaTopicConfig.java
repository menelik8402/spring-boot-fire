package com.spring.spring_boot_fire.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic personKafkaTopic(){
        return TopicBuilder.name("Person-Topics")
                .build();
    }
}
