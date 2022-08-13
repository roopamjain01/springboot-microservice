package com.example.demo.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student roopam = new Student(
                1L,
                "Roopam",
                LocalDate.of(1990, 05, 22),
                "roopamjain01@gmail.com"
            );

            Student lovesh = new Student(
                2L,
                "Lovesh",
                 LocalDate.of(1988, 05, 21),
                "roopamjain01@gmail.com"
            );

            repository.saveAll(
                List.of(roopam, lovesh)
            );
        };
    }
}
