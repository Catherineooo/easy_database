package com.example.bd_application_backend.repository;

import com.example.bd_application_backend.domain.Student;
import com.example.bd_application_backend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
//    private final JdbcTemplate jdbcTemplate;

//    @Autowired
//    public UserRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<User> findByUsernameAndPassword(String username, String password) {
//        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
//        System.out.println(sql);
//        System.out.println(username);
//
//        return jdbcTemplate.query(sql, new Object[]{username, password}, (resultSet, rowNum) ->
//                new User(resultSet.getString("username"),
//                        resultSet.getString("password")));
//    }
    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> findByUsernameAndPassword(String username, String password) {

        String sql = "SELECT * FROM user WHERE BINARY username = '" + username + "'" + " and password = '"+ password + "'";
        System.out.println(sql);
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new User(resultSet.getString("username"),
                        resultSet.getString("password")));
    }

}