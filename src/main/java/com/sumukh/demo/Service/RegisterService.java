package com.sumukh.demo.Service;

import com.sumukh.demo.Repo.repo;
import com.sumukh.demo.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService
{
    @Autowired
    repo repo;

    @Autowired
    JWTclass jwt;

    @Autowired
    AuthenticationManager authenticationManager;


    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


    public void register(Students student){
        student.setPassword(encoder.encode(student.getPassword()));
        repo.save(student);
    }



    public String verify(Students student){
    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getName(),student.getPassword()));
        System.out.println("From: RegisterService: ");
            if(authenticate.isAuthenticated()){
                return jwt.generate(student.getName());
            }
            return "Not Authenticated";

    }
}
