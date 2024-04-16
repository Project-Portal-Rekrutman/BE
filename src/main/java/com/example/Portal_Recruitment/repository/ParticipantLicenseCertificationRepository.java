package com.example.Portal_Recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.ParticipantLicenseCertification;

@Repository
public interface ParticipantLicenseCertificationRepository extends JpaRepository<ParticipantLicenseCertification, Integer> {
    @Query(value = "Select * from tb_tr_participant_license_certification where id= ?1", nativeQuery = true)
    public ParticipantLicenseCertification getIdParticipantLicenseCertification(Integer Id);
    // @Query("SELECT new
    // com.example.Portal_Recruitment.dto.RequestLicenseCertification(p.id,
    // lic.name, lic.issuing_organization, lic.issued_date, lic.date_expired,
    // lic.credential_id, lic_credential_url) "
    // +
    // "FROM Participant p " +
    // "JOIN p.participantLicenseCertifications le " +
    // "JOIN le.licenseCertification lic ")
    // List<RequestLicenseCertification> findParticipantLicenseDetails();

    @Query(value = "Select * from tb_tr_participant_license_certification pc where participant_id= ?1", nativeQuery = true)
    public List<ParticipantLicenseCertification> getIdParticipant(Integer Id);
}
