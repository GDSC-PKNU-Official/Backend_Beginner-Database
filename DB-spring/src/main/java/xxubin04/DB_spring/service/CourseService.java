package xxubin04.DB_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xxubin04.DB_spring.entity.Course;
import xxubin04.DB_spring.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }

    public Course updateCourse(Long courseId, Course courseDetails) {
        Course course = courseRepository.findById(courseId).orElseThrow();

        course.setCourseName(courseDetails.getCourseName());

        return courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
