package com.portfolio.coffeedistrict.services;
import com.portfolio.coffeedistrict.dto.SignUpModel;
import com.portfolio.coffeedistrict.entities.User;




public interface AuthService {
    User signup(SignUpModel model);
    User validateLogin(String login, String password);


}