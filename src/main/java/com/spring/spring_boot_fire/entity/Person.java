package com.spring.spring_boot_fire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idPerson;
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String ci;

    @ManyToMany
    @JoinTable(
            name = "person_has_address",
            joinColumns = @JoinColumn(name = "people_idperson"),
            inverseJoinColumns = @JoinColumn(name = "address_idaddress")
    )
    private List<Address> addressList;

    @ManyToMany
    @JoinTable(
            name = "person_has_trip",
            joinColumns = @JoinColumn(name = "people_idperson"),
            inverseJoinColumns = @JoinColumn(name = "trip_idtrip")
    )
    private List<Trip> tripList;

    @ManyToMany
    @JoinTable(
            name = "person_has_house",
            joinColumns = @JoinColumn(name = "people_idperson"),
            inverseJoinColumns = @JoinColumn(name = "house_idhouse")
    )
    private List<House> houseList;

}
