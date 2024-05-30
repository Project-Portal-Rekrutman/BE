package com.example.Portal_Recruitment.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_amartek")
public class Amartek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama")
    private String name;

    @Column(name = "tanggal_lahir")
    private LocalDateTime tanggalLahir;

    @Column(name = "umur")
    private Integer umur;

    @Column(name = "email")
    private Integer email;

    @Column(name = "password")
    private Integer password;

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Set<RoleUser> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<RoleUser> roleUsers) {
        this.roleUsers = roleUsers;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "amartek")
    private Set<RoleUser> roleUsers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Amartek() {
    }

    public LocalDateTime getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDateTime tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

}
