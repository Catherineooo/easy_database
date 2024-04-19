package com.example.bd_application_backend.service;

import com.example.bd_application_backend.domain.Student;
import com.example.bd_application_backend.domain.User;

import java.util.List;

public interface StudentService {
    /**
     * 查询年龄逻辑
     * @param age 年龄
     * @return
     */
    List<Student> QueryService(Integer age);

    List<Student> QueryNameService(String name);

    List<Student> getAllStudents();
}