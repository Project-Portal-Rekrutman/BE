package com.example.Portal_Recruitment.dto;

public class ScoreDTO {
    private Integer Id;
    private Integer competency;
    private Integer attitude;
    private Integer grooming;
    private Integer communication;
    private Integer experience;
    private Integer enthusiasm;
    private Integer interview_id;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
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
    public void setCommunication(Integer comunication) {
        this.communication = comunication;
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
    public Integer getInterview_id() {
        return interview_id;
    }
    public void setInterview_id(Integer interview_id) {
        this.interview_id = interview_id;
    }

    
}
