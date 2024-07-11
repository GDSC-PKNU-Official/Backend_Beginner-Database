package com.study.dbtest.domain.enroll.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountStudentWithSameNamePerCourseResDto {
    private Integer courseId;
    private String courseName;
    private String name;
    private Long studentCount;
}
