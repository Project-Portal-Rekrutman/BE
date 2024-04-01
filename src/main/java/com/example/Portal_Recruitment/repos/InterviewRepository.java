package com.example.Portal_Recruitment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Portal_Recruitment.models.Interview;


public interface InterviewRepository extends JpaRepository<Interview, Integer>{
    @Query(value = "select * from tb_tr_interview where id = ?1", nativeQuery = true)
    public Interview findByIdInterview(Integer id);  
}