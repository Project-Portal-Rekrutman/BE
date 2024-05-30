package com.example.Portal_Recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Portal_Recruitment.dto.RequestAmartek;
import com.example.Portal_Recruitment.service.FajarService;

@Controller
@RequestMapping("api")
public class FajarRestController {
    @Autowired
    private FajarService fajarService;

    @PostMapping("created")
    public ResponseEntity<Object> createdData(@RequestBody RequestAmartek requestAmartek) {
        return fajarService.createdData(requestAmartek);
    }

    @GetMapping("view")
    public ResponseEntity<Object> ViewData(@RequestBody RequestAmartek requestAmartek) {
        return fajarService.FindAll();
    }

    @GetMapping("code")
    public ResponseEntity<Object> cekCode(@RequestParam("kata") String kata){
        return fajarService.codeKata(kata);
    }

    @PostMapping("code")
    public ResponseEntity<Object> ceKalimat(@RequestBody String kata){
        return fajarService.codeKata(kata);
    }
}
