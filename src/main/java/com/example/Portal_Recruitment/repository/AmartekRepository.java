package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Amartek;


// mewarisi semua metode yang telah didefinisikan dalam JpaRepository; 
// repository ini akan memiliki akses ke semua metode yang telah diimplementasikan 
// memiliki akses langsung tanpa perlu mendefinisikannya 
@Repository
public interface AmartekRepository extends JpaRepository<Amartek, Integer> {

}
