package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail= studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email is already exist");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExist = studentRepository.existsById(studentId);

        if (!studentExist) {
            throw new IllegalStateException("Student with id: " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name)
    {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(
                ()-> new IllegalStateException("Student with id: " + studentId + " does not exists")
            );

        student.setName(name);
    }
}
