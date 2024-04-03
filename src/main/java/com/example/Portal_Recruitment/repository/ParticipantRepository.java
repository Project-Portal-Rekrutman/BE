package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{
    @Query(value = "Select * from tb_m_participant where id= ?1", nativeQuery = true)
    public Participant getIdParticipant(Integer Id);
}
