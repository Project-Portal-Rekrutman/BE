package com.example.Portal_Recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.ParticipantSkill;

@Repository
public interface ParticipantSkillRepository extends JpaRepository<ParticipantSkill, Integer> {
    @Query(value = "Select * from tb_tr_participant_skill where id= ?1", nativeQuery = true)
    public ParticipantSkill getIdParticipantSkill(Integer Id);
    // @Query("SELECT new com.example.Portal_Recruitment.dto.RequestSkill(p.id,
    // ski.name, skt.name) "
    // +
    // "FROM Participant p " +
    // "JOIN p.participantSkill ski " +
    // "JOIN ski.skillType skt ")
    // List<RequestSkill> findParticipantSkillDetails();
    @Query(value = "Select * from tb_tr_participant_skill ps where participant_id= ?1", nativeQuery = true)
    public List<ParticipantSkill> getIdParticipant(Integer Id);

}
