package com.study.dbtest.domain.enroll.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.dbtest.model.entity.Student;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {
    private Integer id;
    private String name;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    public Student toEntity(){
        return Student.builder()
                .name(name)
                .email(email)
                .birthDate(birthDate)
                .build();
    }
}
