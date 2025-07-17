package com.sumukh.demo.Controller;


import com.sumukh.demo.Service.RegisterService;
import com.sumukh.demo.model.Students;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllALL {

    @Autowired
    RegisterService registerService ;
    List<Students> list = new ArrayList<>();


    @PostMapping("/signup")
        public void signup(@RequestBody Students student){

            registerService.register(student);
    }

    @PostMapping("/login")
    public void login(@RequestBody Students student){

        loginServie verify(student);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Students students){
        list.add(students);
    }

    @GetMapping("/")
    String greet(HttpServletRequest request){
    return "Hello World"+ request.getSession().getId() ;
    }

    @GetMapping("/students")
    public List<Students> getStudents(){
        list.add(new Students(0, "Dummy"));    // index 0
        list.add(1, new Students(1, "Sumukh"));
        return list;
    }


}
