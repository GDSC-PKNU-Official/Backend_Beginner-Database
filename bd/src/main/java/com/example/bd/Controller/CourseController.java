package com.example.bd.Controller;

import com.example.bd.Entity.Course;
import com.example.bd.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // 과목 추가 (POST 요청 처리)
    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return "Course added successfully";
    }

    // 과목 조회 (GET 요청 처리)
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    // 과목 삭제 (DELETE 요청 처리)
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        courseRepository.delete(course);
        return "Course deleted successfully";
    }
}