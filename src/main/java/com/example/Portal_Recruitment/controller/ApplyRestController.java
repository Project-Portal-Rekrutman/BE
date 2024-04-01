package com.example.Portal_Recruitment.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.RequesApply;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.Apply;
import com.example.Portal_Recruitment.model.Vacancy;
import com.example.Portal_Recruitment.repository.ApplyRepository;
import com.example.Portal_Recruitment.repository.VacancyRepository;

@RestController
@RequestMapping("api")
public class ApplyRestController {
    @Autowired
    private ApplyRepository applyRepository;
    
    @Autowired
    private VacancyRepository vacancyRepository;

    @GetMapping("applies")
    public ResponseEntity<Object> get() {
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Fetched", applyRepository.findAll());
    }

    @PostMapping("send/application")
    public ResponseEntity<Object>  Send(@RequestParam("jobid") Integer jobid){

        Apply apply = new Apply();
        
        Vacancy vacancy = vacancyRepository.FindVacancy(jobid);
       if (vacancy == null) {
        return CustomResponse.generate(HttpStatus.OK, "Oops! Vacancy not found for jobid: " + jobid);
       }else if (vacancy.getStatus().equals("NonAktif")) {
        return CustomResponse.generate(HttpStatus.OK, "Upps Vacancy Notfound");
       }
        apply.setScreeningDate(LocalDate.now());
        apply.setAppDate(LocalDate.now());
        apply.setAppStatus("process");
        apply.setScreeningStatus("process");
        apply.setVacancy(vacancy);

        applyRepository.save(apply);
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Added");
    }

}