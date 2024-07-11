package xxubin04.DB_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxubin04.DB_spring.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}