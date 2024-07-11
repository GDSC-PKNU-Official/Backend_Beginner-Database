package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    Course saveCourse(Course course);
    void deleteCourse(Course course);
    Optional<Course> findByName(String name);
    Optional<Course> findById(Long id);
    List<Course> findAll();
}
