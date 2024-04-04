package com.example.Portal_Recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.dto.RequestSkill;
import com.example.Portal_Recruitment.model.ParticipantSkill;

@Repository
public interface ParticipantSkillRepository extends JpaRepository<ParticipantSkill, Integer> {
    // @Query("SELECT new com.example.Portal_Recruitment.dto.RequestSkill(p.id, ski.name, skt.name) "
    //         +
    //         "FROM Participant p " +
    //         "JOIN p.participantSkill ski " +
    //         "JOIN ski.skillType skt ")
    // List<RequestSkill> findParticipantSkillDetails();
}
