package com.sumukh.demo.fliters;

import com.sumukh.demo.Service.JWTclass;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class jwtFilter extends OncePerRequestFilter {
    @Autowired
    JWTclass jwt;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String AuthHeader= request.getHeader("Authorization");
        String token = null;
        String username = null;

        if(AuthHeader != null && AuthHeader.startsWith("Bearer ")){
             token = AuthHeader.substring(7);
             username = jwt.getUsername(token);

        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails user= context.getBean(UserDetailsService.class).loadUserByUsername(username);

            if(jwt.verify(token, username)){
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }
}
