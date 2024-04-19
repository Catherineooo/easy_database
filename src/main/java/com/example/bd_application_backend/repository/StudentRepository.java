package com.example.bd_application_backend.repository;

import com.example.bd_application_backend.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Student> findByName(String name) {
        String sql = "SELECT * FROM students WHERE name = '" + name + "'";
        System.out.println(sql);
        return jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Student(resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("classes"),
                        resultSet.getInt("height"),
                        resultSet.getInt("weight")));
    }

    /*public Student findByName(String name) {
        String sql = "SELECT * FROM students WHERE name = '" + name + "'";
        return (Student) jdbcTemplate.query(sql, (resultSet, rowNum) ->
                new Student(resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("classes"),
                        resultSet.getInt("height"),
                        resultSet.getInt("weight")));
    }*/
}