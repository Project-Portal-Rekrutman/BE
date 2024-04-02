package com.example.Portal_Recruitment.dto;

public class RequestInterview {
    private Integer applyId;
    private String location;
    private String schedule;
    private String interviewerName;

    public Integer getApplyId() {
        return applyId;
    }
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public String getInterviewerName() {
        return interviewerName;
    }
    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }
}