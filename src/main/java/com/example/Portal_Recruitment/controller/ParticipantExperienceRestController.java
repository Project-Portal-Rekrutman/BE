package com.example.Portal_Recruitment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.RequestExperience;
import com.example.Portal_Recruitment.model.*;
import com.example.Portal_Recruitment.repository.CompanyRepository;
import com.example.Portal_Recruitment.repository.EmploymentTypeRepository;
import com.example.Portal_Recruitment.repository.ExperienceRepository;
import com.example.Portal_Recruitment.repository.ParticipantExperienceRepository;
import com.example.Portal_Recruitment.repository.ParticipantRepository;
import com.example.Portal_Recruitment.repository.PositionRepository;

@RestController
@RequestMapping("api")
public class ParticipantExperienceRestController {
    
    @Autowired
    private ParticipantExperienceRepository participantExperienceRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EmploymentTypeRepository employmentTypeRepository;

    @PostMapping("experience")
    public ResponseEntity<Object> saveExperience(@RequestBody RequestExperience requestExperience){
        Optional<Participant> participantOpt = participantRepository.findById(requestExperience.getParticipant_id());

        if (!participantOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found");

        }

        Company company = companyRepository.findById(requestExperience.getCompany_id())
                .orElseGet(() -> new Company(requestExperience.getCompany_id(), requestExperience.getName_company()));

        EmploymentType employmentType = employmentTypeRepository.findById(requestExperience.getEmployment_type_id())
                .orElseGet(() -> new EmploymentType(requestExperience.getEmployment_type_id(), requestExperience.getName_employment_type()));

        Position position = positionRepository.findById(requestExperience.getPosition_id())
                .orElseGet(() -> new Position(requestExperience.getPosition_id(), requestExperience.getName_position(), requestExperience.getDescription(), requestExperience.getStart_date(), requestExperience.getEnd_date()));

        company = companyRepository.save(company);
        employmentType = employmentTypeRepository.save(employmentType);
        position = positionRepository.save(position);

        Experience experience = new Experience();
        experience.setCompany(company);
        experience.setEmploymentType(employmentType);
        experience.setPosition(position);
        experience = experienceRepository.save(experience);

        ParticipantExperience participantExperience = new ParticipantExperience();
        participantExperience.setParticipant(participantOpt.get());
        participantExperience.setExperience(experience);
        participantExperienceRepository.save(participantExperience);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created or updated education details");
    }
}
