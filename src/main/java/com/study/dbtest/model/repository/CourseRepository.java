package com.study.dbtest.model.repository;

import com.study.dbtest.domain.enroll.dto.response.CountStudentPerCourseResDto;
import com.study.dbtest.domain.enroll.dto.response.CountStudentWithSameNamePerCourseResDto;
import com.study.dbtest.domain.enroll.dto.response.StudentsWithCourseResDto;
import com.study.dbtest.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "select new com.study.dbtest.domain.enroll.dto.response.CountStudentPerCourseResDto(c.id, c.courseName, count(e.student.id)) " +
            "from Course c " +
            "join Enrollment e on c.id = e.course.id " +
            "group by c.id, c.courseName"
    )
    List<CountStudentPerCourseResDto> countStudentPerCourses();

    @Query(value = "select new com.study.dbtest.domain.enroll.dto.response.StudentsWithCourseResDto(e.course.id, e.course.courseName, e.student.id, e.student.name) " +
            "from Course c " +
            "join Enrollment e on c.id = e.course.id " +
            "where c.id = :courseId"
    )
    List<StudentsWithCourseResDto> findStudentsByCourseId(@Param("courseId") int id);

    @Query(value = "select new com.study.dbtest.domain.enroll.dto.response.CountStudentWithSameNamePerCourseResDto(c.id, c.courseName, s.name, count(s.id)) " +
            "from Course c " +
            "join Enrollment e on c.id = e.course.id " +
            "join Student s on e.student.id = s.id " +
            "group by c.id, c.courseName, s.name " +
            "having count(s.id) > 1"
    )
    List<CountStudentWithSameNamePerCourseResDto> countStudentWithSameNamePerCourses();
}
