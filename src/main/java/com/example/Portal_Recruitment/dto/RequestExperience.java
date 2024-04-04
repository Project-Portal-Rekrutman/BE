package com.example.Portal_Recruitment.dto;

import java.sql.Date;

public class RequestExperience {
    private Integer participant_id;
    private Integer experience_id;
    private Integer company_id;
    private String name_company;
    private Integer employment_type_id;
    private String name_employment_type;
    private Integer position_id;
    private String name_position;
    private String description;
    private Date start_date;
    private Date end_date;

    public Integer getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }

    public Integer getExperience_id() {
        return experience_id;
    }

    public void setExperience_id(Integer experience_id) {
        this.experience_id = experience_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public Integer getEmployment_type_id() {
        return employment_type_id;
    }

    public void setEmployment_type_id(Integer employment_type_id) {
        this.employment_type_id = employment_type_id;
    }

    public String getName_employment_type() {
        return name_employment_type;
    }

    public void setName_employment_type(String name_employment_type) {
        this.name_employment_type = name_employment_type;
    }

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Integer position_id) {
        this.position_id = position_id;
    }

    public String getName_position() {
        return name_position;
    }

    public void setName_position(String name_position) {
        this.name_position = name_position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

}
