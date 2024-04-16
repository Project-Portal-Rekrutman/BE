package com.example.Portal_Recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.ParticipantEducation;

@Repository
public interface ParticipantEducationRepository extends JpaRepository<ParticipantEducation, Integer> {

    @Query(value = "Select * from tb_tr_participant_education where id= ?1", nativeQuery = true)
    public ParticipantEducation getIdParticipantEducation(Integer Id);

//     @Query(value = "SELECT
//   "participant.id, +
//   "participant.date_of_birth",
//   participant.address,
//   participant.phone_number,
//   participant_education.gpa,
//   univ.name AS University_Name,
//     degree.name AS Degree_Name,
//     major.name AS
//     Major_Name FROM
//     tb_m_participant participant
//     JOIN tb_tr_participant_education
//     participant_education ON participant.id=
//     participant_education.participant_id JOIN
//     tb_m_academic academic
//     ON participant_education.academic_id=
//     academic.id JOIN
//     tb_m_univ univ
//     ON academic.univ_id=
//     univ.id JOIN
//     tb_m_degree degree
//     ON academic.degree_id=
//     degree.id JOIN
//     tb_m_major major
//     ON academic.major_id=major.id;)

//     List<RequestEducation> findParticipantEducationDetails();
    @Query(value = "Select * from tb_tr_participant_education pe where participant_id= ?1", nativeQuery = true)
    public List<ParticipantEducation> getIdParticipant(Integer Id);
}
