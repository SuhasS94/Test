package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull
    @Min(value = 18,message = "Min age is 18")
    private int age;

    @NotEmpty
    @Size(min = 3,message = "Min of 3 words required")
    private String name;

    @Email
    private String email;

    private String surname;

    public Student(int age, String name, String email, String surname) {
        this.name = name;
        this.email=email;
        this.age = age;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}