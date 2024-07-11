package com.example.Backend_Beginner2.repository;

import com.example.Backend_Beginner2.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
    List<Enrollment> findByStudentStudentId(int studentId);
}
