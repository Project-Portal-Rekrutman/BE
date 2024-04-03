package com.example.Portal_Recruitment.dto;

public class RequestSkill {
    private Integer participant_id;
    private Integer skill_id;
    private Integer skill_type_id;
    private String name_skill;
    private String name_skill_type;

    public Integer getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Integer participant_id) {
        this.participant_id = participant_id;
    }

    public Integer getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(Integer skill_id) {
        this.skill_id = skill_id;
    }

    public Integer getSkill_type_id() {
        return skill_type_id;
    }

    public void setSkill_type_id(Integer skill_type_id) {
        this.skill_type_id = skill_type_id;
    }

    public String getName_skill() {
        return name_skill;
    }

    public void setName_skill(String name_skill) {
        this.name_skill = name_skill;
    }

    public String getName_skill_type() {
        return name_skill_type;
    }

    public void setName_skill_type(String name_skill_type) {
        this.name_skill_type = name_skill_type;
    }

}
