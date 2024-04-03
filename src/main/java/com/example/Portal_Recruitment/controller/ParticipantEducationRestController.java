package com.example.Portal_Recruitment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Portal_Recruitment.dto.RequestEducation;
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
        Optional<Participant> participantOpt = participantRepository.findById(requestEducation.getParticipant_id());

        if (!participantOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found");
        }

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
        participantEducation.setParticipant(participantOpt.get());
        participantEducation.setAcademic(academic);
        participantEducation.setGpa(participantEducation.getGpa());
        participantEducationRepository.save(participantEducation);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created or updated education details");
    }
}

// package com.example.Portal_Recruitment.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.Portal_Recruitment.dto.RequestEducation;
// import com.example.Portal_Recruitment.model.Academic;
// import com.example.Portal_Recruitment.model.Degree;
// import com.example.Portal_Recruitment.model.Major;
// import com.example.Portal_Recruitment.model.Participant;
// import com.example.Portal_Recruitment.model.ParticipantEducation;
// import com.example.Portal_Recruitment.model.Univ;
// import com.example.Portal_Recruitment.repository.AcademicRepository;
// import com.example.Portal_Recruitment.repository.DegreeRepository;
// import com.example.Portal_Recruitment.repository.MajorRepository;
// import com.example.Portal_Recruitment.repository.ParticipantEducationRepository;
// import com.example.Portal_Recruitment.repository.ParticipantRepository;
// import com.example.Portal_Recruitment.repository.UnivRepository;
// import java.util.Optional;

// @RestController
// @RequestMapping("api")
// public class ParticipantEducationRestController {

//     @Autowired
//     private ParticipantEducationRepository participantEducationRepository;

//     @Autowired
//     private ParticipantRepository participantRepository;

//     @Autowired
//     private AcademicRepository academicRepository;

//     @Autowired
//     private UnivRepository univRepository;

//     @Autowired
//     private MajorRepository majorRepository;

//     @Autowired
//     private DegreeRepository degreeRepository;

//     @PostMapping("education")
//     public ResponseEntity<Object> saveEducation(@RequestBody RequestEducation requestEducation) {
//         Participant participant = participantRepository.findById(requestEducation.getParticipant_id()).orElse(null);
//         if (participant == null) {

//             Univ univ = univRepository.findById(requestEducation.getUniv_id())
//                     .orElseGet(() -> univRepository
//                             .save(new Univ(requestEducation.getUniv_id(), requestEducation.getName_univ())));

//             Major major = majorRepository.findById(requestEducation.getMajor_id())
//                     .orElseGet(() -> majorRepository
//                             .save(new Major(requestEducation.getMajor_id(), requestEducation.getName_academic())));

//             Degree degree = degreeRepository.findById(requestEducation.getDegree_id())
//                     .orElseGet(() -> degreeRepository
//                             .save(new Degree(requestEducation.getDegree_id(), requestEducation.getName_degree())));

//             Academic academic = new Academic();
//             academic.setDegree(degree);
//             academic.setMajor(major);
//             academic.setUniv(univ);
//             academicRepository.save(academic);

//             ParticipantEducation participantEducation = new ParticipantEducation();
//             participantEducation.setParticipant(participant);
//             participantEducation.setAcademic(academic);
//             participantEducation.setGpa(participantEducation.getGpa());
//             participantEducationRepository.save(participantEducation);

//             return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created or updated education details");
            
//         }
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found");
//     }

// }
