package com.example.Backend_Beginner2.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Date enrollmentDate;

    public Enrollment() {}

    public void setStudent(Student student) {
        this.student = student;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public void setEnrollment_date(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
