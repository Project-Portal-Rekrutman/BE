package com.example.Portal_Recruitment.dto;

// import java.time.LocalDateTime;

// import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestInterview {
    private Integer applyId;
    private String location;
    // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    // private LocalDateTime schedule;
    private String schedule;
    // private String interviewStatus;

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
    // public String getInterviewStatus() {
    //     return interviewStatus;
    // }
    // public void setInterviewStatus(String interviewStatus) {
    //     this.interviewStatus = interviewStatus;
    // }

    
}
