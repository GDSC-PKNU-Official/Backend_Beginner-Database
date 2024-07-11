package com.example.h2database.repository;

import com.example.h2database.domain.Course;
import com.example.h2database.domain.Enrollment;
import com.example.h2database.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Enrollment findByStudentAndCourse(Student student, Course course);
}
