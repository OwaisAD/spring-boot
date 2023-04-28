package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(new Student(1L, "Owais", "owais@live.dk", LocalDate.of(1998, Month.NOVEMBER,1), 24));
    }
}
