package com.sumukh.demo.fliters;

import com.sumukh.demo.Service.JWTclass;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class jwtFilter extends OncePerRequestFilter {
    @Autowired
    JWTclass jwt;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String AuthHeader= request.getHeader("Authorization");
        String token;
        String username;

        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
             token = AuthHeader.substring(7);
             username = jwt.getUsername(token);
            jwt.verify(token);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            
        }
    }
}
