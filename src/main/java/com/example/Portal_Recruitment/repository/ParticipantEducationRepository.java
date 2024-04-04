package com.example.Portal_Recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.dto.RequestEducation;
import com.example.Portal_Recruitment.model.ParticipantEducation;

@Repository
public interface ParticipantEducationRepository extends JpaRepository<ParticipantEducation, Integer>{
    // @Query("SELECT new com.example.Portal_Recruitment.dto.RequestEducation(p.id, p.dateOfBirth, p.address, p.phoneNumber, pe.gpa, univ.name, deg.name, maj.name) " +
    //        "FROM Participant p " +
    //        "JOIN p.participantEducations pe " +
    //        "JOIN pe.academic ac " +
    //        "JOIN ac.university univ " +
    //        "JOIN ac.degree deg " +
    //        "JOIN ac.major maj")
    // List<RequestEducation> findParticipantEducationDetails();
}
