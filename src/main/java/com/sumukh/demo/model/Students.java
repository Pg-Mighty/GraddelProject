package com.sumukh.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Students {

    @Id
    int id;
    String name;
    String password;


    public Students(int id ,String name){
        this.id = id;
        this.name = name;
    }

    public Students() {

    }



    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
