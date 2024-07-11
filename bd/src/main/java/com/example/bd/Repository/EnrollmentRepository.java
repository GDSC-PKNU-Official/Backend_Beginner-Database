package com.example.bd.Repository;
import com.example.bd.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // 특정 학생의 모든 수강 과목을 조회하는 쿼리 메서드
    @Query("SELECT e FROM Enrollment e WHERE e.student.id = :studentId")
    List<Enrollment> findByStudentStudentId(Long studentId);
    List<Enrollment> findByCourseCourseId(Long courseId);
}