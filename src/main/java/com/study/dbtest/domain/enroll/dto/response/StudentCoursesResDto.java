package com.study.dbtest.domain.enroll.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCoursesResDto {
    private Integer studentId;
    private String name;
    private Integer courseId;
    private String courseName;
    private String instructor;
    private Date enrollmentDate;

    
}
