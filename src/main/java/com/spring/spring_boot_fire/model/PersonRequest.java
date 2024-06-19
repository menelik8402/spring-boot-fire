package com.spring.spring_boot_fire.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PersonRequest(String name, int age, String ci, String address, String picture) {

    @JsonCreator
    public PersonRequest(
            @JsonProperty(value = "name", required = true) String name,
            @JsonProperty(value = "age", required = true) int age,
            @JsonProperty(value = "ci", required = true) String ci,
            @JsonProperty(value = "address", required = false) String address,
            @JsonProperty(value = "picture", required = false) String picture) {

        this.name = name;
        this.age = age;
        this.ci = ci;
        this.address = address;
        this.picture = picture;
    }
}
