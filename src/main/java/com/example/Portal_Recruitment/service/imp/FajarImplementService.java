package com.example.Portal_Recruitment.service.imp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Portal_Recruitment.dto.RequestAmartek;
import com.example.Portal_Recruitment.handler.CustomResponse;
import com.example.Portal_Recruitment.model.Amartek;
import com.example.Portal_Recruitment.model.Vacancy;
import com.example.Portal_Recruitment.repository.AmartekRepository;
import com.example.Portal_Recruitment.service.FajarService;

@Service
public class FajarImplementService implements FajarService {
    @Autowired
    private AmartekRepository amartekRepository;

    @Override
    public ResponseEntity<Object> codeKata(String kata) {
        int counta = 0;
        int counti = 0;
        int countu = 0;
        int counte = 0;
        int counto = 0;
        int countnonvokal = 0;

        Map<String, Integer> response = new HashMap<>();
        for (int i = 0; i < kata.length(); i++) {
            //indonesia
            if (kata.charAt(i) == 'a') {

                counta++;
                response.put("a", counta);

            } else if (kata.charAt(i) == 'i') {
                counti++;
                response.put("i", counti);

            } else if (kata.charAt(i) == 'u') {
                countu++;
                response.put("u", countu);

            } else if (kata.charAt(i) == 'e') {
                counte++;
                response.put("e", counte);

            } else if (kata.charAt(i) == 'o') {
                counto++;
                response.put("o", counto);

            } else {
                countnonvokal++;
                response.put("nonvokal", countnonvokal);
            }

        }
        return CustomResponse.generate(HttpStatus.OK, "success", response);
    }

    @Override
    public ResponseEntity<Object> createdData(RequestAmartek requestAmartek) {

        if (requestAmartek.getName().equals("") || requestAmartek.getName() == null
                || requestAmartek.getTanggalLahir().isEmpty() || requestAmartek.getTanggalLahir() == null) {
            return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Cek Your Input");
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//untuk memformat atau mem-parse string tanggal
        //variable date time tipedatanya adalah sebuah object  LocalDateTime  yang valuenya berdasarkan konversi  string berdasarkan format yang telah ditentukan oleh formatter
        LocalDateTime dateTime = LocalDateTime.parse(requestAmartek.getTanggalLahir(), formatter); 
        Amartek amartek = new Amartek();
        amartek.setName(requestAmartek.getName());
        amartek.setTanggalLahir(dateTime);
        amartek.setUmur(requestAmartek.getUmur());

       
        Amartek result = amartekRepository.save(amartek);

        // is present untuk mengecek apa datanya atau tidak
        if (amartekRepository.findById(result.getId()).isPresent()) {
            return CustomResponse.generate(HttpStatus.CREATED, "Data Successfully Added");
        }

        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "Error Adding Data");
    }

    

    @Override
    public ResponseEntity<Object> FindAll() {
        return CustomResponse.generate(HttpStatus.OK, "success view data", amartekRepository.findAll());
    }

}
