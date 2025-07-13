package com.sumukh.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Students {

    @Id
    int roll;
    String name;
    String password;


    public Students(int id ,String name){
        this.roll = id;
        this.name = name;
    }

    public Students() {

    }


    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }
}
