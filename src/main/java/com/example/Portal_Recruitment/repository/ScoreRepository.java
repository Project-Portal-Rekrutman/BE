package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Portal_Recruitment.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
    
}