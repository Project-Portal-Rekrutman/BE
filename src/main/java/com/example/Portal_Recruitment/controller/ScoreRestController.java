package com.example.Portal_Recruitment.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import com.example.Portal_Recruitment.model.Interview;
import com.example.Portal_Recruitment.model.Score;
import com.example.Portal_Recruitment.repository.InterviewRepository;
import com.example.Portal_Recruitment.repository.ScoreRepository;

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


            if (value > 70) {
                interview.setInterviewStatus("passed");
                interview.setInterviewStatusDate(LocalDate.now());
                interviewRepository.save(interview);
            } else {
                interview.setInterviewStatus("failed");
                interview.setInterviewStatusDate(LocalDate.now());
                interviewRepository.save(interview);
            }

            return CustomResponse.generate(HttpStatus.OK, "Data Submitted");

        }

        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Data Doesn't Exist");
    }
}
