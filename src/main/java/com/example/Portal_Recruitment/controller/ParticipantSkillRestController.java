package com.example.Portal_Recruitment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.dto.RequestSkill;
import com.example.Portal_Recruitment.model.Participant;
import com.example.Portal_Recruitment.model.ParticipantSkill;
import com.example.Portal_Recruitment.model.Skill;
import com.example.Portal_Recruitment.model.SkillType;
import com.example.Portal_Recruitment.repository.ParticipantRepository;
import com.example.Portal_Recruitment.repository.ParticipantSkillRepository;
import com.example.Portal_Recruitment.repository.SkillRepository;
import com.example.Portal_Recruitment.repository.SkillTypeRepository;

@RestController
@RequestMapping("api")
public class ParticipantSkillRestController {
    
    @Autowired
    private ParticipantSkillRepository participantSkillRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillTypeRepository skillTypeRepository;

    @PostMapping("skill")
    public ResponseEntity<Object> saveSkill(@RequestBody RequestSkill requestSkill) {
        Optional<Participant> participantOpt = participantRepository.findById(requestSkill.getParticipant_id());

        if (!participantOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found");

        }

        SkillType skillType = skillTypeRepository.findById(requestSkill.getSkill_type_id())
                .orElseGet(() -> new SkillType(requestSkill.getSkill_type_id(), requestSkill.getName_skill_type()));
        
        skillType = skillTypeRepository.save(skillType);

        Skill skill = new Skill();
        skill.setSkillType(skillType);
        skill = skillRepository.save(skill);

        ParticipantSkill participantSkill = new ParticipantSkill();
        participantSkill.setParticipant(participantOpt.get());
        participantSkill.setSkill(skill);
        participantSkillRepository.save(participantSkill);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created or updated skills details");
    }
}
