package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Participant;


@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{
    
   
    @Query("SELECT p FROM Participant p JOIN p.user u WHERE u.email = ?1")
    public Participant findUser(String email);
}
