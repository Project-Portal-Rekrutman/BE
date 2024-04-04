package com.example.Portal_Recruitment.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.Apply;
import com.example.Portal_Recruitment.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    @Query(value = "Select * from tb_m_role where name= ?1", nativeQuery = true)
    public Role getRoles(Collection<? extends GrantedAuthority> authorities);

    
}
