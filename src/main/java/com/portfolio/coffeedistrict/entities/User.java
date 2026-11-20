package com.portfolio.coffeedistrict.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.coffeedistrict.enums.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;


    @Entity
    @Table(name = "user")
    public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true)
    @JsonIgnore
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }


        if (role == null) {
            role = UserRole.USER;
        }
    }



    // Getters
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getFullName() {
        return fullName;
    }
    public String getPassword() {
        return password;
    }
    public UserRole getRole() {
        return role;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }



    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}