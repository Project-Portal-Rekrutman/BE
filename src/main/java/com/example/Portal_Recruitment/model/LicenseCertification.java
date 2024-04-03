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
@Table(name = "tb_m_license_certification")
public class LicenseCertification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "issuing_organization")
    private String issuing_organization;

    @Column(name = "issued_date")
    private Date issued_date;

    @Column(name = "date_expired")
    private Date date_expired;

    @Column(name = "credential_id")
    private String credential_id;

    @Column(name = "credential_url")
    private String credential_url;

    @OneToMany(mappedBy = "licenseCertification")
    private Set<ParticipantLicenseCertification> participantLicenseCertifications;

    public LicenseCertification() {
    }

    public LicenseCertification(Integer id, String name, String issuing_organization, Date issued_date,
            Date date_expired, String credential_id, String credential_url) {
        this.id = id;
        this.name = name;
        this.issuing_organization = issuing_organization;
        this.issued_date = issued_date;
        this.date_expired = date_expired;
        this.credential_id = credential_id;
        this.credential_url = credential_url;
    }

    public Set<ParticipantLicenseCertification> getParticipantLicenseCertifications() {
        return participantLicenseCertifications;
    }

    public void setParticipantLicenseCertifications(
            Set<ParticipantLicenseCertification> participantLicenseCertifications) {
        this.participantLicenseCertifications = participantLicenseCertifications;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuing_organization() {
        return issuing_organization;
    }

    public void setIssuing_organization(String issuing_organization) {
        this.issuing_organization = issuing_organization;
    }

    public Date getIssued_date() {
        return issued_date;
    }

    public void setIssued_date(Date issued_date) {
        this.issued_date = issued_date;
    }

    public Date getDate_expired() {
        return date_expired;
    }

    public void setDate_expired(Date date_expired) {
        this.date_expired = date_expired;
    }

    public String getCredential_id() {
        return credential_id;
    }

    public void setCredential_id(String credential_id) {
        this.credential_id = credential_id;
    }

    public String getCredential_url() {
        return credential_url;
    }

    public void setCredential_url(String credential_url) {
        this.credential_url = credential_url;
    }

}
