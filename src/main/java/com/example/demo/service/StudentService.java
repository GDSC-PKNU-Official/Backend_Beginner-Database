package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.domain.Enrollment;
import com.example.demo.domain.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, EnrollmentRepository enrollmentRepository,CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    public List<Enrollment> getEnrollments(int studentId){
        return enrollmentRepository.findByStudentStudentId(studentId);
    }

    public Enrollment addEnrollment(int studentId, int courseId){
        Student student = studentRepository.findById(studentId).orElseThrow(()->new NoSuchElementException());
        Course course = courseRepository.findById(courseId).orElseThrow(()->new NoSuchElementException());
        Enrollment enrollment = new Enrollment(student, course, new Date());
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return savedEnrollment;
    }

    public void deleteEnrollment(int enrollmentId){
        enrollmentRepository.deleteById(enrollmentId);
    }

}
