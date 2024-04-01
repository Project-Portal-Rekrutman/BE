package com.example.Portal_Recruitment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Portal_Recruitment.models.Apply;
import com.example.Portal_Recruitment.models.Interview;

public interface ApplyRepository extends JpaRepository<Apply, Integer>{
    @Query(value = "select * from tb_tr_apply a join tb_m_participant p ON p.id = a.participant_id join tb_m_vacancy v ON v.id = a.vacancy_id where a.id = ?1", nativeQuery = true)
    public Apply findByIdApply(Integer id); 
}
