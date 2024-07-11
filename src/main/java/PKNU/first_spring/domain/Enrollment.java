package PKNU.first_spring.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollment_id;

    @Column
    private LocalDateTime enrollment_date;

    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName = "course_id")
    Course course;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(LocalDateTime enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public Long getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(Long enrollment_id) {
        this.enrollment_id = enrollment_id;
    }
}
