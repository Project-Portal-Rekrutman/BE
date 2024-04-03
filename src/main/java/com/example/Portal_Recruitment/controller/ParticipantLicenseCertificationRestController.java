package com.example.Portal_Recruitment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.RequestLicenseCertification;
import com.example.Portal_Recruitment.model.LicenseCertification;
import com.example.Portal_Recruitment.model.Participant;
import com.example.Portal_Recruitment.model.ParticipantLicenseCertification;
import com.example.Portal_Recruitment.repository.LicenseCertificationRepository;
import com.example.Portal_Recruitment.repository.ParticipantLicenseCertificationRepository;
import com.example.Portal_Recruitment.repository.ParticipantRepository;

@RestController
@RequestMapping("api")
public class ParticipantLicenseCertificationRestController {
    
    @Autowired
    private ParticipantLicenseCertificationRepository participantLicenseCertificationRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private LicenseCertificationRepository licenseCertificationRepository;

    @PostMapping("licensecertification")
    public ResponseEntity<Object> saveLicense(@RequestBody RequestLicenseCertification requestLicenseCertification) {
        Optional<Participant> participantOpt = participantRepository.findById(requestLicenseCertification.getParticipant_id());

        if (!participantOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found");

        }

        LicenseCertification licenseCertification = licenseCertificationRepository.findById(requestLicenseCertification.getLicense_certification_id())
                .orElseGet(() -> new LicenseCertification(requestLicenseCertification.getLicense_certification_id(), requestLicenseCertification.getName_license_certification(), requestLicenseCertification.getIssuing_organization(), 
                requestLicenseCertification.getIssued_date(), requestLicenseCertification.getDate_expired(), requestLicenseCertification.getCredential_id(), requestLicenseCertification.getCredential_url()));

        licenseCertification = licenseCertificationRepository.save(licenseCertification);

        ParticipantLicenseCertification participantLicenseCertification = new ParticipantLicenseCertification();
        participantLicenseCertification.setParticipant(participantOpt.get());
        participantLicenseCertification.setLicenseCertification(licenseCertification);
        participantLicenseCertificationRepository.save(participantLicenseCertification);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created or updated license certification details");
    }
}
