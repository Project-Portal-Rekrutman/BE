package com.example.Portal_Recruitment.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.ScoreDTO;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.models.Interview;
import com.example.Portal_Recruitment.models.Score;
import com.example.Portal_Recruitment.repos.InterviewRepository;
import com.example.Portal_Recruitment.repos.ScoreRepository;

@RestController
@RequestMapping("api")
public class ScoreRestController {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @PostMapping("score")
    public ResponseEntity<Object> save(@RequestBody ScoreDTO scoreDTO) {
        Boolean checkDataExist = interviewRepository.findById(scoreDTO.getInterview_id()).isPresent();
        if (checkDataExist) {
            Score score = new Score();
            score.setCompetency(scoreDTO.getCompetency());
            score.setCommunication(scoreDTO.getCommunication());
            score.setExperience(scoreDTO.getExperience());
            score.setEnthusiasm(scoreDTO.getEnthusiasm());
            score.setAttitude(scoreDTO.getAttitude());
            score.setGrooming(scoreDTO.getGrooming());
            score.setInterview_id(scoreDTO.getInterview_id());
            scoreRepository.save(score);

            Interview interview = interviewRepository.findByIdInterview(score.getInterview_id());

            Integer value = (score.getCompetency() + score.getCommunication() + score.getExperience() +
                    score.getEnthusiasm() + score.getAttitude() + score.getGrooming()) / 6;

            // Membuat objek Date untuk mendapatkan tanggal dan waktu saat ini
            Date currentDate = new Date();

            if (value > 70) {
                interview.setInterview_status("passed");
                interview.setInterview_status_date(currentDate);
                interviewRepository.save(interview);
            } else {
                interview.setInterview_status("failed");
                interview.setInterview_status_date(currentDate);
                interviewRepository.save(interview);
            }

            return CustomResponse.generate(HttpStatus.OK, "Data Submitted");

        }

        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Data Doesn't Exist");
    }
}
