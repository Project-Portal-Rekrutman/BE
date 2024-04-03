package com.example.Portal_Recruitment.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_academic")
public class Academic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "univ_id")
    private Univ univ;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @OneToMany(mappedBy = "academic")
    private Set<ParticipantEducation> participantEducations;

    public Academic() {
    }

    public Academic(Integer id, Degree degree, Univ univ, Major major,
            Set<ParticipantEducation> participantEducations) {
        this.id = id;
        this.degree = degree;
        this.univ = univ;
        this.major = major;
        this.participantEducations = participantEducations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Univ getUniv() {
        return univ;
    }

    public void setUniv(Univ univ) {
        this.univ = univ;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Set<ParticipantEducation> getParticipantEducations() {
        return participantEducations;
    }

    public void setParticipantEducations(Set<ParticipantEducation> participantEducations) {
        this.participantEducations = participantEducations;
    }

}
