package com.example.demo.config;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int age;
    private String name;
    @Transient
    private String status;
    private String email;
    private String surname;
    public Student(int age, String name, String email, String surname) {
        this.name = name;
        this.email=email;
        this.age = age;
        this.surname = surname;
    }
}