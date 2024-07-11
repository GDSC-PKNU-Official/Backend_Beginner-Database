package com.study.dbtest;

import com.study.dbtest.domain.enroll.dto.request.CourseRequestDto;
import com.study.dbtest.domain.enroll.dto.request.EnrollmentRequestDto;
import com.study.dbtest.domain.enroll.dto.response.CountStudentPerCourseResDto;
import com.study.dbtest.domain.enroll.dto.response.StudentCoursesResDto;
import com.study.dbtest.domain.enroll.service.CourseService;
import com.study.dbtest.domain.enroll.service.EnrollmentService;
import com.study.dbtest.model.entity.Course;
import com.study.dbtest.model.entity.Enrollment;
import com.study.dbtest.model.entity.Student;
import com.study.dbtest.domain.enroll.dto.request.StudentRequestDto;
import com.study.dbtest.model.repository.CourseRepository;
import com.study.dbtest.model.repository.EnrollmentRepository;
import com.study.dbtest.model.repository.StudentRepository;
import com.study.dbtest.domain.enroll.service.StudentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DbtestApplicationTests {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private EnrollmentService enrollmentService;

    @Test
    @Transactional
    void contextLoads() {
        StudentRequestDto studentRequestDto1 = new StudentRequestDto(101, "Annie", "xxx@mail", new Date(2002,Calendar.JANUARY,20));
        StudentRequestDto studentRequestDto2 = new StudentRequestDto(102,"Marrie", "abc@mail", new Date(2000,Calendar.JUNE,18));
        StudentRequestDto studentRequestDto3 = new StudentRequestDto(103,"Annie", "bbb@mail", new Date(1999,Calendar.FEBRUARY,9));
        int resStud1 = studentService.save(studentRequestDto1);
        int resStud2 = studentService.save(studentRequestDto2);
        int resStud3 = studentService.save(studentRequestDto3);
        Student resStudent = studentService.findById(1);
        Assertions.assertNotNull(resStudent);
        System.out.println(resStudent);

        CourseRequestDto courseRequestDto1 = new CourseRequestDto(501, "DB", "Peter", 80);
        CourseRequestDto courseRequestDto2 = new CourseRequestDto(502, "OS", "Tom", 90);
        int resCour1 = courseService.save(courseRequestDto1);
        int resCour2 = courseService.save(courseRequestDto2);
        Course resCourse1 = courseService.findById(1);
        Assertions.assertNotNull(resCourse1);
        System.out.println(resCourse1);

        EnrollmentRequestDto enrollmentRequestDto1 = new EnrollmentRequestDto(1,1,1,new Date(2024, Calendar.MARCH, 1));
        EnrollmentRequestDto enrollmentRequestDto2 = new EnrollmentRequestDto(2,1,2,new Date(2024, Calendar.MARCH, 1));
        EnrollmentRequestDto enrollmentRequestDto3 = new EnrollmentRequestDto(3,2,1,new Date(2024, Calendar.MARCH, 1));
        EnrollmentRequestDto enrollmentRequestDto4 = new EnrollmentRequestDto(4,3,1,new Date(2024, Calendar.SEPTEMBER, 1));
        Enrollment resEnroll1 = enrollmentService.enroll(enrollmentRequestDto1);
        Assertions.assertNotNull(resEnroll1);
        System.out.println(resEnroll1);

        List<StudentCoursesResDto> coursesResDtos = enrollmentService.getCoursesFromStudent(1);
    }

}
