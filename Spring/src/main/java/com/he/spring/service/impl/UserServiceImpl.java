package com.he.spring.service.impl;

import com.he.spring.pojo.User;
import com.he.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public void add(User user) {
        System.out.println("添加用户");
    }

    @Override
    public void delete(User user) {
       System.out.println("删除用户");
    }

    @Override
    public void login(User user) {
        System.out.println("用户登陆");
    }
}
