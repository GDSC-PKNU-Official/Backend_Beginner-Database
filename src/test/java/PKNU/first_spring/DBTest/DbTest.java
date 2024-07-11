/*
package PKNU.first_spring.DBTest;

import PKNU.first_spring.domain.Student;
import PKNU.first_spring.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DbTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testDatabaseConnection() {
        Student student = new Student();
        student.setName("Test Student");
        studentRepository.save(student);

        Optional<Student> foundStudent = studentRepository.findById(student.getId());
        assertThat(foundStudent).isPresent();
        assertThat(foundStudent.get().getName()).isEqualTo("Test Student");
    }
}*/
