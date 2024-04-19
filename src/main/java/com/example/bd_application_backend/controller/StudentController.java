package com.example.bd_application_backend.controller;

import com.example.bd_application_backend.domain.LoginRequest;
import com.example.bd_application_backend.domain.Student;
import com.example.bd_application_backend.domain.User;
import com.example.bd_application_backend.service.StudentService;
import com.example.bd_application_backend.service.UserService;
import com.example.bd_application_backend.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
//待修改

@RestController
@RequestMapping("/query")
public class StudentController {
    @Resource
    private StudentService studentService;

    @PostMapping("age")
    public List<Student> QueryAgeController(@RequestBody Map<String, Integer> requestBody) {

        Integer age = requestBody.get("age");
        System.out.println("age="+age);
        List<Student> students;
        if (age == null) {
            // 如果age为空值，返回所有学生数据
            students = studentService.getAllStudents();
        } else {
            // 如果age不为空值，按照age查询学生数据
            students = studentService.QueryService(age);
        }
        return students;
    }

    @PostMapping("name")
    public List<Student> QueryNameController(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        System.out.println("name="+name);
        List<Student> students;

        students = studentService.QueryNameService(name);
        return students;
    }
}
//        if (name == "" || name == null) {
//            // 如果age为空值，返回所有学生数据
//            students = studentService.getAllStudents();
//        } else {
//            // 如果age不为空值，按照age查询学生数据
//
//        }