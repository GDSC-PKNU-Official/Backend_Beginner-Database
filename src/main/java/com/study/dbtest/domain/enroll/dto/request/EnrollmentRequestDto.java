package com.study.dbtest.domain.enroll.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.dbtest.domain.enroll.service.EnrollmentService;
import com.study.dbtest.model.entity.Enrollment;
import lombok.*;

import java.util.Date;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentRequestDto {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enrollmentDate;

}
