package com.sumukh.demo.Service;

import com.sumukh.demo.Repo.repo;
import com.sumukh.demo.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService
{
    @Autowired
    repo repo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public void register(Students student){
        student.setPassword(encoder.encode(student.getPassword()));
        repo.save(student);
    }
}
