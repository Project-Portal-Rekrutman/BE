package com.example.Portal_Recruitment.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "participant")
    private Set<ParticipantEducation> participantEducations;

    @OneToMany(mappedBy = "participant")
    private Set<ParticipantExperience> participantExperiences;

    public Participant(Integer id, Date date_of_birth, String address, Set<ParticipantEducation> participantEducations,
            Set<ParticipantExperience> participantExperiences, String phone_number) {
        this.id = id;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.participantEducations = participantEducations;
        this.participantExperiences = participantExperiences;
        this.phone_number = phone_number;
    }

    public Set<ParticipantExperience> getParticipantExperiences() {
        return participantExperiences;
    }

    public void setParticipantExperiences(Set<ParticipantExperience> participantExperiences) {
        this.participantExperiences = participantExperiences;
    }

    public Set<ParticipantEducation> getParticipantEducations() {
        return participantEducations;
    }

    public void setParticipantEducations(Set<ParticipantEducation> participantEducations) {
        this.participantEducations = participantEducations;
    }

    public Integer getId() {
        return id;
    }

    public Participant() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Column(name = "phone_number")
    private String phone_number;
}
