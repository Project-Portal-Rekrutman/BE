package com.example.Portal_Recruitment.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Portal_Recruitment.model.User;
import com.example.Portal_Recruitment.repository.UserRepository;


@Service
public class MyUserDetails implements UserDetails, UserDetailsService {
    private String username;
    private String password;
    private GrantedAuthority authority;
    
    @Autowired
    private UserRepository userRepository;

    public MyUserDetails() {
    }

    public MyUserDetails(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = new SimpleGrantedAuthority(authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(authority);
        return grantedAuthority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User responseLogin = new User();
        try { 
            responseLogin = userRepository.authenticate(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            responseLogin = userRepository.authenticate(username);
        }

        return new MyUserDetails(responseLogin.getEmail(),
        responseLogin.getPassword(),
        responseLogin.getRole().getName());
      
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserRepository getEmployeeRepository() {
        return userRepository;
    }

    public void setEmployeeRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
