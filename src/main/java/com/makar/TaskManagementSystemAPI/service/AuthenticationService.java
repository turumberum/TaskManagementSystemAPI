package com.makar.TaskManagementSystemAPI.service;

import com.makar.TaskManagementSystemAPI.model.User;
import com.makar.TaskManagementSystemAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String rawPassword) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            // Проверка пароля
            return passwordEncoder.matches(rawPassword, user.get().getPassword());
        }
        return false;
    }
}
