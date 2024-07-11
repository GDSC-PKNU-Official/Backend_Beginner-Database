package com.example.Backend_Beginner2.controller;

import com.example.Backend_Beginner2.domain.Enrollment;
import com.example.Backend_Beginner2.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}/enrollments")
    public ResponseEntity<List<Enrollment>> getEnrollments(@PathVariable int studentId) {
        List<Enrollment> enrollments = studentService.getEnrollments(studentId);
        return ResponseEntity.ok(enrollments);
    }

    @PostMapping("/{studentId}/enrollments/{courseId}")
    public ResponseEntity<Enrollment> enrollStudent(@PathVariable int studentId, @PathVariable int courseId) {
        Enrollment enrollment = studentService.enrollStudent(studentId, courseId);
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }

    @DeleteMapping("/enrollments/{enrollmentId}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable int enrollmentId) {
        studentService.deleteEnrollment(enrollmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
