package com.study.dbtest.domain.enroll.service;

import com.study.dbtest.domain.enroll.dto.response.CountStudentPerCourseResDto;
import com.study.dbtest.domain.enroll.dto.response.CountStudentWithSameNamePerCourseResDto;
import com.study.dbtest.domain.enroll.dto.response.StudentsWithCourseResDto;
import com.study.dbtest.model.entity.Course;
import com.study.dbtest.domain.enroll.dto.request.CourseRequestDto;
import com.study.dbtest.model.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService{
    private final CourseRepository courseRepository;

    @Transactional
    public int save(CourseRequestDto courseRequestDto) {
        return courseRepository.save(courseRequestDto.toEntity()).getId();
    }

    @Transactional
    public Course findById(int id){
        return courseRepository.findById(id).orElseThrow(()-> new RuntimeException("course not found"));

    }

    @Transactional
    public String deleteById(int id){
        courseRepository.deleteById(id);
        return id + " is successfully deleted";
    }

    @Transactional
    public List<CountStudentPerCourseResDto> getStudentsPerCourseNumber(){
        return courseRepository.countStudentPerCourses();
    }

    @Transactional
    public List<CountStudentWithSameNamePerCourseResDto> getSameNameStudentsNumber(){
        return courseRepository.countStudentWithSameNamePerCourses();
    }

    @Transactional
    public List<StudentsWithCourseResDto> getStudentsWithCourse(int id){
        return courseRepository.findStudentsByCourseId(id);
    }
}
