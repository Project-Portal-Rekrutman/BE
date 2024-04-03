package com.example.Portal_Recruitment.model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_participant_education")
public class ParticipantEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "gpa")
    private DecimalFormat gpa;

    @ManyToOne
    @JoinColumn(name = "academic_id")
    private Academic academic;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    public ParticipantEducation() {
    }

    public ParticipantEducation(Integer id, DecimalFormat gpa, Academic academic, Participant participant) {
        this.id = id;
        this.gpa = gpa;
        this.academic = academic;
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DecimalFormat getGpa() {
        return gpa;
    }

    public void setGpa(DecimalFormat gpa) {
        this.gpa = gpa;
    }

    public Academic getAcademic() {
        return academic;
    }

    public void setAcademic(Academic academic) {
        this.academic = academic;
    }
}
