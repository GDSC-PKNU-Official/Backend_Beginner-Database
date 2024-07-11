package com.study.dbtest.domain.enroll.service;

import com.study.dbtest.domain.enroll.dto.request.EnrollmentRequestDto;
import com.study.dbtest.model.entity.Course;
import com.study.dbtest.model.entity.Enrollment;
import com.study.dbtest.model.entity.Student;
import com.study.dbtest.model.repository.CourseRepository;
import com.study.dbtest.model.repository.EnrollmentRepository;
import com.study.dbtest.model.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Enrollment enroll(EnrollmentRequestDto enrollmentRequestDto){
        Student student = studentRepository.findById(enrollmentRequestDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(enrollmentRequestDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course nor found"));

        Enrollment enrollment = Enrollment.builder()
                .id(enrollmentRequestDto.getId())
                .student(student)
                .course(course)
                .enrollmentDate(enrollmentRequestDto.getEnrollmentDate())
                .build();

        return enrollmentRepository.save(enrollment);
    }
}
