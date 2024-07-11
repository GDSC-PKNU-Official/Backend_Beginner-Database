package com.example.bd.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id // primary key
    // GeneratedValue : Auto Increment, 자동으로 1씩 증가
    // strategy : 고유 번호를 생성하는 옵션
    // GenerationType.IDENTITY : 독립적인 시퀀스를 생성, 기본 키 생성을 위한 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String email;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Enrollment> enrollments;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
