package com.example.Portal_Recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.repository.ApplyRepository;

@RestController
@RequestMapping("api")
public class ApplyRestController {
    @Autowired
    private ApplyRepository applyRepository;

    @GetMapping("applies")
    public ResponseEntity<Object> get() {
        return CustomResponse.generate(HttpStatus.OK, "Data Successfully Fetched", applyRepository.findAll());
    }

}