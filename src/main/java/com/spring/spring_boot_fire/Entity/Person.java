package com.spring.spring_boot_fire.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
}
