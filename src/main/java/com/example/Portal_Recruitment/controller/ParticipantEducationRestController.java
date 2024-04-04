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
import com.example.Portal_Recruitment.dto.RequestEducation;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.*;
import com.example.Portal_Recruitment.repository.*;

@RestController
@RequestMapping("api")
public class ParticipantEducationRestController {

    @Autowired
    private ParticipantEducationRepository participantEducationRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private AcademicRepository academicRepository;

    @Autowired
    private UnivRepository univRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private DegreeRepository degreeRepository;

    @PostMapping("education")
    public ResponseEntity<Object> saveEducation(@RequestBody RequestEducation requestEducation) {
        Boolean participantExists = participantRepository.findById(requestEducation.getParticipant_id()).isPresent();

        if (participantExists) {
            Univ univ = univRepository.findById(requestEducation.getUniv_id())
                    .orElseGet(() -> new Univ(requestEducation.getUniv_id(), requestEducation.getName_univ()));

            Major major = majorRepository.findById(requestEducation.getMajor_id())
                    .orElseGet(() -> new Major(requestEducation.getMajor_id(), requestEducation.getName_major()));

            Degree degree = degreeRepository.findById(requestEducation.getDegree_id())
                    .orElseGet(() -> new Degree(requestEducation.getDegree_id(), requestEducation.getName_degree()));

            univ = univRepository.save(univ);
            major = majorRepository.save(major);
            degree = degreeRepository.save(degree);

            Academic academic = new Academic();
            academic.setDegree(degree);
            academic.setMajor(major);
            academic.setUniv(univ);
            academic = academicRepository.save(academic);

            ParticipantEducation participantEducation = new ParticipantEducation();
            // participantEducation.setParticipant(participantExists);
            participantEducation.setAcademic(academic);
            participantEducation.setGpa(requestEducation.getGpa());
            participantEducationRepository.save(participantEducation);

            return CustomResponse.generate(HttpStatus.CREATED, "Successfully created education details");

        }
        return CustomResponse.generate(HttpStatus.NOT_FOUND, "Participant not found");
    }

    @GetMapping("educations")
    public ResponseEntity<Object> get() {
        List<ParticipantEducation> list = participantEducationRepository.findAll();

        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Fetched", list);
    }

}
