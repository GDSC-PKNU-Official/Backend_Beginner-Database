package PKNU.first_spring.service;

import PKNU.first_spring.domain.Course;
import PKNU.first_spring.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.saveCourse(course);
    }

    public void deleteCourse(String name){
        Course course = courseRepository.findByName(name).get();
        courseRepository.deleteCourse(course);
    }

    public List<Course> findCourses() {
        return courseRepository.findAll();
    }
}
