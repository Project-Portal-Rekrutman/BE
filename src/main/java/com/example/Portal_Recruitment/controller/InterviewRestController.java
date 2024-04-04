package com.example.Portal_Recruitment.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.RequestInterview;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.Apply;
import com.example.Portal_Recruitment.model.Interview;
import com.example.Portal_Recruitment.repository.ApplyRepository;
import com.example.Portal_Recruitment.repository.InterviewRepository;

@RestController
@RequestMapping("api")
public class InterviewRestController {
    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private ApplyRepository applyRepository;

    @PostMapping("interview/{id}")
    public ResponseEntity<Object> save(@RequestBody RequestInterview requestInterview,
            @PathVariable(required = true) Integer id) {
        Apply apply = applyRepository.getIdApply(id);
        Interview interviewByApplyId = interviewRepository.findByApplyId(id);
        if (apply != null) {
            if (requestInterview.getLocation().isEmpty() || requestInterview.getSchedule().isEmpty()
                    || requestInterview.getInterviewerName().isEmpty()) {
                return CustomResponse.generate(HttpStatus.BAD_REQUEST, "the field cannot be empty, check your input");
            } else if (interviewByApplyId != null) {
                return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Failed created because data already exist");
            } else {
                Interview interview = new Interview();
                interview.setApply(apply);
                interview.setLocation(requestInterview.getLocation());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(requestInterview.getSchedule(), formatter);
                interview.setSchedule(dateTime);
                interview.setInteviewerName(requestInterview.getInterviewerName());
                interview.setInterviewStatus("On Going");
                interview.setInterviewStatusDate(LocalDate.now());
                interviewRepository.save(interview);
                Boolean result = interviewRepository.findById(interview.getId()).isPresent();
                if (result) {
                    return CustomResponse.generate(HttpStatus.CREATED, "Successfully created interview schedule");
                } else {
                    return CustomResponse.generate(HttpStatus.BAD_REQUEST,
                            "Failed to create interview schedule, please check your input");

                }
            }
        }
        return CustomResponse.generate(HttpStatus.NOT_FOUND, "ID Apply Not Found");
    }

    @GetMapping("interview")
    public ResponseEntity<Object> getAll() {
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Fetched", interviewRepository.findAll());
    }

    @GetMapping("interview/{id}")
    public ResponseEntity<Object> getById(@PathVariable(required = true) Integer id) {
        // Apply apply = applyRepository.getIdApply(id);
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Fetched", interviewRepository.findByApplyId(id));
    }
}