package com.example.demo.controller;


import com.example.demo.domain.Enrollment;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}/enrollments")
    public List<Enrollment> getEnrollments(@PathVariable int studentId){
        return studentService.getEnrollments(studentId);
    }

    @PostMapping("/{studentId}/{courseId}")
    public Enrollment addEnrollment(@PathVariable int studentId, @PathVariable int courseId){
        return studentService.addEnrollment(studentId,courseId);
    }

    @DeleteMapping("/{enrollmentId}")
    public void deleteEnrollment(@PathVariable int enrollmentId){
        studentService.deleteEnrollment(enrollmentId);
    }



}
