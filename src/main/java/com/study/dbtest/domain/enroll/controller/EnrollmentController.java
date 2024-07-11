package com.study.dbtest.domain.enroll.controller;

import com.study.dbtest.domain.enroll.dto.request.EnrollmentRequestDto;
import com.study.dbtest.domain.enroll.service.EnrollmentService;
import com.study.dbtest.model.entity.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public Enrollment enroll(@RequestBody EnrollmentRequestDto enrollmentRequestDto){
        return enrollmentService.enroll(enrollmentRequestDto);
    }
}
