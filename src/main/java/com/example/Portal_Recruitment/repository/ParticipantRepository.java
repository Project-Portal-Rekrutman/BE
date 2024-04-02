package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{
    
}
