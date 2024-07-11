package com.study.dbtest.domain.enroll.controller;

import com.study.dbtest.domain.enroll.dto.request.CourseRequestDto;
import com.study.dbtest.domain.enroll.dto.response.CountStudentPerCourseResDto;
import com.study.dbtest.domain.enroll.dto.response.CountStudentWithSameNamePerCourseResDto;
import com.study.dbtest.domain.enroll.dto.response.StudentsWithCourseResDto;
import com.study.dbtest.domain.enroll.service.CourseService;
import com.study.dbtest.domain.enroll.service.EnrollmentService;
import com.study.dbtest.model.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/create/courses")
    public int createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return courseService.save(courseRequestDto);
    }

    @GetMapping("/get/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @DeleteMapping("/delete/courses/{id}")
    public String deleteCourseById(@PathVariable int id) {
        return courseService.deleteById(id);
    }

    @GetMapping("/get/courses/student-number")
    public List<CountStudentPerCourseResDto> getStudentsNumber(){
        return enrollmentService.getStudentsPerCourseNumber();
    }

    @GetMapping("/get/courses/same-name-student-number")
    public List<CountStudentWithSameNamePerCourseResDto> getSameNameStudentsNumber() {
        return enrollmentService.getSameNameStudentsNumber();
    }

    @GetMapping("/get/courses/{id}/students")
    public List<StudentsWithCourseResDto> getStudents(@PathVariable int id){
        return enrollmentService.getStudentsWithCourse(id);
    }
}
