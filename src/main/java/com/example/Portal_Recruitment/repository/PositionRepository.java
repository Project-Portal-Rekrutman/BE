package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{
    
}
