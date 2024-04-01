package com.example.Portal_Recruitment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Portal_Recruitment.models.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
    
}