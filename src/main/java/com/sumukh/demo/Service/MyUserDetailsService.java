package com.sumukh.demo.Service;

import com.sumukh.demo.Repo.repo;
import com.sumukh.demo.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

   @Autowired
   repo repo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Students student = repo.findByUsername("Sumukh");

        if(student != null){
            System.out.println("User Found");

        }else{
            throw new UsernameNotFoundException("User Not Found");
        }
        return null;
    }
}
