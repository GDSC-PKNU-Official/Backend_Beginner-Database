package xxubin04.DB_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xxubin04.DB_spring.entity.Enrollment;
import xxubin04.DB_spring.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/add")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody AddEnrollmentRequest request) {
        Long studentId = request.getStudentId();
        Long courseId = request.getCourseId();
        Enrollment enrollment = enrollmentService.addEnrollment(studentId, courseId);
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudent(@PathVariable Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Enrollment>> getStudentsByCourse(@PathVariable Long courseId) {
        List<Enrollment> enrollments = enrollmentService.getStudentsByCourse(courseId);
        return ResponseEntity.ok(enrollments);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.noContent().build();
    }
}
