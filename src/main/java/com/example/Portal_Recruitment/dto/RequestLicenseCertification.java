package com.example.Portal_Recruitment.dto;

import java.sql.Date;

public class RequestLicenseCertification {
    private Integer participant_id;
    private Integer license_certification_id;
    private String name_license_certification;
    private String issuing_organization;
    private Date issued_date;
    private Date date_expired;
    private String credential_id;
    private String credential_url;

    public Integer getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }

    public Integer getLicense_certification_id() {
        return license_certification_id;
    }

    public void setLicense_certification_id(Integer license_certification_id) {
        this.license_certification_id = license_certification_id;
    }

    public String getName_license_certification() {
        return name_license_certification;
    }

    public void setName_license_certification(String name_license_certification) {
        this.name_license_certification = name_license_certification;
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
