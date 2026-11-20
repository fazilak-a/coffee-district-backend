package com.portfolio.coffeedistrict.dto;
import com.portfolio.coffeedistrict.enums.UserRole;



public class UserResponseModel {
    private Long id;
    private String email;
    private String fullName;
    private UserRole role;


    public UserResponseModel(
            Long id,
            String email,
            String fullName,
            UserRole role
    ) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
    }


    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getFullName() {
        return fullName;
    }
    public UserRole getRole() {
        return role;
    }
}

