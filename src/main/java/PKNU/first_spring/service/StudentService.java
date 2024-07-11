package PKNU.first_spring.service;

import PKNU.first_spring.domain.Student;
import PKNU.first_spring.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void join(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(String name){
        Student student = studentRepository.findByName(name).get();
        studentRepository.deleteStudent(student);
    }

    public List<Student> findStudents() {
        return studentRepository.findAll();
    }
}
