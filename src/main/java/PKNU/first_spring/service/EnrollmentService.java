package PKNU.first_spring.service;

import PKNU.first_spring.domain.Course;
import PKNU.first_spring.domain.Enrollment;
import PKNU.first_spring.domain.Student;
import PKNU.first_spring.repository.CourseRepository;
import PKNU.first_spring.repository.EnrollmentRepository;
import PKNU.first_spring.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment isExist(Long student_id, Long course_id){
        Student student = studentRepository.findById(student_id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        Course course = courseRepository.findById(course_id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollment;
    }

    public Enrollment addEnrollment(Long student_id, Long course_id) {
        return enrollmentRepository.addEnrollment(isExist(student_id, course_id));
    }

    public void deleteEnrollmentById(Long student_id, Long course_id) {
        enrollmentRepository.deleteEnrollment(isExist(student_id, course_id));
    }

    public List<Student> getEnrollmentsByCourse(String courseName) {
        return enrollmentRepository.findStudentInCourse(courseName);
    }
}
