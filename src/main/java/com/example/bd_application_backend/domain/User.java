package com.example.bd_application_backend.domain;

//domain中的User.java

import jakarta.persistence.*;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Table;

//import javax.persistence.*;

@Table(name = "user")
@Entity
public class User{
    // 注意属性名要与数据表中的字段名一致
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    // 密码属性varchar对应String
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}