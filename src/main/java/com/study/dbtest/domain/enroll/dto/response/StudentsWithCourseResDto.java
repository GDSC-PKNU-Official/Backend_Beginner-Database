package com.study.dbtest.domain.enroll.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsWithCourseResDto {
    private Integer courseId;
    private String courseName;
    private Integer studentId;
    private String name;
}
