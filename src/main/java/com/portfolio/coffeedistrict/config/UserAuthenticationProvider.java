package com.portfolio.coffeedistrict.config;

import com.portfolio.coffeedistrict.entities.User;
import com.portfolio.coffeedistrict.enums.UserRole;
import com.portfolio.coffeedistrict.services.AuthService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

    @Component
    public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    AuthService authService;

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = authService.validateLogin(login, password);

        if (user != null) {
            List<GrantedAuthority> roleList = new ArrayList<>();
            roleList.add(new SimpleGrantedAuthority("ROLE_USER"));

            if (user.getRole() == UserRole.ADMIN) {
                roleList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }

            return new UsernamePasswordAuthenticationToken(user, null, roleList);
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}