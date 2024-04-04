package com.example.Portal_Recruitment.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.Apply;
import com.example.Portal_Recruitment.repository.ApplyRepository;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Portal_Recruitment.model.Vacancy;
import com.example.Portal_Recruitment.repository.VacancyRepository;

@RestController
@RequestMapping("api")
public class ApplyRestController {
    @Autowired
    private ApplyRepository applyRepository;

    @PostMapping("apply")
    public ResponseEntity<Object> save(@RequestBody Apply apply) {
        // TODO: process POST request
        Boolean result = applyRepository.findById(apply.getId()).isPresent();
        if (result) {

            Apply app = applyRepository.findByIdApply(apply.getId());
            app.setScreeningStatus(apply.getScreeningStatus());
            app.setScreeningDate(LocalDate.now());

            applyRepository.save(app);

            return CustomResponse.generate(HttpStatus.OK, "Data Updated");
        } else {
            return CustomResponse.generate(HttpStatus.INTERNAL_SERVER_ERROR, "Data is NULL");
        }
    }

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
        apply.setAppStatus("Process");
        apply.setScreeningStatus("Process");
        apply.setVacancy(vacancy);
    
        applyRepository.save(apply);
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Added");
    }

    @GetMapping("apply/{id}")
    public ResponseEntity<Object> getProgressList(@PathVariable Integer id) {
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Fetched", applyRepository.getProgress(id));
    }
}
    
