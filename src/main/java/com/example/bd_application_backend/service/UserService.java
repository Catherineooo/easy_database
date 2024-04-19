package com.example.bd_application_backend.service;

import com.example.bd_application_backend.domain.User;

import java.util.Map;

public interface UserService {
    /**
     * 登录业务逻辑
     * @param username 账户名
     * @param password 密码
     * @return
     */
//    User loginService(String name, String password);
    Map<String, Object> loginService(String username, String password);
    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    User registService(User user);
}