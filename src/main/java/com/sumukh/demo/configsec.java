package com.sumukh.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class configsec {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(adad -> adad.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build() ;

    }

    @Bean
    public AuthenticationProvider authenticator(){
        DaoAuthenticationProvider provide = new DaoAuthenticationProvider();
                 provide
                         .setPasswordEncoder(NoOpPasswordEncoder.getInstance());
                         provide.setUserDetailsService(userDetailsService);

        return provide;
    }
}