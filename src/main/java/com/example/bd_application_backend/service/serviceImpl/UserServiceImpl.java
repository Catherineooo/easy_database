package com.example.bd_application_backend.service.serviceImpl;

import com.example.bd_application_backend.domain.User;
import com.example.bd_application_backend.repository.UserDao;
import com.example.bd_application_backend.repository.UserRepository;
import com.example.bd_application_backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
//    因为要用到UserDao中的方法，所以先通过@Resource注解帮助我们实例化UserDao对象
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserDao uerdao;

    @Override
    public Map<String, Object> loginService(String username, String password) {
        Map<String, Object> response = new HashMap<>();
        List<User> users = userRepository.findByUsernameAndPassword(username, password);
        if (users.size() != 0) {
            users.get(0).setPassword(""); // 不返回密码到客户端
            response.put("code", "0");
            response.put("message", "Login successful");
            response.put("user", users.get(0));
        } else {
            response.put("code", "1");
            response.put("message", "Invalid username or password");
        }
        return response;
    }
    @Override
    public User registService(User user) {
        return null;
    }
}
