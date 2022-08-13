package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id;
    private String name;
    private LocalDate date;
    private Integer age;
    private String email;

    public Student() {
    }

    public Student(Long id, String name, LocalDate date, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
