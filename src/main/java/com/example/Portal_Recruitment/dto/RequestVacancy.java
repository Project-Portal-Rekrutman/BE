package com.example.Portal_Recruitment.dto;

public class RequestVacancy {
    private String title;
    private String description;
    private String qualification;
    private String location;
    private String jobType;
    private Integer salary;
    private String status;
    private String image;

    public String getImage() {
        return image;
    }



    public void setImage(String image) {
        this.image = image;
    }



    public String getTitle() {
        return title;
    }



    public RequestVacancy() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
