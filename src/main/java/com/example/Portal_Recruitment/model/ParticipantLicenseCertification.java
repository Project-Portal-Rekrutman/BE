package com.example.Portal_Recruitment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_participant_license_certification")
public class ParticipantLicenseCertification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "license_certification_id")
    private LicenseCertification licenseCertification;

    public ParticipantLicenseCertification() {
    }

    public ParticipantLicenseCertification(Integer id, Participant participant,
            LicenseCertification licenseCertification) {
        this.id = id;
        this.participant = participant;
        this.licenseCertification = licenseCertification;
    }

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

    public LicenseCertification getLicenseCertification() {
        return licenseCertification;
    }

    public void setLicenseCertification(LicenseCertification licenseCertification) {
        this.licenseCertification = licenseCertification;
    }

}
