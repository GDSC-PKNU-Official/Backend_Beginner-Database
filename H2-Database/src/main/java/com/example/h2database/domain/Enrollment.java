package com.example.h2database.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id", nullable = false)
    private int enrollment_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",nullable = false,referencedColumnName = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",nullable = false,referencedColumnName = "course_id")
    private Course course;

    @Column(name = "enrollment_date",nullable = false)
    @Temporal(TemporalType.DATE)  //자바의 날짜 타입은 @Temporal로 매핑
    private Date enrollment_date;

    // 매개변수 있는 생성자
    public Enrollment(Student student, Course course, Date enrollment_date) {
        this.student = student;
        this.course = course;
        this.enrollment_date = enrollment_date;
    }

}

