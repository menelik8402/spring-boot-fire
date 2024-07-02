package com.spring.spring_boot_fire.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "cl_person")
@Setter
@Getter
public class PersonOlder {

    private String ci;
    private int age;
    private String address;
    private String picture;

}
