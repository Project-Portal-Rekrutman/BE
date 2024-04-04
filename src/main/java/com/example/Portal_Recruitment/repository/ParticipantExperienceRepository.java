package com.example.Portal_Recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.dto.RequestExperience;
import com.example.Portal_Recruitment.model.ParticipantExperience;

@Repository
public interface ParticipantExperienceRepository extends JpaRepository<ParticipantExperience, Integer> {
    // @Query("SELECT new com.example.Portal_Recruitment.dto.RequestExperience(p.id, comp.name, emp.name, pos.name, pos.description, post.start_date, post_end_date) "
    //         +
    //         "FROM Participant p " +
    //         "JOIN p.participantExperiences pe " +
    //         "JOIN pe.experience ex " +
    //         "JOIN ex.company univ " +
    //         "JOIN ex.employment_type emp " +
    //         "JOIN ex.position post")
    // List<RequestExperience> findParticipantExperienceDetails();
}
