package xxubin04.DB_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxubin04.DB_spring.entity.Enrollment;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourse_CourseId(Long courseId);
    List<Enrollment> findByStudent_StudentId(Long studentId);
}