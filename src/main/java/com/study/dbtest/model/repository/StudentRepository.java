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


}
