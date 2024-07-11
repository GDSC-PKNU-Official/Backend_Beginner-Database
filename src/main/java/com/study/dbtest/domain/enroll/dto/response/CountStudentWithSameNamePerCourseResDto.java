package com.study.dbtest.domain.enroll.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountStudentWithSameNamePerCourseResDto {
    private Integer courseId;
    private String courseName;
    private String name;
    private Long studentCount;
}
