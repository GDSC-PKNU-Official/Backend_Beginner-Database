package com.study.dbtest.domain.enroll.dto.request;

import com.study.dbtest.model.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequestDto {
    private Integer id;
    private String courseName;
    private String instructor;
    private int score;

    public Course toEntity(){
        return Course.builder()
                .id(id)
                .courseName(courseName)
                .instructor(instructor)
                .score(score)
                .build();
    }
}