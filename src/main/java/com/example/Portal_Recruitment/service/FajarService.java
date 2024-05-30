package com.example.Portal_Recruitment.service;

import org.springframework.http.ResponseEntity;

import com.example.Portal_Recruitment.dto.RequestAmartek;

public interface FajarService {
    public ResponseEntity<Object> createdData(RequestAmartek requestAmartek);

    public ResponseEntity<Object> FindAll();

    public ResponseEntity<Object> codeKata(String kata);
}
