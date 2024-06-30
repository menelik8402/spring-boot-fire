package com.spring.spring_boot_fire.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data   //todo: quedamos que no usaremos @Data
@Setter
@Getter
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
