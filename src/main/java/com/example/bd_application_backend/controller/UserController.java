package com.example.bd_application_backend.controller;

import com.example.bd_application_backend.domain.LoginRequest;
import com.example.bd_application_backend.domain.User;
import com.example.bd_application_backend.service.UserService;
import com.example.bd_application_backend.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public Map<String, Object> loginController(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        System.out.println("username="+username);
        // 调用userService的loginService方法进行登录逻辑处理

        Map<String, Object> response = userService.loginService(username, password);
        return response;

    }
}