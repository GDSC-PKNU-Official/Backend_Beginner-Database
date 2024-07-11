package com.study.dbtest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String instructor;

    @Column
    private Integer score;

//    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
//    private List<Enrollment> enrollments;
}
