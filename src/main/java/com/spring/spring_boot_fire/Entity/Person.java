package com.spring.spring_boot_fire.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idPerson;

    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String ci;

}
