package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Completion;

@Repository
public interface CompletionRepository extends JpaRepository<Completion, Integer> {
    @Query(value = "Select sum(personal_data + education_data + experience_data + skill_data + license_certification_data) as total from tb_tr_completion where id= ?1", nativeQuery = true)
    public Integer getSum(Integer Id);
}
