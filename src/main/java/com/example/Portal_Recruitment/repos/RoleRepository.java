package com.example.Portal_Recruitment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
