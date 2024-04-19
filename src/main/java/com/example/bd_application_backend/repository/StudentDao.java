package com.example.bd_application_backend.repository;

import com.example.bd_application_backend.domain.Student;
import com.example.bd_application_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


//根据年龄查询学生
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
//    List<Student> findByAge(Integer age);
//@Query(value = "SELECT * FROM students WHERE age = " + userProvidedAge, nativeQuery = true)
    @Query(value = "SELECT * FROM students WHERE age = :age", nativeQuery = true)
    List<Student> findByAge(@Param("age") Integer age);


    @Query(value = "SELECT * FROM students WHERE BINARY name = :name", nativeQuery = true)
//    @Query(value = "SELECT * FROM students WHERE name = "+ name, nativeQuery = true)
    List<Student> findByName(@Param("name") String name);


}



