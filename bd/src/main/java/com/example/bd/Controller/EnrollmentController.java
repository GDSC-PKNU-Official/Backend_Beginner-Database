package com.example.bd.Controller;

import com.example.bd.Entity.Enrollment;
import com.example.bd.Entity.Student;
import com.example.bd.Entity.Course;
import com.example.bd.Repository.EnrollmentRepository;
import com.example.bd.Repository.StudentRepository;
import com.example.bd.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // 특정 학생의 수강 과목 추가 (POST 요청 처리)
    @PostMapping("/add")
    public String addEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        // 학생과 과목을 데이터베이스에서 찾음
        Student student = studentRepository.findById(enrollmentRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + enrollmentRequest.getStudentId()));
        Course course = courseRepository.findById(enrollmentRequest.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + enrollmentRequest.getCourseId()));

        // Enrollment 객체 생성 및 설정
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(enrollmentRequest.getEnrollmentDate());

        // Enrollment 저장
        enrollmentRepository.save(enrollment);

        return "Enrollment added successfully";
    }

    // DTO 클래스 정의
    public static class EnrollmentRequest {
        private Long studentId;
        private Long courseId;
        private LocalDate enrollmentDate;

        // getters and setters
        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public Long getCourseId() {
            return courseId;
        }

        public void setCourseId(Long courseId) {
            this.courseId = courseId;
        }

        public LocalDate getEnrollmentDate() {
            return enrollmentDate;
        }

        public void setEnrollmentDate(LocalDate enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
        }
    }

    // 특정 학생의 수강 과목 조회 (GET 요청 처리)
    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        return enrollmentRepository.findByStudentStudentId(studentId);
    }

    // 특정 학생의 수강 과목 삭제 (DELETE 요청 처리)
    @DeleteMapping("/delete/{enrollmentId}")
    public String deleteEnrollment(@PathVariable Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + enrollmentId));

        enrollmentRepository.delete(enrollment);
        return "Enrollment deleted successfully";
    }
}