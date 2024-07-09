package com.spring.spring_boot_fire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idhotel;
    private int category;

    @OneToOne
    @JoinColumn(
            name = "address_id"
    )
    private Address address;

    @OneToOne
    @JoinColumn(
            name = "trip_id"
    )
    private Trip trip;
}
