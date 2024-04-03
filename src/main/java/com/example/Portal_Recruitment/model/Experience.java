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
@Table(name = "tb_m_experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "employment_type_id")
    private EmploymentType employmentType;

    @OneToMany(mappedBy = "experience")
    private Set<ParticipantExperience> participantExperiences;

    public Experience() {
    }

    public Experience(Integer id, Company company, Position position, EmploymentType employmentType,
            Set<ParticipantExperience> participantExperiences) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.employmentType = employmentType;
        this.participantExperiences = participantExperiences;
    }

    public Set<ParticipantExperience> getParticipantExperiences() {
        return participantExperiences;
    }

    public void setParticipantExperiences(Set<ParticipantExperience> participantExperiences) {
        this.participantExperiences = participantExperiences;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }
}
