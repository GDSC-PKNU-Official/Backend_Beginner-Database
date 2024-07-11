package com.example.h2database.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access =AccessLevel.PROTECTED)
@Entity
//@Table(name = "Student")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id",nullable = false)
    private int student_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name= "birth_date",nullable = false)
    @Temporal(TemporalType.DATE)  //자바의 날짜 타입은 @Temporal로 매핑
    private Date birth_date; //DATE(년월일), time(시분초), timestamp(년원일 시분초)

    @Column(name = "email",nullable = false)
    private String email;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();

}
