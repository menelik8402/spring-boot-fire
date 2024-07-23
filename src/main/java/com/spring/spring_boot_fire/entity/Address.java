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
    @Column(name = "id_Address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idAddress;
    private String country;
    private String province;
    private String municipality;
    private String details;

    @ManyToMany(mappedBy = "addressList")
    private List<Person> personList;

    @OneToOne(
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Trip trip;

    @OneToOne(
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Hotel hotel;

    @OneToOne(
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private House house;
}
