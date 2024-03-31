package com.example.Portal_Recruitment.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @Column(name = "note")
    private String note;

    @Column(name = "location")
    private String location;

    @Column(name = "schedule")
    private LocalDateTime schedule;

    @Column(name = "interview_status")
    private String interviewSchedule;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getInterviewSchedule() {
        return interviewSchedule;
    }

    public void setInterviewSchedule(String interviewSchedule) {
        this.interviewSchedule = interviewSchedule;
    }

}