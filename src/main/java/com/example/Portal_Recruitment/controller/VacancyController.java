package com.example.Portal_Recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Portal_Recruitment.dto.RequestVacancy;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.Vacancy;
import com.example.Portal_Recruitment.repository.VacancyRepository;

@Controller
@RequestMapping("api")
public class VacancyController {
    
    @Autowired
    private VacancyRepository vacancyRepository;


    @PostMapping("vacancy")
    public ResponseEntity<Object> save(@RequestBody Vacancy vacancy){

        vacancy.setStatus("aktif");
     
        if (vacancy.getDescription().equals("")|| 
        vacancy.getQualification().equals("")|| 
        vacancy.getSalary().equals(null)||   
        vacancy.getTitle().equals("")) {
            return CustomResponse.generate(HttpStatus.BAD_REQUEST,
            "the field cannot be empty, check your input");
        }
        
        Vacancy result =vacancyRepository.save(vacancy);

        if (vacancyRepository.findById(result.getId()).isPresent()) {
            return CustomResponse.generate(HttpStatus.OK, "Data Successfully Added");
        }

        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Error Adding Data");
    }


    @GetMapping("vacancy/{id}")
    public ResponseEntity<Object>getId(@PathVariable(required = true) Integer id) {
        Vacancy vacancy = vacancyRepository.FindVacancy(id);

        if (vacancy == null) {
            return CustomResponse.generate(HttpStatus.OK, "Not Found");
        }
        return CustomResponse.generate(HttpStatus.OK, "Berhasil Menampilkan data", vacancy);
    }


    @PostMapping("vacancy/{id}")
    public ResponseEntity<Object>Update(@RequestBody RequestVacancy requestVacancy,@PathVariable(required = true) Integer id) {
        Vacancy vacancy = vacancyRepository.FindVacancy(id);
        if (vacancy == null) {
            return CustomResponse.generate(HttpStatus.OK, "Not Found");
        }
        if (requestVacancy.getDescription().equals("")|| requestVacancy.getStatus().equals("")) {
            return CustomResponse.generate(HttpStatus.BAD_REQUEST,
            "the field cannot be empty, check your input");
            
        }

        vacancy.setDescription(requestVacancy.getDescription());
        vacancy.setStatus(requestVacancy.getStatus());
        vacancy.setQualification(requestVacancy.getQualification());
        vacancy.setSalary(requestVacancy.getSalary());

        vacancyRepository.save(vacancy);

        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Updated Data");
    }

    @GetMapping("vacancys")
    public ResponseEntity<Object> get() {
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Fetched", vacancyRepository.findAll());
    }

}
