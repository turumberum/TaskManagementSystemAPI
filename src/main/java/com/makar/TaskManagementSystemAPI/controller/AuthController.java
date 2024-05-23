package com.makar.TaskManagementSystemAPI.controller;


import com.makar.TaskManagementSystemAPI.security.MyUserDetailsService;
import com.makar.TaskManagementSystemAPI.service.AuthenticationService;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    AuthenticationService authService ;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        boolean authenticated = authService.authenticate(username, password);
        if (authenticated) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
