package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Enrollment;
import PKNU.first_spring.domain.Student;

import java.util.List;

public interface EnrollmentRepository {
    List<Student> findStudentInCourse(String courseName);
    Enrollment addEnrollment(Enrollment enrollment);
    void deleteEnrollment(Enrollment enrollment);
}
