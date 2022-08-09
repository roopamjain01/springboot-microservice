package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudent() {
        return List.of(
            new Student(
                1L,
                "Roopam Jain",
                LocalDate.of(2000, 06, 22),
                22,
                "roopamjain01@gmail.com"
            )
        );
    }
}
