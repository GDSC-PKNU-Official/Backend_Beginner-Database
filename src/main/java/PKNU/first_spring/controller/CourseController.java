package PKNU.first_spring.controller;

import PKNU.first_spring.domain.Course;
import PKNU.first_spring.dto.CourseForm;
import PKNU.first_spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Object> createCourse(@RequestBody CourseForm form) {
        Course course = new Course();
        course.setCourse_name(form.course_name());
        course.setInstructor(form.instructor());
        course.setScore(form.score());

        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping
    public ResponseEntity<Object> ListOfCourse(Model model){
        List<Course> courses = courseService.findCourses();

        return ResponseEntity.ok(courses);
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<Object> deleteCourse(@RequestBody CourseForm form){
        courseService.deleteCourse(form.course_name());
        return ResponseEntity.ok("The course has been successfully deleted");
    }
}
