package com.example.bd.Controller;

import com.example.bd.Entity.Student;
import com.example.bd.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // 학생 추가 (POST 요청 처리)
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student added successfully";
    }

    // 학생 조회 (GET 요청 처리)
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // 학생 삭제 (DELETE 요청 처리)
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        studentRepository.delete(student);
        return "Student deleted successfully";
    }
}