package com.example.Portal_Recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Portal_Recruitment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
       @Query("""
            SELECT u FROM User u WHERE u.email = ?1
            """)
    public User authenticate(String email);


    @Query("""
        SELECT u FROM User u  JOIN u.role r WHERE u.email = ?1
        """)
public User getrole(String email);
  
}
