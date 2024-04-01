package com.example.Portal_Recruitment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.Apply;
import com.example.Portal_Recruitment.repository.ApplyRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
            // Membuat objek Date untuk mendapatkan tanggal dan waktu saat ini
            Date currentDate = new Date();

            Apply app = applyRepository.findByIdApply(apply.getId());
            // app.setVacancy_id(apply.getVacancy_id());
            // app.setParticipant_id(apply.getParticipant_id());
            // app.setApplication_status(apply.getApplication_status());
            // app.setApplication_date(apply.getApplication_date());
            app.setScreening_status(apply.getScreening_status());
            app.setScreening_date(currentDate);

            applyRepository.save(app);

            return CustomResponse.generate(HttpStatus.OK, "Data Updated");
        } else {
            return CustomResponse.generate(HttpStatus.INTERNAL_SERVER_ERROR, "Data is NULL");
        }
    }

}
