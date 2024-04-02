package com.example.Portal_Recruitment.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

// import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "tb_tr_interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "apply_id", nullable = false, referencedColumnName = "id")
    private Apply apply;

    @Column(name = "location")
    private String location;

    @Column(name = "schedule")
    private LocalDateTime schedule;

    @Column(name = "interviewer_name")
    private String inteviewerName;

    @Column(name = "interview_status")
    private String interviewStatus;

    @Column(name = "interview_status_date")
    private LocalDate interviewStatusDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
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

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getInteviewerName() {
        return inteviewerName;
    }

    public void setInteviewerName(String inteviewerName) {
        this.inteviewerName = inteviewerName;
    }

    public LocalDate getInterviewStatusDate() {
        return interviewStatusDate;
    }

    public void setInterviewStatusDate(LocalDate interviewStatusDate) {
        this.interviewStatusDate = interviewStatusDate;
    }

}
