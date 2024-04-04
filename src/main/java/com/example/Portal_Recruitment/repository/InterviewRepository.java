package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.Portal_Recruitment.model.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer>{
    @Query(value = "select * from tb_tr_interview where id = ?1", nativeQuery = true)
    public Interview findByIdInterview(Integer id);  

    @Query(value = "select * from tb_tr_interview where apply_id= ?1", nativeQuery = true)
    public Interview findByApplyId(Integer id);
}