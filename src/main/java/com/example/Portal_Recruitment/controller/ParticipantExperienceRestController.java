package com.example.Portal_Recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.RequestExperience;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.*;
import com.example.Portal_Recruitment.repository.*;

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
    public ResponseEntity<Object> saveExperience(@RequestBody RequestExperience requestExperience) {
        Boolean participantExists = participantRepository.findById(requestExperience.getParticipant_id()).isPresent();

        if (participantExists) {
            Company company = companyRepository.findById(requestExperience.getCompany_id())
                    .orElseGet(() -> new Company(requestExperience.getCompany_id(), requestExperience.getName_company()));

            EmploymentType employmentType = employmentTypeRepository.findById(requestExperience.getEmployment_type_id())
                    .orElseGet(() -> new EmploymentType(requestExperience.getEmployment_type_id(),requestExperience.getName_employment_type()));

            Position position = positionRepository.findById(requestExperience.getPosition_id())
                    .orElseGet(() -> new Position(requestExperience.getPosition_id(),
                            requestExperience.getName_position(), requestExperience.getDescription(),
                            requestExperience.getStart_date(), requestExperience.getEnd_date()));

            company = companyRepository.save(company);
            employmentType = employmentTypeRepository.save(employmentType);
            position = positionRepository.save(position);

            Experience experience = new Experience();
            experience.setCompany(company);
            experience.setEmploymentType(employmentType);
            experience.setPosition(position);
            experience = experienceRepository.save(experience);

            ParticipantExperience participantExperience = new ParticipantExperience();
            // participantExperience.setParticipant(participantExists);
            participantExperience.setExperience(experience);
            participantExperienceRepository.save(participantExperience);

            return CustomResponse.generate(HttpStatus.CREATED, "Successfully created or updated experience details");

        }
        return CustomResponse.generate(HttpStatus.NOT_FOUND, "Participant not found");

    }

    @GetMapping("experiences")
    public ResponseEntity<Object> get() {
        List<ParticipantExperience> experiences = participantExperienceRepository.getIdParticipant(1);

        return CustomResponse.generate(HttpStatus.OK, "Data Succesfully Fetched", experiences);
    }
}
