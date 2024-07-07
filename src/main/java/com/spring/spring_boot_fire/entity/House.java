package com.spring.spring_boot_fire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idHouse;
    private int id_address;
    private String color;

    @ManyToMany(mappedBy = "houseList")
    private List<Person> personList;

    @OneToOne
    @JoinColumn(
            name = "address_id"
    )
    private Address address;

}
