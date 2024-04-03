package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.ParticipantLicenseCertification;

@Repository
public interface ParticipantLicenseCertificationRepository extends JpaRepository<ParticipantLicenseCertification, Integer>{
    
}
