package com.example.Portal_Recruitment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_completion")
public class Completion {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id", nullable = false, referencedColumnName = "id")
    private Participant participant;

    @Column(name = "personal_data")
    private Integer personalData;

    @Column(name = "education_data")
    private Integer educationData;

    @Column(name = "experience_data")
    private Integer experienceData;

    @Column(name = "skill_data")
    private Integer skillData;

    @Column(name = "license_certification_data")
    private Integer licenseCertificationData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Integer getPersonalData() {
        return personalData;
    }

    public void setPersonalData(Integer personalData) {
        this.personalData = personalData;
    }

    public Integer getEducationData() {
        return educationData;
    }

    public void setEducationData(Integer educationData) {
        this.educationData = educationData;
    }

    public Integer getExperienceData() {
        return experienceData;
    }

    public void setExperienceData(Integer experienceData) {
        this.experienceData = experienceData;
    }

    public Integer getSkillData() {
        return skillData;
    }

    public void setSkillData(Integer skillData) {
        this.skillData = skillData;
    }

    public Integer getLicenseCertificationData() {
        return licenseCertificationData;
    }

    public void setLicenseCertificationData(Integer licenseCertificationData) {
        this.licenseCertificationData = licenseCertificationData;
    }

}
