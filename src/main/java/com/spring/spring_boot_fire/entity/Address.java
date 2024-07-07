package com.spring.spring_boot_fire.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idAddress;
    private String state;
    private String country;
    private String province;

    @ManyToMany(mappedBy = "addressList")
    private List<Person> personList;

    @OneToOne(
            mappedBy = "address"
    )
    private Trip trip;

    @OneToOne(
            mappedBy = "address"
    )
    private Hotel hotel;

    @OneToOne(
            mappedBy = "address"
    )
    private House house;
}
