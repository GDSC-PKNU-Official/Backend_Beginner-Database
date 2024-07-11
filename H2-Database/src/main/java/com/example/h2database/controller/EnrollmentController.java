package com.example.h2database.controller;

import com.example.h2database.domain.Course;
import com.example.h2database.domain.Enrollment;
import com.example.h2database.domain.Student;
import com.example.h2database.repository.CourseRepository;
import com.example.h2database.repository.EnrollmentRepository;
import com.example.h2database.repository.StudentRepository;
import com.example.h2database.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class EnrollmentController {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService, StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.enrollmentService = enrollmentService;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<String> createEnrollment(@PathVariable int studentId, @PathVariable int courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 학생을 찾을 수 없습니다: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 과목을 찾을 수 없습니다: " + courseId));
        Enrollment enrollment = new Enrollment(student, course, new Date());
        enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.ok("수강 과목 추가 완료");
    }

@DeleteMapping("/{studentId}/courses/{courseId}")
public ResponseEntity<String> cancelEnrollment(@PathVariable int studentId, @PathVariable int courseId) {
    Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 학생을 찾을 수 없습니다: " + studentId));

    Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 과목을 찾을 수 없습니다: " + courseId));

    enrollmentService.cancelEnrollment(student, course);

    return ResponseEntity.ok("수강 과목 삭제 완료");
}

@GetMapping("/{studentId}/courses")
public List<Enrollment>getEnrolledCourses(@PathVariable int studentId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 학생을 찾을 수 없습니다: " + studentId));
        return student.getEnrollments();
    }



}
