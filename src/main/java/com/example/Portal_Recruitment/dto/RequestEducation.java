package com.example.Portal_Recruitment.dto;

public class RequestEducation {
    private Integer participant_id;
    private Integer education_id;
    private Integer academic_id;
    private Integer univ_id;
    private String name_univ;
    private Integer major_id;
    private String name_major;
    private Integer degree_id;
    private String name_degree;
    private Double gpa;

    public Integer getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }

    public Integer getEducation_id() {
        return education_id;
    }

    public void setEducation_id(Integer education_id) {
        this.education_id = education_id;
    }

    public Integer getAcademic_id() {
        return academic_id;
    }

    public void setAcademic_id(Integer academic_id) {
        this.academic_id = academic_id;
    }

    public Integer getUniv_id() {
        return univ_id;
    }

    public void setUniv_id(Integer univ_id) {
        this.univ_id = univ_id;
    }

    public String getName_univ() {
        return name_univ;
    }

    public void setName_univ(String name_univ) {
        this.name_univ = name_univ;
    }

    public Integer getMajor_id() {
        return major_id;
    }

    public void setMajor_id(Integer major_id) {
        this.major_id = major_id;
    }

    public String getName_major() {
        return name_major;
    }

    public void setName_major(String name_major) {
        this.name_major = name_major;
    }

    public Integer getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(Integer degree_id) {
        this.degree_id = degree_id;
    }

    public String getName_degree() {
        return name_degree;
    }

    public void setName_degree(String name_degree) {
        this.name_degree = name_degree;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

}
