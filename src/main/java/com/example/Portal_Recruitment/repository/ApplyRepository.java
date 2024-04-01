package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Apply;

@Repository
public interface ApplyRepository extends JpaRepository<Apply,Integer>{
    @Query(value = "Select * from tb_tr_apply where id= ?1", nativeQuery = true)
    public Apply getIdApply(Integer Id);

}