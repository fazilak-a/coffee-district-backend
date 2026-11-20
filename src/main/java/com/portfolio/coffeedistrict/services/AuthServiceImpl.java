package com.portfolio.coffeedistrict.services;

import com.portfolio.coffeedistrict.dto.SignUpModel;
import com.portfolio.coffeedistrict.entities.User;
import com.portfolio.coffeedistrict.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public User validateLogin(String email, String password) {


        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }




    @Override
    public User signup(SignUpModel model) {


        if (userRepository.existsByEmail(model.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }


        User user = new User();
        user.setFullName(model.getFullName());
        user.setEmail(model.getEmail());


        String encodedPassword = passwordEncoder.encode(model.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

}