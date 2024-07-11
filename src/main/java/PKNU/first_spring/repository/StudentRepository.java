package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);
    void deleteStudent(Student student);
    Optional<Student> findByName(String name);
    Optional<Student> findById(Long id);
    List<Student> findAll();
}
