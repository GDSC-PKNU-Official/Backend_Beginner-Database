package com.example.Backend_Beginner2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.Backend_Beginner2.domain.Course;
import com.example.Backend_Beginner2.domain.Enrollment;
import com.example.Backend_Beginner2.domain.Student;
import com.example.Backend_Beginner2.repository.CourseRepository;
import com.example.Backend_Beginner2.repository.EnrollmentRepository;
import com.example.Backend_Beginner2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getEnrollments(int studentId) {
        return enrollmentRepository.findByStudentStudentId(studentId);
    }

    public Enrollment enrollStudent(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollment_date(new Date());

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        logger.info("Created enrollment: {}", savedEnrollment);
        return savedEnrollment;
    }

    public void deleteEnrollment(int enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}
