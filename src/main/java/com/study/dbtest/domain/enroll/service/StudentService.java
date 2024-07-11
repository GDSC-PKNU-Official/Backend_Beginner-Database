package com.study.dbtest.domain.enroll.service;

import com.study.dbtest.model.entity.Student;
import com.study.dbtest.domain.enroll.dto.request.StudentRequestDto;
import com.study.dbtest.model.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public int save(StudentRequestDto studentRequestDto) {
        return studentRepository.save(studentRequestDto.toEntity()).getId();
    }

    @Transactional
    public Student findById(int id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }

    @Transactional
    public String deleteById(int id){
        studentRepository.deleteById(id);
        return id + " is successfully deleted";
    }

}
