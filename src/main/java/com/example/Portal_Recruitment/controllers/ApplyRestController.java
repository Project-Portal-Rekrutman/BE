package com.example.Portal_Recruitment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.models.Apply;
import com.example.Portal_Recruitment.repos.ApplyRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
public class ApplyRestController {
    @Autowired
    private ApplyRepository applyRepository;

    @PostMapping("applies")
    public ResponseEntity<Object> save(@RequestBody Apply apply) {
        // TODO: process POST request
        Boolean result = applyRepository.findById(apply.getId()).isPresent();
        if (result) {
            Apply app = applyRepository.findByIdApply(apply.getId());
            // app.setVacancy_id(apply.getVacancy_id());
            // app.setParticipant_id(apply.getParticipant_id());
            // app.setApplication_status(apply.getApplication_status());
            // app.setApplication_date(apply.getApplication_date());
            app.setScreening_status(apply.getScreening_status());
            app.setScreening_date(apply.getScreening_date());

            applyRepository.save(app);

            return CustomResponse.generate(HttpStatus.OK, "Data Updated");
        } else {
            return CustomResponse.generate(HttpStatus.INTERNAL_SERVER_ERROR, "Data is NULL");
        }
    }

}
