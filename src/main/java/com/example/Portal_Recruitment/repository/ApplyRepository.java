package com.example.Portal_Recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Portal_Recruitment.model.Apply;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Integer> {
    @Query(value = "select * from tb_tr_apply a join tb_m_participant p ON p.id = a.participant_id join tb_m_vacancy v ON v.id = a.vacancy_id where a.id = ?1", nativeQuery = true)
    public Apply findByIdApply(Integer id);

    @Query(value = "Select * from tb_tr_apply where id= ?1", nativeQuery = true)
    public Apply getIdApply(Integer Id);

    @Query(value = "SELECT 'Send Application' AS Progress, ap.application_status AS Status, ap.application_date AS Date "
            +
            "FROM tb_tr_apply ap " +
            "WHERE ap.id = ?1 " +
            "UNION ALL " +
            "SELECT 'Screening CV' AS Progress, ap.screening_status AS Status, ap.screening_date AS Date " +
            "FROM tb_tr_apply ap " +
            "WHERE ap.id = ?1 " +
            "UNION ALL " +
            "SELECT 'Interview' AS Progress, te.interview_status AS Status, te.interview_status_date AS Date " +
            "FROM tb_tr_apply ap " +
            "LEFT JOIN tb_tr_interview te ON te.apply_id = ap.id " +
            "WHERE ap.id = ?1", nativeQuery = true)
    public List<Object[]> getProgress(Integer Id);

    @Query(value = "Select * from tb_tr_apply a where participant_id= ?1", nativeQuery = true)
    public List<Apply> getIdParticipant(Integer Id);
}
