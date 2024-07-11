package PKNU.first_spring.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long student_id;

    @Column
    private String student_name;

    @Column
    private String email;

    @Column
    private Date birth_date;

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public boolean sameName(String name) {
        return this.student_name.equals(name);
    }

    public String getName() {
        return student_name;
    }

    public void setName(String name) {
        this.student_name = name;
    }

    public Long getId() {
        return student_id;
    }

    public void setId(Long id) {
        this.student_id = id;
    }
}
