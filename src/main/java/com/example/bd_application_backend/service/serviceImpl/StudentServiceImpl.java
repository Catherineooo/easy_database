package com.example.bd_application_backend.service.serviceImpl;

import com.example.bd_application_backend.domain.Student;
import com.example.bd_application_backend.domain.User;
import com.example.bd_application_backend.repository.StudentDao;
import com.example.bd_application_backend.repository.StudentRepository;
import com.example.bd_application_backend.repository.UserDao;
import com.example.bd_application_backend.service.StudentService;
import com.example.bd_application_backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Resource
    private StudentRepository studentRepository;
    @Override
    public List<Student> QueryService(Integer age) {
        List<Student> students = studentDao.findByAge(age);
        return students;
    }

    @Override
    public List<Student> QueryNameService(String name) {
        List<Student> students = (List<Student>) studentRepository.findByName(name);
        return students;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentDao.findAll();
        return students;
    }
    //    因为要用到UserDao中的方法，所以先通过@Resource注解帮助我们实例化UserDao对象

}
