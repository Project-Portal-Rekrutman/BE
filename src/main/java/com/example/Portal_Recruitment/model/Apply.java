package com.example.Portal_Recruitment.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tr_apply")
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @Column(name = "application_status")
    private String applicationStatus;

    @Column(name = "application_date")
    private Date applicationDate;
    
    @Column(name = "screening_status")
    private String screeningStatus;

    @Column(name = "screening_date")
    private Date screeningDate;

    @JsonIgnore
    @OneToOne(mappedBy = "apply")
    private Interview interview;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getScreeningStatus() {
        return screeningStatus;
    }

    public void setScreeningStatus(String screeningStatus) {
        this.screeningStatus = screeningStatus;
    }

    public Date getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Date screeningDate) {
        this.screeningDate = screeningDate;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }
}