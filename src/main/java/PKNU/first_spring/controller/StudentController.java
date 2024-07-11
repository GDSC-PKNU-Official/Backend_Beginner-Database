package PKNU.first_spring.controller;

import PKNU.first_spring.domain.Student;
import PKNU.first_spring.dto.StudentForm;
import PKNU.first_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Object> createStudent(@RequestBody StudentForm form) {
        Student student = new Student();
        student.setName(form.student_name());
        student.setEmail(form.email());
        student.setBirth_date(form.birth_date());

        studentService.join(student);
        return ResponseEntity.ok("The student has been successfully created");
    }

    @GetMapping
    public ResponseEntity<Object> List(Model model){
        List<Student> students = studentService.findStudents();

        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<Object> deleteStudent(@RequestBody StudentForm form){
        studentService.deleteStudent(form.student_name());
        return ResponseEntity.ok("The student has been successfully deleted");
    }
}
