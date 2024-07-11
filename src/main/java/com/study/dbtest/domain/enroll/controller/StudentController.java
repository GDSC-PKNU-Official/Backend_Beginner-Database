package com.study.dbtest.domain.enroll.controller;

import com.study.dbtest.domain.enroll.dto.request.StudentRequestDto;
import com.study.dbtest.domain.enroll.dto.response.StudentCoursesResDto;
import com.study.dbtest.domain.enroll.service.EnrollmentService;
import com.study.dbtest.domain.enroll.service.StudentService;
import com.study.dbtest.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create/students")
    public int addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.save(studentRequestDto);
    }

    @GetMapping("/get/students/{id}")
    public Student findById(@PathVariable int id){
        return studentService.findById(id);
    }

    @DeleteMapping("/delete/students/{id}")
    public String deleteById(@PathVariable int id) {
        return studentService.deleteById(id);
    }

    @GetMapping("/get/students/{id}/courses")
    public List<StudentCoursesResDto> getCoursesFromStudent(@PathVariable int id) {
        return studentService.getCoursesFromStudent(id);
    }
}
