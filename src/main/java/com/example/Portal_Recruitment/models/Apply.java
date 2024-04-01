package com.example.Portal_Recruitment.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_apply")
public class Apply {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer vacancy_id;
    private Integer participant_id;
    private String application_status;
    private Date application_date;
    private String screening_status;
    private Date screening_date;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getVacancy_id() {
        return vacancy_id;
    }
    public void setVacancy_id(Integer vacancy_id) {
        this.vacancy_id = vacancy_id;
    }
    public Integer getParticipant_id() {
        return participant_id;
    }
    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }
    public String getApplication_status() {
        return application_status;
    }
    public void setApplication_status(String application_status) {
        this.application_status = application_status;
    }
    public Date getApplication_date() {
        return application_date;
    }
    public void setApplication_date(Date application_date) {
        this.application_date = application_date;
    }
    public String getScreening_status() {
        return screening_status;
    }
    public void setScreening_status(String screening_status) {
        this.screening_status = screening_status;
    }
    public Date getScreening_date() {
        return screening_date;
    }
    public void setScreening_date(Date screening_date) {
        this.screening_date = screening_date;
    }

    
}
