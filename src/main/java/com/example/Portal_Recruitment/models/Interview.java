package com.example.Portal_Recruitment.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "tb_tr_interview")
public class Interview {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToOne( mappedBy = "interview")
    private Score interviewScores;
    
    private Integer apply_id;
    private String location;
    private LocalDateTime schedule;
    private String interview_status;
    private Date interview_status_date;
    private String interviewer_name;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Score getInterviewScores() {
        return interviewScores;
    }
    public void setInterviewScores(Score interviewScores) {
        this.interviewScores = interviewScores;
    }
    public Integer getApply_id() {
        return apply_id;
    }
    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDateTime getSchedule() {
        return schedule;
    }
    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }
    public String getInterview_status() {
        return interview_status;
    }
    public void setInterview_status(String interview_status) {
        this.interview_status = interview_status;
    }
    public Date getInterview_status_date() {
        return interview_status_date;
    }
    public void setInterview_status_date(Date interview_status_date) {
        this.interview_status_date = interview_status_date;
    }
    public String getInterviewer_name() {
        return interviewer_name;
    }
    public void setInterviewer_name(String interviewer_name) {
        this.interviewer_name = interviewer_name;
    }

}

