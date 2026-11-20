package com.portfolio.coffeedistrict.controllers;

import com.portfolio.coffeedistrict.dto.SignUpModel;
import com.portfolio.coffeedistrict.dto.UserResponseModel;
import com.portfolio.coffeedistrict.entities.User;
import com.portfolio.coffeedistrict.repositories.UserRepository;
import com.portfolio.coffeedistrict.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping(value = "/auth")
    public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody SignUpModel model) {
        try {
            User user = authService.signup(model);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/me")
    public ResponseEntity<UserResponseModel> getCurrentUser(
            Authentication authentication
    ) {


        User sessionUser = (User) authentication.getPrincipal();
        User user = userRepository.findById(sessionUser.getId())
                .orElseThrow(() ->
                        new RuntimeException("Authenticated user not found"));


        UserResponseModel dto = new UserResponseModel(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getRole()
        );

        return ResponseEntity.ok(dto);
    }



    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok().build();
    }


}