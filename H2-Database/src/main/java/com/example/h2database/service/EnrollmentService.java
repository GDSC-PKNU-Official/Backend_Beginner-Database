package com.example.h2database.service;

import com.example.h2database.domain.Course;
import com.example.h2database.domain.Enrollment;
import com.example.h2database.domain.Student;
import com.example.h2database.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void cancelEnrollment(Student student, Course course) {
        Enrollment enrollment = enrollmentRepository.findByStudentAndCourse(student, course);
        enrollmentRepository.delete(enrollment);
    }





}
