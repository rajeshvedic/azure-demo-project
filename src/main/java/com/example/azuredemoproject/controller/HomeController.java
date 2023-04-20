package com.example.azuredemoproject.controller;

import com.example.azuredemoproject.model.Student;
import com.example.azuredemoproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class HomeController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List> getAllStudent() {
    return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getAllStudent(@PathVariable("studentId") String studentId) {
        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Student> getAllStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.OK);
    }
}
