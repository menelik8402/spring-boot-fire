package com.spring.spring_boot_fire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idTrip;
    private int id_hotel;
    private Date date;

    @ManyToMany(mappedBy = "tripList")
    private List<Person> personList;

    @OneToOne
    @JoinColumn(
            name = "address_id"
    )
    private Address address;

    @OneToOne(
            mappedBy = "trip"
    )
    private Hotel hotel;


}
