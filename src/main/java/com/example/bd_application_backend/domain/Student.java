package com.example.bd_application_backend.domain;

import jakarta.persistence.*;
@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private Integer age;

    public Student(String name, Integer age, Integer classes, Integer height, Integer weight) {
        this.name = name;
        this.age = age;
        this.classes = classes;
        this.height = height;
        this.weight = weight;
    }

    private Integer classes;
    private  Integer height;

    public Student() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getClasses() {
        return classes;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    private  Integer weight;
}


//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Table;

//import javax.persistence.*;

