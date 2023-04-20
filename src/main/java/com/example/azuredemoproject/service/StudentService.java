package com.example.azuredemoproject.service;

import com.example.azuredemoproject.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public Map<String, Student> studentmap = new HashMap<>();

    public List<Student> getAllStudent() {
        return studentmap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
    }

    public Student getStudent(String studentId) {
        return studentmap.getOrDefault(studentId, new Student());
    }
    public Student createStudent(Student student) {
        student.setSid(UUID.randomUUID().toString());
        studentmap.put(student.getSid(), student);
        return student;
    }
}
