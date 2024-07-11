package com.study.dbtest.model.repository;

import com.study.dbtest.domain.enroll.dto.response.StudentCoursesResDto;
import com.study.dbtest.model.entity.Course;
import com.study.dbtest.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select new com.study.dbtest.domain.enroll.dto.response.StudentCoursesResDto(s.id, s.name, c.id, c.courseName, c.instructor, e.enrollmentDate) " +
            "from Enrollment e " +
            "join Student s on s.id = e.student.id " +
            "join Course c on e.course.id = c.id " +
            "where s.id = :studentId"
    )
    List<StudentCoursesResDto> findCoursesById(@Param("studentId") int id);
}
