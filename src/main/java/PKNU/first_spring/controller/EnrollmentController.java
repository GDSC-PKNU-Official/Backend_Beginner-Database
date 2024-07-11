package PKNU.first_spring.controller;
import PKNU.first_spring.domain.Enrollment;
import PKNU.first_spring.domain.Student;
import PKNU.first_spring.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    EnrollmentService enrollmentService;
    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/{student-id}/{course-id}")
    public ResponseEntity<Enrollment> addEnrollment(@PathVariable("student-id") Long studentId, @PathVariable("course-id") Long courseId) {
        Enrollment enrollment = enrollmentService.addEnrollment(studentId, courseId);
        return ResponseEntity.ok(enrollment);
    }

    @DeleteMapping("/{student-id}/{course-id}")
    public void deleteEnrollment(@PathVariable("student-id") Long studentId, @PathVariable("course-id") Long courseId) {
        enrollmentService.deleteEnrollmentById(studentId, courseId);
    }

    @GetMapping("/{course-name}")
    public ResponseEntity<List<Student>> getEnrollmentsByCourse(@PathVariable("course-name") String courseName) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentsByCourse(courseName));
    }
}
