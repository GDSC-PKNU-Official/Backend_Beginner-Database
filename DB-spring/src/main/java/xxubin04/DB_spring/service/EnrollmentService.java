package xxubin04.DB_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xxubin04.DB_spring.entity.Enrollment;
import xxubin04.DB_spring.entity.Student;
import xxubin04.DB_spring.entity.Course;
import xxubin04.DB_spring.repository.CourseRepository;
import xxubin04.DB_spring.repository.EnrollmentRepository;
import xxubin04.DB_spring.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment addEnrollment(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudent_StudentId(studentId);
    }

    public List<Enrollment> getStudentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourse_CourseId(courseId);
    }

    public void deleteEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}