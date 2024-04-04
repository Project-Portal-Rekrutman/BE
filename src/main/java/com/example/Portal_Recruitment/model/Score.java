package com.example.Portal_Recruitment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "tb_m_score" )
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id", nullable = false, referencedColumnName = "id")
    private Interview interview;

    private Integer competency;
    private Integer attitude;
    private Integer grooming;
    private Integer communication;
    private Integer experience;
    private Integer enthusiasm;
    private Integer interview_id;
    public Integer getInterview_id() {
        return interview_id;
    }
    public void setInterview_id(Integer interview_id) {
        this.interview_id = interview_id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Interview getInterview() {
        return interview;
    }
    public void setInterview(Interview interview) {
        this.interview = interview;
    }
    public Integer getCompetency() {
        return competency;
    }
    public void setCompetency(Integer competency) {
        this.competency = competency;
    }
    public Integer getAttitude() {
        return attitude;
    }
    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }
    public Integer getGrooming() {
        return grooming;
    }
    public void setGrooming(Integer grooming) {
        this.grooming = grooming;
    }
    public Integer getCommunication() {
        return communication;
    }
    public void setCommunication(Integer communication) {
        this.communication = communication;
    }
    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }
    public Integer getEnthusiasm() {
        return enthusiasm;
    }
    public void setEnthusiasm(Integer enthusiasm) {
        this.enthusiasm = enthusiasm;
    }

    
}
