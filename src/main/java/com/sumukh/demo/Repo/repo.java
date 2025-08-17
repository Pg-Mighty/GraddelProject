package com.sumukh.demo.Repo;

import com.sumukh.demo.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface repo extends JpaRepository<Students, Integer> {


    Students findByName(String username);


}
